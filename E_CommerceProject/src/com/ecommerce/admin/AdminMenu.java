package com.ecommerce.admin;

import java.util.Scanner;

public class AdminMenu {
	
public static void adminChoice() {
		
	    System.out.println("Welcome to admin log in : ");
		System.out.println();
	    AdminInfo.adminDetails();
		System.out.println();
		
		System.out.println("1) Customer Details ");
		System.out.println("2) Product Quantity ");
		System.out.println("3) Purchase History");
		System.out.println("4) Exit ");
		System.out.println();
		
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Please select choice :");
		int ac=sc.nextInt();
		System.out.println();
		
		switch(ac) {
		
		case 1:
			
			CustomerInformation.userInformation();
			break;
			
		case 2:
			QuantityCheck.quantityChoice();
			break;
			
		case 3:
	
			System.out.println("Purchase History :");
			PurchaseHistory.pHistory();
			break;
			
		case 0:
			System.out.println();
			System.out.println("You are exit...");
			System.exit(0);
			
		default:
			System.out.println();
			System.out.println("Invalid input");
			System.exit(0);
			
			
		}
	
		
   }
	

}

