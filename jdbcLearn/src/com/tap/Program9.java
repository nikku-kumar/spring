package com.tap;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.Scanner;

import javax.imageio.plugins.tiff.GeoTIFFTagSet;

public class Program9 {
	private static Connection connection = null;
	private static PreparedStatement pstm = null;
	private static CallableStatement  preparecall= null;
	private static Statement statement = null;
	private static final Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		
		String url ="jdbc:mysql://localhost:3306/jdbc_class";
		String user ="root";
		String pass="root";
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(url,user,pass);
			 preparecall = connection.prepareCall("{call emp_count(?,?) }");
			System.out.println("enter the departrment ");
			preparecall.setString(1,sc.next() );
			preparecall.registerOutParameter(2,Types.INTEGER);
			preparecall.execute();
			
			int res =preparecall.getInt(2);
			System.out.println(res);
			
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		finally {
			close(connection,pstm,statement);
		}
		

	}

	
	
	public static void displayEmployee(Connection connection)throws SQLException{
		statement=connection.createStatement();
		ResultSet res = statement.executeQuery("select * from `employee`");
		while(res.next()) {
			System.out.println(res.getInt("id")+","+res.getString("Fname")
			+","+res.getString("email")+","+res.getString("dept")
			+","+res.getInt("salary"));
		}
	}
	private static void close(Connection connection,PreparedStatement pstm
			,Statement statement ){
		try {
			if(statement!=null) {
				statement.close();
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		try {
			if(pstm!=null) {
				pstm.close();
			}
		}catch(SQLException e) {
			e.printStackTrace();
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
