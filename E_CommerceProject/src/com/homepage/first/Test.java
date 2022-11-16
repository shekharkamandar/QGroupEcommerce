package com.homepage.first;
import com.homepage.first.*;
public class Test {
	int productId;
	String name;
	int quantity;
	
	int price;
	public int getProductId() {
		return productId;
	}
	public int setProductId(int productId) {
		return this.productId = productId;
	}
	public String getName() {
		return name;
	}
	public String setName(String name) {
		return this.name = name;
	}
	public int getQuantity() {
		return quantity;
	}
	public int setQuantity(int quantity) {
		return this.quantity = quantity;
	}
	public int getPrice() {
		return price;
	}
	public int setPrice(int price) {
		return this.price = price;
	}
	
	  @Override 
	  public String toString() {
		  System.out.println("----------------------------------------------------------------------------------------");
		  System.out.println("Id\t Name\t\t  Quantity\tPrice \t Total");
		  System.out.println("----------------------------------------------------------------------------------------");
		  return productId +"\t"+  name+ "\t   " + Cart.a+"\t\t " + price+ "\t " +Cart.total ; 
		  
		  }
	 
	  
	

}
