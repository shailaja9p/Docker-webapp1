package com.dellux.processor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import com.dellux.model.IExamResult;
import com.dellux.model.OExamResult;

@Component
public class ExamResultItemProcessor implements ItemProcessor<IExamResult, OExamResult> {

	@Override
	public OExamResult process(IExamResult item) throws Exception {
		if(item.getPercentage()>=95.0f)
		{
			OExamResult result=new OExamResult();
			result.setId(item.getId());
			result.setDob(LocalDate.parse(item.getDob(),DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S")));
			result.setPercentage(item.getPercentage());
			result.setSemester(item.getSemester());
			return result;
		}
		else 
			return null;
	}

}
