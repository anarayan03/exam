package com.cg.bank.dao;

public interface QueryMapper
{
	public static final String INSERT_QUERY = "insert into demand_draft values(transaction_Id_Seq.nextval,?,?,?,?,?,?,?)";
	public static final String EXECUTE_QUERY = "Select * from Library order by transaction_id";
}
