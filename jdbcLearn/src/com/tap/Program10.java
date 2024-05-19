package com.tap;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLType;
import java.sql.Types;
import java.util.Scanner;
;

public class Program10 {
	private static Connection connection = null;
	private static java.sql.CallableStatement preparecall = null;
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		
		String url ="jdbc:mysql://localhost:3306/jdbc_class";
		String user="root";
		String pass ="root";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(url,user,pass);
			preparecall= connection.prepareCall("{call count_emp_salary(?)}");
			
			System.out.println("enter the salary");
			preparecall.setInt(1,sc.nextInt());
			
			preparecall.registerOutParameter(1,Types.INTEGER);
			preparecall.execute();
			
			int res = preparecall.getInt(1);
			System.out.println(res);
					
		
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	
	     finally {
	    	 try {
	    		 if(preparecall !=null) {
	    			 preparecall.close();
	    		 }
	    	 }catch(SQLException e) {
	    		 e.printStackTrace();
	    	 }
	     }
	
		
		try {
			if(connection !=null) {
				connection.close();
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}

	}

}
