package com.ibm.functional.programming;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class LambdaEx01 {
	public static void main(String[] args) {
		// to create a variable ctrl + 2 + l 
		List<Integer> numbers = Arrays.asList(3,5,8,100,45,89); 
		
		// before functional programming 
		
		System.out.println("--- with for loop --- ");
		for(int i=0; i< numbers.size(); i++) {
			System.out.println(numbers.get(i));
		}
		
		// lambda way 
		
		System.out.println("---- with lambda --- ");
		numbers.forEach(temp -> System.out.println(temp));

		// behind the screen 
		System.out.println("-------------------------");
		
		numbers.forEach(t  -> System.out.println("Number is " + t));
		
		// with method reference
		
		System.out.println("-----------with method reference--------------");
		numbers.forEach(System.out :: println);
		
		
	}
}
