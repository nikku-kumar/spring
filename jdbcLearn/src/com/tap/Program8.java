package com.tap;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Program8 {
	private static Connection connection=null;
	private static PreparedStatement pstm = null;
	private static Statement statement = null;
//	private static ResultSet res = null;
	private static final Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		String url="jdbc:mysql://localhost:3306/jdbc_class";
		String user ="root";
		String pass="root";
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection=DriverManager.getConnection(url,user,pass);
			Program8.displayEmployee(connection);
			
			connection.setAutoCommit(false);
			transcation();
			System.out.println("\n\n");
			Program8.displayEmployee(connection);
			
					
				
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		finally {
			close( connection,pstm,statement);
		}
		
		
		
		
	}
	
	private static void transcation() throws SQLException{
		
		System.out.println("Eneter sender");
		String sender=sc.next();
		
		System.out.println("Eneter reciever");
		String reciver = sc.next();
		
		System.out.println("Eneter ammount");
		int ammount = sc.nextInt();
		
		int x=updatebalance(sender,-ammount);
		int y =updatebalance(reciver,ammount);
		
		if(isConfirm(x,y))
		{
			System.out.println("success send the ammount");
			connection.commit();
		}else {
			System.err.println("not send the ammount");
			connection.rollback();
		}
		
	}

	private static boolean isConfirm(int x,int y) {
		System.out.println("Do you wan tthis transaction yes/or not");
		
		return sc.next().equalsIgnoreCase("yes") && x==1 && y==1;
	}

	private static int updatebalance(String user, int ammount)throws SQLException {
		
	    String sql= "update `employee` set `salary`= `salary`+  ? where `fname`= ?";
	    
	    pstm = connection.prepareStatement(sql);
	    pstm.setInt(1, ammount);
	    pstm.setString(2,user);
	    
	    int i=pstm.executeUpdate();
	    
	    return i;
		
	}

	public static void displayEmployee(Connection connection)throws SQLException{
		statement = connection.createStatement();
		ResultSet res = statement.executeQuery("select * from `employee`");
		while(res.next()) {
			System.out.println(res.getInt("id")+","+res.getString("Fname")
			+","+res.getString("email")+","+res.getString("dept")
			+","+res.getInt("salary"));
		}
	}

	private static void close(Connection connection,PreparedStatement pstm
			,Statement statement ) {
//		try {
//			if(res==null) {
//				res.close();
//			}
//		}catch(SQLException e) {
//			e.printStackTrace();
//		}
		
		try {
			if(statement!=null) {
				statement.close();
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		
		try {
			if( pstm !=null) {
				 pstm.close();
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		try {
			if( connection !=null) {
				connection.close();
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

}
