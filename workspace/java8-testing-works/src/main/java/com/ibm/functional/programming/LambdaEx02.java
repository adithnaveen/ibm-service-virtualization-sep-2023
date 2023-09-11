package com.ibm.functional.programming;

@FunctionalInterface
interface MathOperation {
	int operation(int num1, int num2);
}

public class LambdaEx02 {
	public static void main(String[] args) {
		
		MathOperation addition =(int num1, int num2) -> {
				return num1 + num2; 
		};
		
		MathOperation substraction =( num1, num2) ->  num1 - num2;  
	
		
		LambdaEx02 lambdaEx = new LambdaEx02();
		
		int result1 = lambdaEx.operation(100, 200, addition);
		int result2 = lambdaEx.operation(200, 300, substraction);
		
		System.out.println("Result 1 " + result1);
		System.out.println("Result 2 " + result2);
		
	}
	
	int operation (int num1, int num2, MathOperation operation) {
		return operation.operation(num1, num2);
	}
	
}
