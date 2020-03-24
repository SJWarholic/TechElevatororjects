package com.techelevator;

public class Product {

	private String name;
	private double price = 0.0;
	private String type;
	private int quantity;
	
	public Product(String name, double price, String type, int quantity) {
		this.name = name;
		this.price = price;
		this.type = type;
		this.quantity = quantity;
		
	}
	
//	public double getPrice() {
//		return price;
//	}

	

	public String getName() {
		return name;
	}

	public double getPrice() {
		return price;
	}

	public String getType() {
		return type;
	}

	public int getQuantity() {
		return quantity;
	}

	@Override
	public String toString() {
		return name + ", " + price + ", " + type;
	}
	
	public boolean removeItem() {	// call with Product.buyItem in VendingMachineCLI
		if (quantity <= 0) {
			return false;
		}
		else {
			return true;
		}
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
