package com.dellux.error;

public class TouristNotFoundException extends RuntimeException {

	public TouristNotFoundException() {
		
	}
public TouristNotFoundException(String msg) {
		super(msg);
	}
}
