package com.dellux.runner;

import java.util.Date;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class BatchProcessingTest {

	@Autowired
	private JobLauncher launcher;
	
	@Autowired
	private Job job;
	
	@Scheduled(cron="${cron.expr}")
	public void runJob() throws Exception{
		System.out.println(new Date());
		JobParameters params = new JobParametersBuilder()
				.addLong("time", System.currentTimeMillis()).toJobParameters();
		
		JobExecution execution = launcher.run(job, params);
		/*
		 * System.out.println("job execution status :"+execution.getExitStatus());
		 * System.out.println("job started at"+execution.getStartTime()+" "+execution.
		 * getEndTime());
		 */
	}
}
