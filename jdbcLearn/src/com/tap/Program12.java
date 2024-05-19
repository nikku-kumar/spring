package com.tap;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Program12 {
	private static Connection connection=null;
	private static PreparedStatement statement = null;
	private static FileInputStream fis=null;
	private static Scanner sc = new Scanner(System.in);
	

	public static void main(String[] args) {
		String url="jdbc:mysql://localhost:3306/jdbc_class";
		String user ="root";
		String pass ="root";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection= DriverManager.getConnection(url, user, pass);
			statement=connection.prepareStatement("UPDATE `employee`  set `dp` =? where id=?");
			statement.setInt(2, sc.nextInt());
		  
			fis = new FileInputStream("C:\\Users\\lav84\\OneDrive\\Desktop\\ECLIPSE\\jdbcLearn\\image\\download.jpg");
			statement.setBinaryStream(1, fis);
			
			int i = statement.executeUpdate();
			System.out.println(i);
			
			
			
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		
		

	}

}
