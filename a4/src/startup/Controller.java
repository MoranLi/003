package startup;

import java.util.Scanner;

import commands.addANewPassenger;
import commands.displayEmptySeat;
import commands.bookARegularPassenger;
import interfaces.ManagerInterface;


public class Controller {
	
	ManagerInterface aInterface = new ManagerInterface();
	
	Scanner consoleIn = new Scanner(System.in);
	
	public void processCommandsFor(int command){
       
        switch (command) {
            case 1:
            	addPassenger();
            	break;
            case 3:
                displayEmptySeat();
                break;
            case 4:
                bookPassenger();
                break;
            case 0:
            	break;
            default:
                throw new IllegalArgumentException(
                        "The user must be either a teller "
                                + "or an administrator");
       }
	}
	
	public void addPassenger(){
		String name = aInterface.readName();
		String telNumber = aInterface.readTelNumber();
		addANewPassenger addPeople = new addANewPassenger();
		addPeople.addPassenger(name,telNumber);
		if (addPeople.wasSuccessful()) {
			aInterface.sendMessage("Deposit successful.\nReceipt being printed.");
	    } 
		else{
			aInterface.sendMessage(addPeople.getErrorMessage());
		}
	}
	
	public void displayEmptySeat(){
		int number = aInterface.readFlightNumber();
		displayEmptySeat displayObjectA = new displayEmptySeat();
		displayObjectA.displayEmptySeats(number);
		if (displayObjectA.wasSuccessful()) {
			aInterface.sendMessage("Deposit successful.\nReceipt being printed.");
	    } 
		else{
			aInterface.sendMessage(displayObjectA.getErrorMessage());
		}
	}
	
	public void bookPassenger(){
		String name = aInterface.readName();
		int number = aInterface.readFlightNumber();
		bookARegularPassenger bookOne = new bookARegularPassenger();
		bookOne.bookPassenger(name,number);
		if (bookOne.wasSuccessful()) {
			aInterface.sendMessage("Deposit successful.\nReceipt being printed.");
	    } 
		else{
			aInterface.sendMessage(bookOne.getErrorMessage());
		}
	}
}
