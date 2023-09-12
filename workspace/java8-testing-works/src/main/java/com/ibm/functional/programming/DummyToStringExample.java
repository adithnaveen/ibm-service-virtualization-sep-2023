package com.ibm.functional.programming;


class MyClass  {
	private int myVar; 
	
	public MyClass(int myVar) {
		this.myVar = myVar; 
	}
	
	@Override
	public String toString()  {
		return Integer.toString(this.myVar); 
	}
}
public class DummyToStringExample {
	public static void main(String[] args) {
		String var = "hello"; 
		System.out.println(var);
		
		
		MyClass m = new MyClass(123); 
		
		System.out.println(m);
		
	 
	}
}
