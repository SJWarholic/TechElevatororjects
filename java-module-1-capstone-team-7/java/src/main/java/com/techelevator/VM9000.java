package com.techelevator;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Date;
import java.text.SimpleDateFormat;


public class VM9000 {

	public VM9000() {
		init();
	}

	int moneyIn =0;
	private Map<String, Product> mapSnack = new LinkedHashMap<String, Product>();
	double balance = 0.0;
	String selectionID = "";
	Timestamp timestamp = new Timestamp(System.currentTimeMillis());
	private void init() {
		File aFile = new File("vendingmachine.csv");
		Scanner snackFile;
		try {
			snackFile = new Scanner(aFile);

			while (snackFile.hasNextLine()) {
				String aLine = snackFile.nextLine();
				String[] theSnacks = aLine.split("\\|");
				Product newProduct = new Product(theSnacks[1], Double.parseDouble(theSnacks[2]), theSnacks[3], 5);
				mapSnack.put(theSnacks[0], newProduct);
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void PrintMap() {
		for (Map.Entry<String, Product> hold : mapSnack.entrySet()) {
			String location = hold.getKey();
			Product product = hold.getValue();
			System.out.println(location + " " + " " + product.getName() + " " + product.getPrice() + " "
					+ product.getType() + " " + product.getQuantity());
			if (product.getQuantity() <= 0) {
				System.out.println("SOLD OUT");
			}
		}
	}

	public double purchase(String location) throws IOException {
		Product snack = mapSnack.get(location);
		snack.getPrice();
		//Product price = mapSnack.get();
		int snackQuantity = snack.getQuantity();
		if (snackQuantity == 0) {
			 System.out.println("SOLD OUT");
			 
		} //if(balance < snack.getPrice()); {
			//System.out.println("Insufficent funds");
		//}
		  if(snackQuantity > 0 && snack.getPrice() <= balance) {
					snack.setQuantity(snackQuantity-1);
					balance -= snack.getPrice();
					System.out.println("The product purchased was " + snack.getName() + " and the price was $" + snack.getPrice() +" and the current balance is $" + balance);
					if (snack.getType().equals("Chip")) {
						System.out.println("Crunch Crunch, Yum!");
					}
					if (snack.getType().equals("Candy")) {
						System.out.println("Munch Munch, Yum!");
					}
					if (snack.getType().equals("Drink")) {
						System.out.println("Glug Glug, Yum!");
					}
					if (snack.getType().equals("Gum")) {
						System.out.println("Chew Chew, Yum!");
					}
					try(BufferedWriter writer = new BufferedWriter(new FileWriter("Log.txt" , true))) {
						//PrintWriter writer1 = new PrintWriter(fileWriter)){
						writer.append(timestamp +" "+ snack.getName() + ":" + moneyIn + " " + (balance));
						writer.newLine();
					}
		}
//		  for (Map.Entry<String, Product> hold1 : mapSnack.entrySet()) {
//				Product product = hold1.getValue();
//				double price = hold1.getValue().getPrice();
//				System.out.println(location + " " + " " + product.getName() + " " + product.getPrice() + " "
//						+ product.getType() + " " + product.getQuantity());
//				System.out.println("Item dispensed was " + product + "and the price was " + price + "The current balance is " + balance);
//				}
		 // System.out.println("Item dispensed was " + "The current balance is " + balance);
		return balance;

	}
	
	public String selection() {
		System.out.println("Enter the letter and number associated with the item you would like (i.e. A1)");
		Scanner userSelection = new Scanner(System.in);
		String selectionID = userSelection.nextLine();
		if (mapSnack.containsKey(selectionID) ) {
			return selectionID;
		}else {
			System.out.println("That is not a valid input");
		}return selectionID;
		
	}
			
			
	public void feedMoney() throws IOException {
		 String userInput = "";
		 
			do{	System.out.println("How much money do you want to enter?");
				Scanner inputMoneyScanner = new Scanner(System.in);
				moneyIn = Integer.parseInt(inputMoneyScanner.nextLine());
				if  (moneyIn == 3 || moneyIn == 4 || moneyIn == 6 || moneyIn == 7 || moneyIn == 8 || moneyIn == 9){
					System.out.println("That amount of money is not valid"); 
					return;
				}	
				else if (moneyIn == 1 || moneyIn == 2 || moneyIn == 5 || moneyIn == 10) {
		
				}
				
				balance += moneyIn;
				try(BufferedWriter writer = new BufferedWriter(new FileWriter("Log.txt" , true))) {
						//PrintWriter writer1 = new PrintWriter(fileWriter)){
						writer.append(timestamp +" "+"Feed Money:" + moneyIn + " "+ balance);
						//writer.newLine();
				}
				System.out.println("Do you have more money you want to enter? Enter (Y/N) ");
				Scanner inputMoneyAnswer = new Scanner(System.in);
				userInput = inputMoneyAnswer.nextLine();
			}
			
			while(userInput.equals("Y"));
			
			
			// if (moneyIn == 1 || moneyIn == 2 || moneyIn == 5 || moneyIn == 10) {
			 		
			 		
			// }
			 //else if (moneyIn <= 0) {
			 //{//( {
			//		System.out.println("That is not a valid money amount");
			 
			 
	
		
	}
		 
	public double giveChange() throws IOException {
		double balanceInitial = balance;
		double quarterChangeCounter = 0.0;
		int quarterTimesLoopedCounter = 0;
		double dimesChangeCounter = 0.0;
		int dimesTimesLoopedCounter = 0;
		double nickelChangeCounter = 0.0;
		int nickelTimesLoopedCounter = 0;
		while (balance >= 0.25) {
			balance = balance - 0.25;
			quarterChangeCounter = quarterChangeCounter + 0.25;
			quarterTimesLoopedCounter = quarterTimesLoopedCounter +1;
		} 
		while (balance < 0.25 && balance >= 0.10) {
			balance = balance - 0.10;
			dimesChangeCounter = dimesChangeCounter + 0.10;
			dimesTimesLoopedCounter = dimesTimesLoopedCounter +1;
		}
		while (balance < 0.05) {
			balance = balance - 0.05;
			nickelChangeCounter = nickelChangeCounter + 0.049;
			nickelTimesLoopedCounter = nickelTimesLoopedCounter +1;
			balance = quarterChangeCounter + dimesChangeCounter +nickelChangeCounter;
			System.out.println( "The amount of change is $" + balanceInitial + " which is " + quarterTimesLoopedCounter
					+" quarters and " +  dimesTimesLoopedCounter + " dimes and " +
					nickelTimesLoopedCounter + " nickels. The Current Balance is $0");
		}
		try(BufferedWriter writer = new BufferedWriter(new FileWriter("Log.txt" , true))) {
			//PrintWriter writer1 = new PrintWriter(fileWriter)){
			writer.append(timestamp +" "+ "GIVE CHANGE: $" +  balance + " $0.00");
			writer.newLine();
		}
		return balance =0;
		
	}
	public void salesReport () throws IOException {
		
		File aFile = new File("salesReport.txt");
		aFile.createNewFile();
		PrintWriter writer2 = new PrintWriter(aFile);
		for (Map.Entry<String, Product> hold : mapSnack.entrySet()) {
			String location = hold.getKey();
			Product product = hold.getValue();
			int quantity = product.getQuantity();
			writer2.println(product + "|" + Math.abs(quantity - 5));
			
		}
		writer2.close();
		//writer2();
	
	}


	public double getBalance() {
		return balance;
	}
	public String showBalance() {
		
		return "Current Balance is " + (balance);
	}
}
