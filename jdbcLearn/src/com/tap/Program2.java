package com.tap;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Program2 {
	
	public static void main(String args[]) {
		Connection connection = null;
		Statement  statement=null;
		ResultSet res = null;
		
		
		String url="jdbc:mysql://localhost:3306/jdbc_class";
		String username ="root";
		String passoward="root";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			 connection=DriverManager.getConnection(url,username,passoward);
			 statement = connection.createStatement();
			 res = displayEmployee(statement);
			
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			close(connection,statement,res);
		}
	}
	
	
	public static ResultSet displayEmployee(Statement statement) throws SQLException
	{
		ResultSet res;
		res=statement.executeQuery("select*from employee");
		while(res.next()) {
			System.out.println(res.getInt("id")+","+
					res.getString("Fname")+","+
					res.getString("email")+","+
					res.getString("dept")+","+
					res.getInt("salary"));
		}
		return res ;
	}
	
	private static void  close(Connection connection,Statement statement,ResultSet res) {
		try {
			if(res!=null) {
				res.close();
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		try {
			if(statement!=null) {
				statement.close();
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		try {
			if(connection!=null) {
				connection.close();
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	

}
