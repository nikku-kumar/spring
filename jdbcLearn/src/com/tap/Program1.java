package com.tap;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Program1 {
	private static Connection connection = null;
	private static Statement statement=null;
	private static ResultSet res=null;
	
	public static void main(String[] args) {
		
		
		String url="jdbc:mysql://localhost:3306/jdbc_class";
	    String username="root";
	    String password="root";
	    
//	    String sql = "Insert into `employee` (`id`,`Fname`,`email`,`dept`,`salary`) "
//		   		+ "values (7,'nikku kumar','nikku@gmail.commm','cse branch','1000000')";
//	    String sql="update `employee` set `salary` =`salary`+5000 where `dept`='hr'";
	    
	    
	    
	    
	    String sql="delete from `employee` where `id` = 3";
		    
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection=DriverManager.getConnection(url,username,password);
		    statement=connection.createStatement();
		    
		    int i= statement.executeUpdate(sql);
		    
		    System.out.println(i);
//		     res = displayEmployee(statement);
		}
		    
		
		catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	
		finally {
			
			close(connection, statement, res);		
		}
	}

	public static ResultSet displayEmployee(Statement statement) throws SQLException {
		ResultSet res;
		res= statement.executeQuery("select*from employee");
		while(res.next()) {
			System.out.println(res.getInt("id")+","+
			res.getString("Fname")+","+
			res.getString("email")+","+
			res.getString("dept")+","+
			res.getInt("salary"));
		}
		return res;
	}

	private static void close(Connection connection, Statement statement, ResultSet res) {
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
		}catch(SQLException e){
			e.printStackTrace();	
		}
		
		try
		{	 
			if(connection!=null) {
				 connection.close();
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
