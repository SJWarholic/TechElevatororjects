package com.techelevator;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.techelevator.view.Menu;

public class TestCode extends VM9000{
	
public TestCode() throws FileNotFoundException {
		super();
	
	}

public static void main(String[] args) throws IOException {
		VendingMachineCLI vmc = new VendingMachineCLI(new Menu(System.in, System.out));
		vmc.run();

	}	
/*
	static double balance = 10.0;
	 static double change = 0.0;
	 static double price = mapSnack.get("A1").getPrice();
	 
	 public static String returnChange() {
			change = balance - price; 
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
*/

}
