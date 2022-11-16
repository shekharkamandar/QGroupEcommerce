package com.ecommerce.customer;

import com.homepage.first.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Registration {
	
	static String mobileNo;
	static String password;
	static int customerId=1;
	
	public static void getRegister() {
		
		String customerName;   
		String mailId;   
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter your full Name :");
		customerName = sc.nextLine();
		
		System.out.println("Enter your Mobile no :");
		mobileNo = sc.next();  
		
		System.out.println("Enter your Mail id :");
		mailId = sc.next();
		
		System.out.println("Enter Password :");
		password = sc.next(); 
		store(customerName, mobileNo, mailId, password );
		
		
		sc.close();
	}
	
	public static void store(String customerName, String mobileNo, String mailId, String password) {
		
		Connection con = DBUtil.getConnection();
		PreparedStatement pst = null;
		String query = "insert into customer values(?,?,?,?,?)";
		try {
			pst = con.prepareStatement(query);
			
			pst.setInt(1, customerId);
			pst.setString(2, customerName);
			pst.setString(3, mobileNo);
			pst.setString(4, mailId);
			pst.setString(5, password);
			//pst.setInt(6, pId);
			condition();
			pst.execute();
			System.out.println("User Registered successfully ");
		} catch (SQLException e) {
			System.out.println("User already registered with mobile no");
			e.printStackTrace();
		}finally {
			
			try {
				pst.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
	}
	public static void condition () {
		
		Connection con = DBUtil.getConnection();
		PreparedStatement pst = null;
		ResultSet rs = null;
		String query="select mobileNo from customer";
		try {
			pst= con.prepareStatement(query);
			rs = pst.executeQuery();
			while(rs.next()) {
				if(mobileNo==rs.getString(1)) {
					System.out.println("Mobile no already registered");
				}
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				pst.close();
				con.close();
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			
		}
		
	}
	
	

}
