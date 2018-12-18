package com.cg.bank.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.cg.bank.bean.BankBean;
import com.cg.bank.util.DbConnection;

public class CBankDaoImpl implements IBankDao {

	@Override
	public String addDemandDraftDetails(BankBean bankBean) throws ClassNotFoundException, IOException, SQLException 
	{
		Connection connection = DbConnection.getConnection();
		Statement statement = connection.createStatement();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		String transactionId = null;
		
		try
		{
			preparedStatement = connection.prepareStatement(QueryMapper.INSERT_QUERY);
			
			preparedStatement.setString(1, bankBean.getCustomerName());
			preparedStatement.setString(2, bankBean.getInFavourOf());
			preparedStatement.setString(3, bankBean.getPhoneNumber());
			preparedStatement.setString(4, bankBean.getDateOfTransaction());
			preparedStatement.setDouble(5, bankBean.getDdAmount());
			preparedStatement.setDouble(6, bankBean.getDdCommision());
			preparedStatement.setString(7, bankBean.getDdDescription());
			
			preparedStatement.executeUpdate();
			
			resultSet = statement.executeQuery(QueryMapper.EXECUTE_QUERY);
			//resultSet = statement.executeQuery("Select * from Library");
			
			while(resultSet.next())
			{
				transactionId = resultSet.getString(1);
								
			}
			return transactionId;
			
		}catch (Exception e)
		{
			System.out.println(e);
		}
	
		return transactionId;

	}

	@Override
	public BankBean getDemandDraftDetails(int transactionId) throws ClassNotFoundException, IOException, SQLException {
		Connection connection = DbConnection.getConnection();
		Statement statement = connection.createStatement();
		BankBean bankBean = new BankBean();

		ResultSet resultSet = null;
		
		resultSet = statement.executeQuery(QueryMapper.EXECUTE_QUERY);
		
		try
		{
		while(resultSet.next())
		{
			bankBean.setTransactionId(resultSet.getString(1));
			bankBean.setCustomerName(resultSet.getString(2));
			bankBean.setInFavourOf(resultSet.getString(3));
			bankBean.setPhoneNumber(resultSet.getString(4));
			bankBean.setDateOfTransaction(resultSet.getString(5));
			bankBean.setDdAmount(resultSet.getDouble(6));
			bankBean.setDdCommision(resultSet.getDouble(7));
			bankBean.setInFavourOf(resultSet.getString(8));
			
			
		}
		}catch (Exception e)
		{
			System.out.println(e);
		}
		

		
		return bankBean;
	}

}
