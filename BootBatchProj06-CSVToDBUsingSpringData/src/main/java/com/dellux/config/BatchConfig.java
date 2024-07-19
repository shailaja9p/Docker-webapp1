package com.dellux.config;

import javax.persistence.EntityManagerFactory;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.database.JpaItemWriter;
import org.springframework.batch.item.database.builder.JpaItemWriterBuilder;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import com.dellux.listener.JobMonitoringListener;
import com.dellux.model.IExamResult;
import com.dellux.model.OExamResult;
import com.dellux.processor.ExamResultItemProcessor;

@Configuration
@EnableBatchProcessing
public class BatchConfig {
	
	@Autowired
	private JobBuilderFactory jobFactory;
	
	@Autowired
	private StepBuilderFactory stepFactory;
	
	@Autowired
	private EntityManagerFactory factory;
	
	@Autowired
	private ExamResultItemProcessor processor;
	
	@Autowired
	private JobMonitoringListener listener;
	
	@Bean(name="ffir")
	public FlatFileItemReader<IExamResult> createReader(){
		return new FlatFileItemReaderBuilder<IExamResult>()
				.name("reader")
				.resource(new ClassPathResource("TopBrains.csv"))
				.delimited().delimiter(",")
				.names("id","dob","semester","percentage")
				.targetType(IExamResult.class)
				.build();
	}
	
	@Bean(name="jiw")
	public JpaItemWriter<OExamResult> createWriter(){
		return new JpaItemWriterBuilder<OExamResult>()
		.entityManagerFactory(factory)
		.build();
		
	}
	
	@Bean(name = "step1")
	public Step createStep1() {
		System.out.println("BatchConfig.createStep1()");
		return stepFactory.get("step1")
				.<IExamResult, OExamResult>chunk(3)
				.reader(createReader())
				.writer(createWriter())
				.processor(processor)
				.build();
	}

	@Bean(name = "job1")
	public Job createJob1() {
		System.out.println("BatchConfig.createJob1()");
		return jobFactory.get("job1")
				.listener(listener)
				.incrementer(new RunIdIncrementer())
				.start(createStep1())
				.build();

	}

	
}
