package com.ibm.functional.programming;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class LambdaEx03 {
	public static void main(String[] args) {
		List<Account> list = Arrays.asList(
				new Account(101, 1234, "Mudita", "Female"), 
				new Account(23, 3434, "Kasaiah", "Male"),
				new Account(45, 2323, "Nidhi", "Female"),
				new Account(77, 4422, "Shaik", "Male"),
				new Account(89, 1244, "Sairam", "Male"),
				new Account(55, 1234, "Souvik", "Male")
				); 
		
		
		 
		
		// Show only Male Account Holders 
		
		
		
		List<Account> onlyMaleList = 
					AccountPredicate.filterAccounts(list, AccountPredicate.onlyMale());
		onlyMaleList.forEach(System.out :: println);
		
		// show people with balance more than 2500 

		// Show only female Account Holders (Negate of Male) 
		
		// sort people base on name 
		
		// list people with Male and balance more than 2500 
		
		
	}
	
	private static class AccountPredicate {
		private static Predicate<Account> onlyMale() {
			return p -> p.getSex().equals("Male"); 
		}
		
		private static Predicate<Account> checkOnBalance(double balance) {
			return p -> p.getBalance() > balance;
		}
		
		private static List<Account> filterAccounts(List<Account> list,
					Predicate<Account> predicate) {
			return list.stream().filter(predicate).collect(Collectors.<Account>toList()); 
		}
		
		
	}
}
