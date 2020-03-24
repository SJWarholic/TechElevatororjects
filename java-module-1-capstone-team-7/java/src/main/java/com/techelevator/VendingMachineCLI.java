package com.techelevator;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**************************************************************************************************************************
*  This is your Vending Machine Command Line Interface (CLI) class
*
*  It is the main process for the Vending Machine
*
*  THIS is where most, if not all, of your Vending Machine interactions should be coded
*  
*  It is instantiated and invoked from the VendingMachineApp (main() application)
*  
*  Your code should be placed in here
***************************************************************************************************************************/
import com.techelevator.view.Menu;         // Gain access to Menu class provided for the Capstone

public class VendingMachineCLI {
	private static VM9000 inventory = new VM9000();
    // Main menu options defined as constants

	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE      = "Purchase";
	private static final String MAIN_MENU_OPTION_EXIT          = "Exit";
	private static final String MAIN_MENU__SALES_REPORT		   = "Sales Report";
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS,
													    MAIN_MENU_OPTION_PURCHASE,
													    MAIN_MENU_OPTION_EXIT,
													    MAIN_MENU__SALES_REPORT	
													    };
	
	private static final String PURCHASE_OPTION_FEED_MONEY = "Feed Money";
	private static final String PURCHASE_OPTION_SELECT_PRODUCT = "Select Product";
	private static final String PURCHASE_OPTION_FINISH_TRANSACTION = "Finish Transaction";
	//private static final String PURCHASE_OPTION_CURRENT_BALANCE = "Current Money Provided: $" + inventory.getBalance();
	private static final String[] PURCHASE_MENU_OPTIONS = { PURCHASE_OPTION_FEED_MONEY ,
															PURCHASE_OPTION_SELECT_PRODUCT,
															PURCHASE_OPTION_FINISH_TRANSACTION,
															//PURCHASE_OPTION_CURRENT_BALANCE 
													    };
	private static Menu vendingMenu;              // Menu object to be used by an instance of this class
	
	
	public VendingMachineCLI(Menu menu) {  // Constructor - user will pas a menu for this class to use
		this.vendingMenu = menu;           // Make the Menu the user object passed, our Menu
	}
	/**************************************************************************************************************************
	*  VendingMachineCLI main processing loop
	*  
	*  Display the main menu and process option chosen
	*
	*  It is invoked from the VendingMachineApp program
	*
	*  THIS is where most, if not all, of your Vending Machine objects and interactions 
	*  should be coded
	*
	*  Methods should be defined following run() method and invoked from it
	 * @return 
	 * @throws IOException 
	*
	***************************************************************************************************************************/

	public String run() throws IOException {

		boolean shouldProcess = true;         // Loop control variable
		
		while(shouldProcess) {                // Loop until user indicates they want to exit
			
			String choice = (String)vendingMenu.getChoiceFromOptions(MAIN_MENU_OPTIONS);  // Display menu and get choice
			
			switch(choice) {                  // Process based on user menu choice
			
				case MAIN_MENU_OPTION_DISPLAY_ITEMS:
					inventory.PrintMap();           // invoke method to display items in Vending Machine
					break;                    // Exit switch statement
			
				case MAIN_MENU_OPTION_PURCHASE:
					boolean shouldSecondProcess = true;
					while (shouldSecondProcess) {
					String secondChoice = (String)vendingMenu.getChoiceFromOptions(PURCHASE_MENU_OPTIONS);  // Display menu and get choice
					
					switch(secondChoice) {                  // Process based on user menu choice
						
						case PURCHASE_OPTION_FEED_MONEY:
							
							inventory.feedMoney();  
							System.out.println("Current Money Provided: $" + inventory.getBalance());
							
							break;                    
						
						case PURCHASE_OPTION_SELECT_PRODUCT:
							inventory.PrintMap();
							inventory.purchase(inventory.selection());
							
							break;                   
					
						case PURCHASE_OPTION_FINISH_TRANSACTION:
							inventory.giveChange();
							shouldSecondProcess = false;
							break;
							
							
						
					} 
						
					}
					break;
				case MAIN_MENU_OPTION_EXIT:
						endMethodProcessing();
						return choice;
						
						
				case MAIN_MENU__SALES_REPORT:
					
					break;
			}
					
		} 	
			
			return "";   
		}// End method and return to caller
	
private void PrintMap() {
		// TODO Auto-generated method stub
		
	}
/********************************************************************************************************
 * Methods used to perform processing
 ********************************************************************************************************/
	public static void displayItems() {      // static attribute used as method is not associated with specific object instance
		// Code to display items in Vending Machine
		
	}
	
	public static void purchaseItems() {}
		
	
	public static void endMethodProcessing() { // static attribute used as method is not associated with specific object instance
		System.out.println("Thank you! Have a great day!");// Any processing that needs to be done before method ends
	}
	 
	 static double change = 0.0;
//	 public int feedMoneyQuestion() {
//		 System.out.println("How much money do you want to enter?");
//		 Scanner inputMoneyScanner = new Scanner(System.in);
//		 int moneyIn = Integer.parseInt(inputMoneyScanner.nextLine());
//		return (int)balance + moneyIn;
		
		
		
	// }
	 
}
