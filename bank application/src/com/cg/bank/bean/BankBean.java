package com.cg.bank.bean;

public class BankBean
{
	
	private String transactionId;
	private String customerName;
	private String inFavourOf;
	private String phoneNumber;
	private String dateOfTransaction;
	private double ddAmount;
	private double ddCommision;
	private String ddDescription;
	
	public String getDateOfTransaction() {
		return dateOfTransaction;
	}
	public void setDateOfTransaction(String dateOfTransaction) {
		this.dateOfTransaction = dateOfTransaction;
	}

	public String getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getInFavourOf() {
		return inFavourOf;
	}
	public void setInFavourOf(String inFavourOf) {
		this.inFavourOf = inFavourOf;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public double getDdAmount() {
		return ddAmount;
	}
	public void setDdAmount(double ddAmount) {
		this.ddAmount = ddAmount;
	}
	public double getDdCommision() {
		return ddCommision;
	}
	public void setDdCommision(double ddCommision) {
		this.ddCommision = ddCommision;
	}
	public String getDdDescription() {
		return ddDescription;
	}
	public void setDdDescription(String ddDescription) {
		this.ddDescription = ddDescription;
	}
	@Override
	public String toString() {
		return "BankBean [transactionId=" + transactionId + ", customerName=" + customerName + ", inFavourOf="
				+ inFavourOf + ", phoneNumber=" + phoneNumber + ", dateOfTransaction=" + dateOfTransaction
				+ ", ddAmount=" + ddAmount + ", ddCommision=" + ddCommision + ", ddDescription=" + ddDescription + "]";
	}
	
	
	
}
