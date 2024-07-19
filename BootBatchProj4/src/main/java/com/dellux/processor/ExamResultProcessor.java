package com.dellux.processor;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import com.dellux.model.ExamResult;

@Component("examResultProcessor")
public class ExamResultProcessor implements ItemProcessor<ExamResult, ExamResult> {

	@Override
	public ExamResult process(ExamResult item) throws Exception {
		if(item.getPercentage()>90)
		return item;
		else
			
		return item;
	}

}
