package com.homepage.first;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Cart {
	static int quantity;
	static String pname;
	static String name;
	static int total;
	static int price;
	static int a;
	static int b;
	
	public static void addToCart(int choice) {
		ArrayList<Test> al = new ArrayList<>();
		Connection con = DBUtil.getConnection();
		
		PreparedStatement pst = null;
		PreparedStatement pst2 = null;
		PreparedStatement pst3 = null;
		
		ResultSet rs = null;
		ResultSet rs2=null;
		
		String query="select * from products where productId=?";
		String query1="select customerName from customer where mobileNo=?";
		
		try {
			pst= con.prepareStatement(query);
			pst.setInt(1, choice);
			rs = pst.executeQuery();
			
			pst2=con.prepareStatement(query1);
			pst2.setString(1,CheckInfo.mobileNo1);
			rs2 = pst2.executeQuery();
		
			while(rs2.next()) {
				 name=rs2.getString("customerName");
			}		
			
			while(rs.next()) {	
				Test test = new Test();
				test.setProductId(rs.getInt("productId"));
			
				pname=test.setName(rs.getString("pName"));

				if(quantity<=1) {
					 a=test.setQuantity(rs.getInt("quantiy"));
					if(b==1) {
						a=b+1;
						
					} else {
						 a=1;
						 b=a;
						 
					}				
					 quantity++;	 
				}
				price=test.setPrice(rs.getInt("price"));
				total=a*test.getPrice();
				
				al.add(test);
				for(Test t : al) {
					System.out.println(t);
					
				}
				
				String query3="insert into cart values(?,?,?,?)";
				pst3= con.prepareStatement(query3);
				
				
				pst3.setString(1, name);
				pst3.setString(2,pname);
				pst3.setInt(3,a);
				pst3.setInt(4, total);
				pst3.execute();
				
			}
	
		}catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			try {
				
				pst3.close();
				rs2.close();
				pst2.close();
				
				rs.close();
				pst.close();
				con.close();
				
			} catch (Exception e) {
				
				e.printStackTrace();
			}
		
	}
}
}

