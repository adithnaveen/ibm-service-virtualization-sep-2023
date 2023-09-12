package com.ibm.businesslogic;

import java.util.List;

// contract 
public interface ISampleTestingCode {
	public String sayHello(String name); 
	public List<String> getName(); 
	public boolean checkName(String name) throws NameInvalidException; 
	public String delayedName(String name); 
}
