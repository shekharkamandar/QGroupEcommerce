package com.ecommerce.admin;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.homepage.first.*;
public class QuantityCheck {
	
	public static void quantityChoice() {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter product id : ");
		int Id=sc.nextInt();
		System.out.println();
		checkQuantity(Id);
		sc.close();
	}
	public static void checkQuantity(int Id) {
		
		Connection con=DBUtil.getConnection();
		PreparedStatement pst=null;
		ResultSet rs=null;
		String query="select quantiy from products where productId=?";
		try {
			 pst=con.prepareStatement(query);
			 pst.setInt(1, Id);
			rs=pst.executeQuery();
			System.out.println("Quantity is : ");
			while(rs.next()) {
				int q=rs.getInt("quantiy");
				System.out.println(q);
			}
			
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		finally {
			try {
				rs.close();
				pst.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
	}
	
	
}
