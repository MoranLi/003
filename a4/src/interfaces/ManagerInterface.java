package interfaces;

import java.util.Scanner;

/**
 * The console interface for manager to add passenger/ check empty seat and book passenger
 */
public class ManagerInterface {
	
	/** A Scanner used to obtain console input */
	public Scanner consoleIn = new Scanner(System.in);
	
	/**A code used to check operation, preset to 99 which is not meaningful */
	private int code = 99;
	
	/**
	 * send error message when error occur
	 * @param message message obtain when error happened
	 */
	public void sendMessage(String message){
		System.out.println(message);
	}
	
	/**
	 * ask user to input a command
	 */
	public void readCommand(){
		System.out.println("Please enter your operiation code(1, 3, 4, 0):");
		code = consoleIn.nextInt();
	}
	
	/**
	 * return the command entered
	 * @return code entered code
	 */
	public int getCommand(){
		return code;
	}
	
	/**
	 * return the name obtained from console
	 * @return name form console
	 */
	public String readName(){
		System.out.print("Enter the name of the passenger: ");
		String name = consoleIn.nextLine();
		return name;
	}
	
	/**
	 * return phone number get from input
	 * @return telNumber from console
	 */
	public String readTelNumber(){
		System.out.print("Enter the telephone number of the passenger: ");
		String telNumber = consoleIn.nextLine();
		return telNumber;
	}
	
	/**
	 * return flight number from input
	 * @return FlightNumber from console
	 */
	public int readFlightNumber(){
		System.out.print("Enter the number of the Flight: ");
		int FlightNumber = consoleIn.nextInt();
		return FlightNumber;
	}
}
