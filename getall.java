package employee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;



public class getall {
	private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String USERNAME = "root";
	private static final String PASSWORD= "root";
	
	
	
  public static void main(String[] args) {
	  
	try {
		
		Scanner scr = new Scanner(System.in);
		
		System.out.println("provide database name:");
		
		String URL = "jdbc:mysql://localhost:3306/ " + scr.next();
		
		Class.forName(DRIVER);
		
		Connection conn = DriverManager.getConnection(URL , USERNAME , PASSWORD);
		
		System.out.println("enter the table name:");
		
		String sql = "select * from "+ scr.next();
		
		PreparedStatement pmst = conn.prepareStatement(sql);
		
		ResultSet rs = pmst.executeQuery();
		
		while (rs.next()) {
			
			System.out.println("**************");
			
			System.out.println("ID:" +rs.getInt("id"));
			
			System.out.println("NAME:" +rs.getString("name"));
			
			System.out.println("EMAIL:" +rs.getString("email"));
			
			System.out.println("*******************");
		}
		
		conn.close();
		
		pmst.close();
		
	} catch (Exception e) {
		e.printStackTrace();
		
	}
}
}
