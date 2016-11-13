package startup;

import commands.addANewPassenger;
import commands.displayEmptySeat;
import commands.bookARegularPassenger;
import interfaces.ManagerInterface;

/**
 *Class to obtain and handle a sequence of user commands using console interface.
 */
public class Controller {
	
	/**
	 * ManagerInterface is the interface used to obtain input form console
	 */
	ManagerInterface aInterface = new ManagerInterface();

	/**
     * Start the main control loop for a user; obtain an operation specification and carry out the
     * operation.
     * 
     * @param command type of the command switch the operation
     * @precond command == 1 || command == 3 || command == 4 || command == 0
     */
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
	
	/**
	 * create a passenger datatype by interface and add it to map
	 */
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
	
	/**
	 * search flight by number and call function to display all empty seat
	 */
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
	
	/**
	 * make a booking to passenger on specified flight
	 */
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
