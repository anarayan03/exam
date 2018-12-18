package com.cg.bank.pl;

import java.util.Scanner;

import com.cg.bank.bean.BankBean;
import com.cg.bank.exception.BankException;
import com.cg.bank.service.CBankServiceImpl;
import com.cg.bank.service.IBankService;

public class Client
{
	
	static Scanner scanner = new Scanner(System.in);
	static IBankService iBankService = null;
	static CBankServiceImpl cBankServiceImpl = null;
	
	public static void main(String[] args)
	{
		BankBean bankBean = null;
		String transactionId = null;
		
		int option = 0;
		
		while(true)
		{
			System.out.println();
			System.out.println();
			System.out.println("   BANK ");
			System.out.println("_______________________________\n");

			System.out.println("1. Enter Demand Draft Details ");
			System.out.println("2. Exit");
			System.out.println("________________________________");
			System.out.println("Select an option:");
			
			try
			{
				
				option = scanner.nextInt();
				
				switch (option)
				{
				case 1 :
					
					while(bankBean==null)
					{
						bankBean=populateBankBean();
					}
					
					try
					{
						cBankServiceImpl = new CBankServiceImpl();
						transactionId=cBankServiceImpl.addDemandDraftDetails(bankBean);
						System.out.println("Your Demand Draft request has been successfully registered along with the "+transactionId);
					}catch (Exception e)
					{
						System.out.println("ERROR :" + e.getMessage());
					}
					
					finally
					{
						transactionId = null;
						cBankServiceImpl = null;
						bankBean = null;
					}
					
					break;

				case 2 :
					
					System.out.println("Successfully Exit");
					System.exit(0);
					
				default:
					
					System.out.println("Wrong Input");
					System.exit(0);
					
				}
				
			}catch (Exception e) {
				System.out.println(e);
			}
			
		}
		
	}

	private static BankBean populateBankBean()
	{
		
		BankBean bankBean = new BankBean();
		System.out.println("Enter Book Details :");
		
		System.out.println("\nEnter Customer Name : ");
		bankBean.setCustomerName(scanner.next());
		
		System.out.println("In Favour Of : ");
		bankBean.setInFavourOf(scanner.next());
		
		System.out.println("Enter Phone No : ");
		bankBean.setPhoneNumber(scanner.next());
		
		System.out.println("Date Of Transaction : ");
		bankBean.setDateOfTransaction(scanner.next());
		
		try
		{
		System.out.println("DD Amount : ");
		bankBean.setDdAmount(scanner.nextDouble());
		}catch (Exception e) {
			System.out.println("Invalid Data");
			System.err.println(e);
			System.exit(0);
		}
		
		try
		{
		System.out.println("DD Commission :");
		bankBean.setDdCommision(scanner.nextDouble());
		}catch (Exception e) {
			System.out.println("Invalid Data");
			System.err.println(e);
			System.exit(0);
		}
		
		System.out.println("Date Description : ");
		bankBean.setDdDescription(scanner.next());
		
		cBankServiceImpl = new CBankServiceImpl();
		
		try
		{
			cBankServiceImpl.validateLibraryAttribute(bankBean);
			return bankBean;
		}catch (Exception e)
		{
			System.out.println("Invalid Data");
			System.err.println(e);
			System.exit(0);
		}
		
		return null;

	}
}
