package com.cg.bank.service;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.cg.bank.bean.BankBean;
import com.cg.bank.dao.CBankDaoImpl;
import com.cg.bank.dao.IBankDao;
import com.cg.bank.exception.BankException;

public class CBankServiceImpl implements IBankService
{
	IBankDao bankDao  = new CBankDaoImpl();

	@Override
	public String addDemandDraftDetails(BankBean bankBean) throws ClassNotFoundException, IOException, SQLException
	{
		String transactionseq;
		transactionseq = bankDao.addDemandDraftDetails(bankBean);
		return transactionseq;
	}

	@Override
	public BankBean getDemandDraftDetails(int transactionId) throws ClassNotFoundException, IOException, SQLException {
		BankBean bankBean = bankDao.getDemandDraftDetails(transactionId);
		return bankBean;
	}
	

	public void validateLibraryAttribute(BankBean bankBean) throws BankException
	{	
		List <String> validationError  = new ArrayList<String>();
		
		if(!(isValidCustomerName(bankBean.getCustomerName())))
		{
			
			validationError.add("\n Book name should be in alphabet and minimum 1 character. ");
		}
		
		if(!(isValidInFavourOf(bankBean.getInFavourOf())))
		{
			
			validationError.add("\n In Favour name should be in alphabet and minimum 2 characters. ");
		}
		
		if(!(isValidPhoneNumber(bankBean.getPhoneNumber())))
		{
			validationError.add("\n Phone Number should be 10 digit. ");
		}
		
		if(!(isValidDDAmount(bankBean.getDdAmount())))
		{
			validationError.add("\n Price should be positive. ");
		}
		
		if(!(isValidDDCommission(bankBean.getDdCommision())))
		{
			validationError.add("\n commission should be positive. ");
		}
		
		if(!(isValidDDDescription(bankBean.getDdDescription())))
		{
			validationError.add("\n Price should be positive. ");
		}
		
		if(!(isValidDate(bankBean.getDateOfTransaction())))
		{
			validationError.add("\n date format should be in dd/mm/yyyy. ");
		}
		
		
		if(!(validationError.isEmpty()))
		{
			throw new BankException(validationError+" ");
		}
		

	}

	private boolean isValidDate(String dateOfTransaction) {
		Pattern apattern = Pattern.compile("^[0-3]?[0-9]/[0-3]?[0-9]/(?:[0-9]{2})?[0-9]{2}$");
		Matcher amatcher = apattern.matcher(dateOfTransaction);
		return amatcher.matches();
		
	}

	private boolean isValidDDDescription(String ddDescription) {
		Pattern apattern = Pattern.compile("^[A-Za-z]{2,}$");
		Matcher amatcher = apattern.matcher(ddDescription);
		return amatcher.matches();
	}

	private boolean isValidDDCommission(double ddCommision) {
		
		return ddCommision > 0;
	}

	private boolean isValidDDAmount(double ddAmount) {
		
		return ddAmount > 0;
	}

	private boolean isValidPhoneNumber(String phoneNumber) {
		Pattern apattern = Pattern.compile("^[6-9][0-9]{9}");
		Matcher amatcher = apattern.matcher(phoneNumber);
		return amatcher.matches();
	}

	private boolean isValidInFavourOf(String inFavourOf) {
		Pattern apattern = Pattern.compile("^[A-Za-z]{2,}$");
		Matcher amatcher = apattern.matcher(inFavourOf);
		return amatcher.matches();
	}

	private boolean isValidCustomerName(String customerName) {
		Pattern apattern = Pattern.compile("^[A-Za-z]{2,}$");
		Matcher amatcher = apattern.matcher(customerName);
		return amatcher.matches();
	}

	public boolean isValidTransactionId(String transactionId)
	{

		Pattern pattern = Pattern.compile("[0-9]{5}");
		Matcher matcher = pattern.matcher(transactionId);
		if(matcher.matches())
		{
			return true;
		}
		else
			return false;
	}
	
}
