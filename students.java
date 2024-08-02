package employee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class students {
	private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String USERNAME = "root";
	private static final String PASSWORD= "root";
	
	//CREATING TABLE
	
  public static void main(String[] args) {
	  
	try {
		Scanner scr = new Scanner(System.in);
		
		System.out.println("provide database name:");
		
		String URL = "jdbc:mysql://localhost:3306/ " + scr.next();
		
		Class.forName(DRIVER);
		
		Connection conn = DriverManager.getConnection(URL , USERNAME , PASSWORD);
		
		System.out.println("enter the table name:");
		
		String sql = "create table " + scr.next() +"(id int,name varchar(20), email varchar(30))";
		
		PreparedStatement pmst = conn.prepareStatement(sql);
		
		int i = pmst.executeUpdate();
		
		if (i==0) {
			
			System.out.println("table created");
			
		}
		
		else {
			
			System.out.println(" table not created");
		}
		
		conn.close();
		
		pmst.close();
		
	} catch (Exception e) {
		e.printStackTrace();
		
	}
}
}
