package com.ecommerce.admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.homepage.first.DBUtil;

public class PurchaseHistory {
	
	public static void pHistory() {
		
		Connection con=DBUtil.getConnection();
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		String query="select * from cart";
		try {
			pst=con.prepareStatement(query);
			rs=pst.executeQuery();
			System.out.println("----------------------------------------------------------------------------------------");
			System.out.println("Customer name \t\tProduct name\t\tQuantity \tPrice");
			System.out.println("----------------------------------------------------------------------------------------");

			while(rs.next()) {
				String cname=rs.getString(1);
				String pname=rs.getString(2);
				int quant=rs.getInt(3);
				int prices=rs.getInt(4);
				System.out.println(cname+"\t"+pname+"\t\t"+quant+"\t\t"+prices);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
