package com.ibm.businesslogic;

import java.util.List;

// development code 
public class SampleTestCode implements ISampleTestingCode {

	@Override
	public String sayHello(String name) {
		return "Hello " + name; 
	}

	@Override
	public List<String> getName() {

		return List.of("Asha", "Amita", "Ashwini", "Nidhi"); 
	}

	@Override
	public boolean checkName(String name) {
		if(name.length()>4) {
			return true; 
		} 
			
		throw new NameInvalidException("Name " + name + " given is invalid");
	}

	@Override
	public String delayedName(String name) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return "Hello " + name; 
	}

}
