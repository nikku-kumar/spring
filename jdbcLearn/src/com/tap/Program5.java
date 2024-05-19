package com.tap;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Program5 {
	private  static Connection connection = null;
	private static PreparedStatement pstm = null;
	private static Statement statement = null;
	private static ResultSet res = null;
	private static Scanner sc =  new Scanner(System.in) ;
	
	public static void main(String args[]) {
		
		String url ="jdbc:mysql://localhost:3306/jdbc_class";
		String user ="root";
		String pass="root";
		String sql="insert into `employee`(id,Fname,email,dept,salary)values(?,?,?,?,?)";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection=DriverManager.getConnection(url,user,pass);
			Program4.dispalyEmployee(connection);
			
			pstm=connection.prepareStatement(sql);
			
			System.out.println("enter the id");
			int ide=sc.nextInt();
			
			System.out.println("enter the name ");
			String name = sc.next();
			
			System.out.println("enter the email ");
			String emaile = sc.next();
			
			System.out.println("enter the dept ");
			String depte = sc.next();
			
			System.out.println("enter the salary ");
			int salarye = sc.nextInt();
			
			pstm.setInt(1, ide);
			pstm.setString(2, name);
			pstm.setString(3, emaile);
			pstm.setString(4, depte);
			pstm.setInt(5, salarye);
			
			int i =pstm.executeUpdate();
			System.out.println(i);
			
			Program5.displayemployee(connection);

			
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			close(connection,pstm,statement,res);
		}

	}
	
	
	public static void displayemployee(Connection connection)throws SQLException
	{
		statement = connection.createStatement();
		ResultSet res = statement.executeQuery("select * from `employee`");
		
		
		while(res.next()) {
			System.out.println(res.getInt("id")+","+res.getString("Fname")
			+","+res.getString("email")+","+res.getString("dept")
			+","+res.getInt("salary"));
		}
		
		
		System.out.println(".......................");
	}
	
	private static void close(Connection connection,PreparedStatement pstm,Statement statement,ResultSet res) {
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
			if(pstm!=null) {
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
