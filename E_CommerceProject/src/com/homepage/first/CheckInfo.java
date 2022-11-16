package com.homepage.first;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import com.ecommerce.customer.LogIn;

public class CheckInfo {

	static String mobileNo1;
	static String password1;
	static String mob;
	static String pass;

	public static void checkInfo() {
		
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter user registered mobile number :");
		mobileNo1 = sc.next();

		System.out.println("Enter log in password :");
		password1 = sc.next();
		getConnections();
		
		}
		
	
		public static void getConnections() {
			Connection con = DBUtil.getConnection();
			PreparedStatement pst = null;
			ResultSet rs = null;
			boolean flag = false;
			String query = "select mobileNo, password from customer";
			try {
				pst = con.prepareStatement(query);
				rs = pst.executeQuery();
				while (rs.next()) {
					String mob = rs.getString("mobileNo");
					String pass = rs.getString("password");

					if ((mobileNo1.equals(mob)) && (password1.equals(pass))) {
						flag = true;
						System.out.println();
						System.out.println("log in successfully...");

					}
				}
				rs.close();
				if (!flag) {
					System.out.println("Invalid username and password...!");
					LogIn.logIn();
					System.exit(0);

				}
			} catch (Exception e) {

				e.printStackTrace();
			} finally {
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
