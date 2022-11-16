package com.ecommerce.customer;
import java.util.Scanner;

import com.ecommerce.products.ProductInfo;
import com.homepage.first.CheckInfo;
import com.homepage.first.Menubar;

public class LogIn {
	
	public static void logIn() {
		 
		CheckInfo.checkInfo();
		System.out.println();
		System.out.println();
		
		System.out.println("********************************************************************************");
		System.out.println("List of products :");
		
		System.out.println();
		ProductInfo.products();
		
		System.out.println();
		System.out.println("********************************************************************************");
		System.out.println();
		
		System.out.println("Select product of your choice : ");
		ProductInfo.productChoice();
		System.out.println();
		System.out.println();
		
		
		Scanner sc=new Scanner(System.in);
		System.out.println("select choice:");
		System.out.println("1) Main menu");
		System.out.println("2) Exit");
		int ch=sc.nextInt();
		
		switch(ch) {
		case 1:
			Menubar.menu();
			break;
		case 2:
			System.out.println("************************************Thank You************************************");

			System.exit(0);
		}
		
	}
	
	
	
}




	
