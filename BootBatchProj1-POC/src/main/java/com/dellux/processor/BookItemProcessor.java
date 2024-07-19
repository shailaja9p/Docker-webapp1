package com.dellux.processor;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@Component("biProcessor")
public class BookItemProcessor implements ItemProcessor<String, String> {

	@Override
	public String process(String item) throws Exception {
		System.out.println("BookItemProcessor.process()");
		if(item.equalsIgnoreCase("CRJ"))
		return item+"Complete Reference in Java given by Herberd sheild and pattrin";
		else if(item.equalsIgnoreCase("TIJ"))
			return item+"Thinking in Java given by Bruce Echel";
		else if(item.equalsIgnoreCase("EJ"))
			return item+"Effective Java given by Jaushuva Lorge";
		else if(item.equalsIgnoreCase("BBJ"))
			return item+"Black Book of JAva given by RNR";
		else if(item.equalsIgnoreCase("HFJ"))
			return item+"Head First Java given by Katesior";
		else 
			return null;
	}

}
