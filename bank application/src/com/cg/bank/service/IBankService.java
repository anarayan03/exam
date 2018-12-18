package com.cg.bank.service;

import java.io.IOException;
import java.sql.SQLException;

import com.cg.bank.bean.BankBean;

public interface IBankService
{

	public String addDemandDraftDetails (BankBean bankBean) throws ClassNotFoundException, IOException, SQLException;
	public BankBean getDemandDraftDetails (int transactionId) throws ClassNotFoundException, IOException, SQLException;
	
}
