package com.tap;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Program13 {
	private static Connection connection=null;
	private static PreparedStatement statement = null;
	
	private static  FileReader fs = null;
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		
		String url="jdbc:mysql://localhost:3306/jdbc_class";
		String user ="root";
		String pass ="root";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection= DriverManager.getConnection(url, user, pass);
			statement= connection.prepareStatement("UPDATE `employee`  set `intro` =? where id=?");
			statement.setInt(2,sc.nextInt());
			 fs =new FileReader("C:\\Users\\lav84\\OneDrive\\Desktop\\ECLIPSE\\jdbcLearn\\src\\myIntro.txt");
			statement.setCharacterStream(1, fs);
			int i =statement.executeUpdate();
			System.out.println(i);
			
		 }	catch(ClassNotFoundException e) {
			 e.printStackTrace();	
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}
