package com.tap;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;



public class program3 {
	
	private static Connection  connection = null;

	private static PreparedStatement pstm= null;

	private static ResultSet res=null;
	private final static Scanner scan = new Scanner(System.in);
	

	public static void main(String[] args) {
		
		String url ="jdbc:mysql://localhost:3306/jdbc_class";
		String user="root";
		String pass="root";
		
		String sql ="select* from `employee` where `dept`=?";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection  = DriverManager.getConnection(url,user,pass);
			pstm = connection.prepareStatement(sql);
			
			System.out.println("eneter the department");
			pstm.setString(1,scan.next());
			res = pstm.executeQuery();
			
			while(res.next()) {
				System.out.println(res.getInt("id")+","+res.getString("Fname")
				+","+res.getString("email")+","+res.getString("dept")
				+","+res.getInt("salary"));
			}
			
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			close(connection, pstm, res);
		}
		
		
		
	}

	private static void close(Connection connection, PreparedStatement pstm, ResultSet res) {
		try {
			if(res!=null) {
				res.close();
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		try {
			if(pstm !=null) {
				pstm.close();
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
