package com.ecommerce.admin;
import com.homepage.first.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CustomerInformation {
	
	public static void userInformation() {
		Connection con = DBUtil.getConnection();
		PreparedStatement pst = null;
		ResultSet rs = null;
		String query="select * from customer" ;
		try {
			pst= con.prepareStatement(query);
			rs = pst.executeQuery();
			System.out.println("----------------------------------------------------------------------------------------");
			System.out.println("Name \t\t            MobileNo \t           MailId \t\t      Password");
			System.out.println("----------------------------------------------------------------------------------------");
			while(rs.next()) {
				String name=rs.getString(1);
				String mobileNo = rs.getString(2);
				String mailId = rs.getString(3);
				String password = rs.getString(4);
				
				System.out.println(name+ "\t   "+mobileNo+ "\t\t" +mailId+ "\t\t" +password);
			}
		}catch (Exception e) {
			System.out.println(e);
		}
	}
	
}
