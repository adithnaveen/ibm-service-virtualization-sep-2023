package com.ibm.functional.programming;


// if you dont have the constructor then jvm shall have constructor 
class MyBusiessLogic {
	private String str; 
	public MyBusiessLogic() {
		this.str = "Hello "; 
	}

	public void setStr(String str) {
		this.str = str;
	}
	
	
}





public class ConctructorUsage {
	public static void main(String[] args) {
		MyBusiessLogic mb = new MyBusiessLogic(); // this workd
		
		mb.setStr("Hello");
		
		
	}
}
