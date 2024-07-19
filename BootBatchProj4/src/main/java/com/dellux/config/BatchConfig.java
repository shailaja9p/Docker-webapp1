package com.dellux.config;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.data.MongoItemWriter;
import org.springframework.batch.item.data.builder.MongoItemWriterBuilder;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.dellux.listener.JobMonitoringListener;
import com.dellux.model.ExamResult;
import com.dellux.processor.ExamResultProcessor;


@Configuration
@EnableBatchProcessing
public class BatchConfig {
	@Autowired
	private JobBuilderFactory jbFactory;
	@Autowired
	private StepBuilderFactory stFactory;
	
	@Autowired
	private ExamResultProcessor processor;
	
	@Autowired
	private JobMonitoringListener listener;
	
	@Autowired
	private MongoTemplate template;
	/*
	 * @Bean public FlatFileItemReader<ExamResult> createReader() {
	 * System.out.println("BatchConfig.createReader()"); FlatFileItemReader reader =
	 * new FlatFileItemReader(); reader.setResource(new
	 * ClassPathResource("EmployeeInfo.csv"));
	 * 
	 * DefaultLineMapper<ExamResult> lineMapper = new
	 * DefaultLineMapper<ExamResult>();
	 * 
	 * DelimitedLineTokenizer tokenizer = new DelimitedLineTokenizer();
	 * tokenizer.setDelimiter(",");
	 * tokenizer.setNames("eno","ename","eadd","salary");
	 * 
	 * lineMapper.setLineTokenizer(tokenizer);
	 * 
	 * BeanWrapperFieldSetMapper<ExamResult> wrapper = new
	 * BeanWrapperFieldSetMapper<ExamResult>();
	 * wrapper.setTargetType(ExamResult.class);
	 * 
	 * lineMapper.setFieldSetMapper(wrapper);
	 * 
	 * reader.setLineMapper(lineMapper);
	 * 
	 * return reader;
	 * 
	 * 
	 * }
	 */
	@Bean
	public FlatFileItemReader<ExamResult> createReader() {
		System.out.println("BatchConfig.createReader()");
		return new FlatFileItemReaderBuilder<ExamResult>()
				.name("ffiReader")
				.resource(new ClassPathResource("TopBrains.csv"))
				.delimited()
				.delimiter(",")
				.names("id","dob","semester","percentage")
				.targetType(ExamResult.class)
				.build();
	}
	
	@Bean
	public MongoItemWriter<ExamResult> createWriter(){
		return new MongoItemWriterBuilder<ExamResult>()
				.collection("SuperBrains")
				.template(template)
				.build();
	}
	
	/*
	 * @Bean public JdbcBatchItemWriter<ExamResult> createWriter(){
	 * System.out.println("BatchConfig.createWriter()");
	 * JdbcBatchItemWriter<ExamResult> writer = new
	 * JdbcBatchItemWriter<ExamResult>(); writer.setDataSource(ds);
	 * 
	 * writer.
	 * setSql("INSERT INTO BATCH_EMPLOYEE_INFOR VALUES(:eno,:ename,:eadd,:salary,:grossSalary,:netSalary)"
	 * );
	 * 
	 * BeanPropertyItemSqlParameterSourceProvider<ExamResult> sourceProvider = new
	 * BeanPropertyItemSqlParameterSourceProvider<ExamResult>();
	 * writer.setItemSqlParameterSourceProvider(sourceProvider);
	 * 
	 * return writer;
	 * 
	 * }
	 */
	
	@Bean(name="step1")
	public Step createStep1() {
		System.out.println("BatchConfig.createStep1()");
		return stFactory.get("step1")
				.<ExamResult,ExamResult>chunk(10)
				.reader(createReader())
				.writer(createWriter())
				.processor(processor)
				.build();
	}
	
	@Bean(name="job1")
	public Job createJob1() {
		System.out.println("BatchConfig.createJob1()");
		return jbFactory.get("job1")
				.incrementer(new RunIdIncrementer())
				.listener(listener)
				.start(createStep1())
				.build();
				
		
	}

}
