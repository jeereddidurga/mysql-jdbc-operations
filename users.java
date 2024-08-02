package employee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class users {
	private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/";
	private static final String USERNAME = "root";
	private static final String PASSWORD= "root";
	
	
	
  public static void main(String[] args) {
	  
	try {
		
		Scanner scr = new Scanner(System.in);
		
		Class.forName(DRIVER);
		
		Connection conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
		
		System.out.println("enter the database name:");
		
		
		String sql = "create database " + scr.next();
		
		PreparedStatement pmst = conn.prepareStatement(sql);
		
		int i = pmst.executeUpdate();
		
		if (i>0) {
			
			System.out.println("database created");
			
		}
		
		else {
			
			System.out.println("not created");
		}
		
		conn.close();
		
		pmst.close();
		
	}
	catch (Exception e) {
		
		e.printStackTrace();
		
	}
}
}
