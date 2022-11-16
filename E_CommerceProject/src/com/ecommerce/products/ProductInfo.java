package com.ecommerce.products;

import com.homepage.first.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
public class ProductInfo {
	
	static int choice;
	public static void products() {
		
			Connection con = DBUtil.getConnection();
			PreparedStatement pst = null;
			ResultSet rs = null;
			String query="select * from products" ;
			try {
				pst= con.prepareStatement(query);
				rs = pst.executeQuery();
				System.out.println("----------------------------------------------------------------------------------------");
				System.out.println("Product Id \t Product Name \t Description \t\t Quantity \t Price ");
				System.out.println("----------------------------------------------------------------------------------------");
				while(rs.next()) {
					int id = rs.getInt(1);
					String name = rs.getString(2);
					String description = rs.getString(3);
					int quantity = rs.getInt(4);
					int price = rs.getInt(5);
					System.out.println(id+"\t\t " +name+ "\t" +description+ "\t\t    " +quantity+ "\t\t  " +price);
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
	
	
		  public static void productChoice() {
		   
			Scanner sc=new Scanner(System.in);
			 
			 choice=sc.nextInt();
			 System.out.println();
			 System.out.println("Cart details :");
			 System.out.println();
			 Cart.addToCart(choice);
			
			
		  }	
}
