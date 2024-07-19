package com.dellux.config;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.ItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import com.dellux.listener.JobMonitoringListener;
import com.dellux.model.Employee;
import com.dellux.processor.EmployeeItemProcessor;

@Configuration
@EnableBatchProcessing
public class BatchConfig {
	@Autowired
	private JobBuilderFactory jbFactory;
	@Autowired
	private StepBuilderFactory stFactory;

	@Autowired
	private EmployeeItemProcessor processor;

	@Autowired
	private JobMonitoringListener listener;

	@Autowired
	private DataSource ds;

	/*
	 * @Bean public FlatFileItemReader<Employee> createReader() {
	 * System.out.println("BatchConfig.createReader()"); FlatFileItemReader reader =
	 * new FlatFileItemReader(); reader.setResource(new
	 * ClassPathResource("EmployeeInfo.csv"));
	 * 
	 * DefaultLineMapper<Employee> lineMapper = new DefaultLineMapper<Employee>();
	 * 
	 * DelimitedLineTokenizer tokenizer = new DelimitedLineTokenizer();
	 * tokenizer.setDelimiter(",");
	 * tokenizer.setNames("eno","ename","eadd","salary");
	 * 
	 * lineMapper.setLineTokenizer(tokenizer);
	 * 
	 * BeanWrapperFieldSetMapper<Employee> wrapper = new
	 * BeanWrapperFieldSetMapper<Employee>(); wrapper.setTargetType(Employee.class);
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

	/*
	 * @Bean public JdbcBatchItemWriter<Employee> createWriter(){
	 * System.out.println("BatchConfig.createWriter()");
	 * JdbcBatchItemWriter<Employee> writer = new JdbcBatchItemWriter<Employee>();
	 * writer.setDataSource(ds);
	 * 
	 * writer.
	 * setSql("INSERT INTO BATCH_EMPLOYEE_INFOR VALUES(:eno,:ename,:eadd,:salary,:grossSalary,:netSalary)"
	 * );
	 * 
	 * BeanPropertyItemSqlParameterSourceProvider<Employee> sourceProvider = new
	 * BeanPropertyItemSqlParameterSourceProvider<Employee>();
	 * writer.setItemSqlParameterSourceProvider(sourceProvider);
	 * 
	 * return writer;
	 * 
	 * }
	 */

	/*
	 * @Bean public FlatFileItemReader<Employee> createReader() {
	 * FlatFileItemReader<Employee> reader = new FlatFileItemReader<Employee>();
	 * reader.setResource(new ClassPathResource("EmployeeInfo.csv"));
	 * reader.setLineMapper(new DefaultLineMapper<Employee>() { {
	 * setLineTokenizer(new DelimitedLineTokenizer() { { setDelimiter(",");
	 * setNames("eno", "ename", "eadd", "salary"); } }); setFieldSetMapper(new
	 * BeanWrapperFieldSetMapper<Employee>() { { setTargetType(Employee.class); }
	 * });
	 * 
	 * } }); return reader; }
	 */
	 /* @Bean public JdbcBatchItemWriter<Employee> createWriter() {
	 * System.out.println("BatchConfig.createWriter()");
	 * JdbcBatchItemWriter<Employee> writer = new JdbcBatchItemWriter<Employee>() {{
	 * 
	 * setDataSource(ds);
	 * setSql("INSERT INTO BATCH_EMPLOYEE_INFOR VALUES(:eno,:ename,:eadd,:salary,:grossSalary,:netSalary)"
	 * ); setItemSqlParameterSourceProvider(new
	 * BeanPropertyItemSqlParameterSourceProvider<Employee>()); }};
	 * 
	 * return writer; }
	 */
	@Bean
	public FlatFileItemReader<Employee> createReader(){
		return new FlatFileItemReaderBuilder<Employee>()
				.name("fileReader")
				.resource(new ClassPathResource("EmployeeInfo.csv"))
				.delimited()
				.names("eno","ename","eadd","salary")
				.targetType(Employee.class)
				.build();
				
	}
	
	@Bean
	public JdbcBatchItemWriter<Employee> createWriter(){
		return new JdbcBatchItemWriterBuilder<Employee>()
				.dataSource(ds)
				.sql("INSERT INTO BATCH_EMPLOYEE_INFOR VALUES(:eno,:ename,:eadd,:salary,:grossSalary,:netSalary)")
				.beanMapped()
				.build();
	}
	
	
	@Bean(name = "step1")
	public Step createStep1() {
		System.out.println("BatchConfig.createStep1()");
		return stFactory.get("step1").<Employee, Employee>chunk(10).reader(createReader()).writer(createWriter())
				.processor(processor).build();
	}

	@Bean(name = "job1")
	public Job createJob1() {
		System.out.println("BatchConfig.createJob1()");
		return jbFactory.get("job1").incrementer(new RunIdIncrementer()).listener(listener).start(createStep1())
				.build();

	}

}
