package com.homepage.first;
import com.ecommerce.admin.*;
import java.util.Scanner;
import com.ecommerce.customer.*;
public class Menubar {
	
	public static void menu() {
		
	System.out.println("********************************************************************************");
	System.out.println("Welcome to Shopping cart :");
	System.out.println();
	
	System.out.println("1) Registration");
	System.out.println("2) LogIn");
	System.out.println("3) Admin");
	System.out.println("4) Exit");
	System.out.println("********************************************************************************");
	System.out.println();
	
	Scanner sc = new Scanner(System.in);
	
	System.out.println("Select Your choice : ");
	int choice = sc.nextInt();
	System.out.println();
		switch(choice) {
		
		case 1: 
			Registration.getRegister();
			break;
		
		case 2:
			LogIn.logIn();
			break;
		
		case 3:
			AdminMenu.adminChoice();
			break;
		
		case 0:
			System.out.println("You are exit...");
			System.exit(0);
		
		default:
			break;
		}
		
}

}
