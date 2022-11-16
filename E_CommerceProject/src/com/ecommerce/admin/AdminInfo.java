package com.ecommerce.admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import com.homepage.first.DBUtil;

public class AdminInfo {
	static String mobile;
	static String pass;
	
	public static void adminDetails() {
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter mobile number :");
		mobile=sc.next();
		
		System.out.println("Enter password :");
		pass=sc.next();
		System.out.println();
		adminInfo();
		
	}	
	
	
	public static void adminInfo() {
		
		Connection con=DBUtil.getConnection();
		
		PreparedStatement pst = null;
		ResultSet rs = null;
		boolean flag = false;
		String query="select mobileNo,password from admin" ;
		
			try {
				pst= con.prepareStatement(query);
				rs = pst.executeQuery();
				
				while(rs.next()) {
	
					if(mobile.equals(rs.getString("mobileNo")) && pass.equals(rs.getString("password"))) {
						flag=true;
						System.out.println("Admin log in successfully...");
						System.out.println();
					}	
				}
				rs.close();
				if (!flag) {
					System.out.println("Invalid username and password...!");
					System.out.println();
					adminDetails();
					System.out.println();
					System.exit(0);

				}
				
				
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			
	}
}
