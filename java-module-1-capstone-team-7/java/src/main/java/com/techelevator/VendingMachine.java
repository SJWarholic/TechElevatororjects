package com.techelevator;

import java.io.FileNotFoundException;

import com.techelevator.view.Menu;

public class VendingMachine {
	
	public VendingMachine() throws FileNotFoundException {
		super();
		// TODO Auto-generated constructor stub
	}

	static double balance = 10.0;
	 static double change = 0.0;
	 //static double price = mapSnack.get("A1").getPrice();
	//private Product price = ;
	
	
			
	public double feedMoney(int moneyIn) {
		moneyIn = 0;
		if (moneyIn == 1 || moneyIn == 2 || moneyIn == 5 || moneyIn == 10) {
				balance += moneyIn;
		}
		return balance;
	}
	
	public double transactionBalance() {
		//(balance - price;)
		return balance;
	}
	public static String returnChange() {
		//change = balance - price; 
		double changeHold = change;
		double quarterChangeCounter = 0.0;
		int quarterTimesLoopedCounter = 0;
		double dimesChangeCounter = 0.0;
		int dimesTimesLoopedCounter = 0;
		double nickelChangeCounter = 0.0;
		int nickelTimesLoopedCounter = 0;
		while (change >= 0.25) {
			change = change - 0.25;
			quarterChangeCounter = quarterChangeCounter + 0.25;
			quarterTimesLoopedCounter = quarterTimesLoopedCounter +1;
		} 
		while (change < 0.25 && change >= 0.10) {
			change = change - 0.10;
			dimesChangeCounter = dimesChangeCounter + 0.10;
			dimesTimesLoopedCounter = dimesTimesLoopedCounter +1;
		}
		while (change < 0.05) {
			change = change - 0.05;
			nickelChangeCounter = nickelChangeCounter + 0.0491;
			nickelTimesLoopedCounter = nickelTimesLoopedCounter +1;
			change = quarterChangeCounter + dimesChangeCounter +nickelChangeCounter;
		}
		return "The amount of change is $" + changeHold + " which is " + quarterTimesLoopedCounter
				+" quarters and " +  dimesTimesLoopedCounter + " dimes and " +
				nickelTimesLoopedCounter + " nickels.";
	}
	
	
	
	
	
	
	
}
