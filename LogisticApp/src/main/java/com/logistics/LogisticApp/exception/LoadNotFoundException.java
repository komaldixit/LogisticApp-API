package com.logistics.LogisticApp.exception;

public class LoadNotFoundException  extends RuntimeException{
	public LoadNotFoundException(String shipperId) {
		System.out.println("Could not found the usr with shipper Id \"+ shipperId ");
	}

	
}
