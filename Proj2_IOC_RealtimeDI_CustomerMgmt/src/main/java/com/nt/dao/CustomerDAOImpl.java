package com.nt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.nt.bo.CustomerBO;

public class CustomerDAOImpl implements ICustomberDAO {
	
	private static final String CUST_INSERT_QUERY  = "INSERT INTO REALTIMEDI_SPRING_CUSTOMER VALUES(CUST_SEQ.NEXTVAL,?,?,?,?,?)" ;
	
	private DataSource ds ;
	
	public CustomerDAOImpl(DataSource ds) {
		this.ds = ds;
	}


	@Override
	public int insertCustomer(CustomerBO bo) throws Exception {
		System.out.println("Insert customer method called in DAO");
		int result = 0 ;
		try(Connection con = ds.getConnection() ; PreparedStatement ps = con.prepareStatement(CUST_INSERT_QUERY)){
			
			ps.setString(1, bo.getName());
			ps.setInt(2, bo.getPrincipalAmt());
			ps.setInt(3, bo.getRate());
			ps.setInt(4, bo.getTime());
			ps.setInt(5, bo.getPayAmt());
			result = ps.executeUpdate() ;
		}
		catch(SQLException se){
			se.printStackTrace();
			throw se ;
		}
		catch(Exception e) {
			e.printStackTrace();
			throw e ;
		}
		return result ;
	}

}
