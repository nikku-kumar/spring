package com.tap;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Program4 {
	private static Connection connection = null;
	private static PreparedStatement pstm = null;
	private static Statement statement=null;
	private static ResultSet res = null;
	private static  final Scanner scan= new Scanner(System.in);
	
	public static void main(String args[]) {
		String url="jdbc:mysql://localhost:3306/jdbc_class";
		String user="root";
		String pass="root";
		
		String sql="update `employee` set salary= `salary` +? where `dept`=? ";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection=DriverManager.getConnection(url,user,pass);
			Program4.dispalyEmployee(connection);
			pstm = connection.prepareStatement(sql);
			
			
			System.out.println("eneter the department");
			String deptarment = scan.next();
			
			System.out.println("eneter the salary");
			
			int salarye= scan.nextInt();
			pstm.setInt(1, salarye);
			pstm.setString(2, deptarment);
			int i =pstm.executeUpdate();
			System.out.println(i);
			Program4.dispalyEmployee(connection);
			
//			res=pstm.executeQuery();
			
			
		}
		
		catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			close(connection,pstm,res,statement);
		}

	}
	
	public static void  dispalyEmployee(Connection connection ) throws SQLException {
		statement = connection.createStatement();
		ResultSet res = statement.executeQuery("select * from `employee`");
		
		while(res.next()) {
			System.out.println(res.getInt("id")+","+res.getString("Fname")
			+","+res.getString("email")+","+res.getString("dept")
			+","+res.getInt("salary"));
		}
		
		
		System.out.println(".......................");
		
	}

	private static  void close(Connection connection,PreparedStatement pstm, ResultSet res,Statement statement) {
		try {
			if(res!=null) {
				res.close();
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		try {
			if(statement!=null) {
				statement.close();
			}	
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		try {
			if( pstm!=null ) {
				pstm.close();
			}
		}
		catch(SQLException e) {
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
