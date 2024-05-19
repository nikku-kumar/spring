package com.tap;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Program11 {
	private static Connection connection = null;
	private static CallableStatement preparecall = null;
	private static final Scanner sc  = new  Scanner(System.in);

	public static void main(String[] args) {
		
		String url="jdbc:mysql://localhost:3306/jdbc_class";
		String user ="root";
		String pass ="root";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection=DriverManager.getConnection(url,user,pass);
			preparecall= connection.prepareCall("{call display_emp(?)}");
			
			
			
			System.out.println("enter the ammount");
			
			preparecall.setInt(1,sc.nextInt());
			
			
			preparecall.execute();
			ResultSet res =preparecall.getResultSet();
			
			while(res.next()) {
				System.out.println(res.getInt("id")+","+res.getString("Fname")
				+","+res.getString("email")+","+res.getString("dept")
				+","+res.getInt("salary"));
			}
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(preparecall!=null) {
					preparecall.close();
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}
			
			
			try {
				if(connection!=null) {
					connection.close();
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
		

	}

}
