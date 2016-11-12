package interfaces;

import java.util.Scanner;

public class ManagerInterface {
	
	public Scanner consoleIn = new Scanner(System.in);
	
	private int code = 99;
	
	public void sendMessage(String message){
		System.out.println(message);
	}
	
	public void readCommand(){
		System.out.println("Please enter your operiation code(1, 3, 4, 0):");
		code = consoleIn.nextInt();
	}
	
	public int getCommand(){
		return code;
	}
	
	public String readName(){
		System.out.print("Enter the name of the passenger: ");
		String name = consoleIn.nextLine();
		return name;
	}
	
	public String readTelNumber(){
		System.out.print("Enter the telephone number of the passenger: ");
		String telNumber = consoleIn.nextLine();
		return telNumber;
	}
	
	public int readFlightNumber(){
		System.out.print("Enter the number of the Flight: ");
		int FlightNumber = consoleIn.nextInt();
		return FlightNumber;
	}
}
