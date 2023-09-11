package com.ibm.functional.programming;

import java.util.Arrays;
import java.util.Comparator;
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
		
		
		 
		System.out.println("--------Only Male----------");

		// Show only Male Account Holders 
		List<Account> onlyMaleList = 
					AccountPredicate.filterAccounts(list, AccountPredicate.onlyMale());
		onlyMaleList.forEach(System.out :: println);
		
		// show people with balance more than 2500 

		System.out.println("--------Balance More than 2500----------");
		List<Account> accountMoreThan2500List 
			= AccountPredicate.filterAccounts(list, AccountPredicate.checkOnBalance(2500));
		accountMoreThan2500List.forEach(System.out :: println);

		// list people with Male and balance more than 2500 
		
		
		System.out.println("----------- Male and balance more than 2500----------- ");
		Predicate<Account> onlyMaleAndBalanceGt2500 
			= AccountPredicate.checkOnBalance(2500).and(AccountPredicate.onlyMale()); 
		
		List<Account> onlyMaleAndBalanceGt2500List 
			= AccountPredicate.filterAccounts(list, onlyMaleAndBalanceGt2500); 
		
		onlyMaleAndBalanceGt2500List.forEach(System.out :: println);
		
		System.out.println("--------Only Female----------");

		// Show only female Account Holders (Negate of Male) 
		List<Account> onlyFemaleList = 
				AccountPredicate.filterAccounts(list, AccountPredicate.onlyMale().negate());
		onlyFemaleList.forEach(System.out :: println);
		
		
		// sort people base on name 
		
		
		
		Comparator<Account> sortOnCustomerName = new Comparator<Account>() {
			@Override
			public int compare(Account o1, Account o2) {
				return o1.getCustomerName().compareTo(o2.getCustomerName()); 
			}
		};
		
		list.sort(sortOnCustomerName);
		
		System.out.println("--- accounts in sorted order of name------ ");
		list.forEach(System.out :: println);

		list.sort(sortOnCustomerName.reversed()); 

		System.out.println("--- accounts in sorted order of name (desc)------ ");
		list.forEach(System.out :: println);
		
		
		// order by sex then by balance 
		Comparator<Account> sexAndBalance = Comparator.comparing(Account :: getSex).
			thenComparing(Comparator.comparing(Account :: getBalance)); 
		

		list.sort(sexAndBalance); 

		System.out.println("--- accounts in sex and balance ------ ");
		list.forEach(System.out :: println);
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
