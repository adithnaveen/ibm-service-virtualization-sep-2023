package com.ibm.functional.programming;

public class Account {
	private int accountId; 
	private double balance;
	private String customerName; 
	private String sex;
	
	public Account() {
		super();
	}
	public Account(int accountId, double balance, String customerName, String sex) {
		super();
		this.accountId = accountId;
		this.balance = balance;
		this.customerName = customerName;
		this.sex = sex;
	}
	
	public int getAccountId() {
		return accountId;
	}
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	@Override
	public String toString() {
		return "Account [accountId=" + accountId + ", balance=" + balance + ", customerName=" + customerName + ", sex="
				+ sex + "]";
	}
	
 
	
	
}
