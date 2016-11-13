package startup;

import interfaces.ManagerInterface;
/**
 * A class to run the bank application using console I/O.
 */
public class startup {
	/**
     * Run the flight reservation system.
     */
	public static void main(String[] args) {
		/*
		 * print out control help for user
		 */
		System.out.println("Welcome to the Flight Reservation System!\n");
		System.out.println("The only functions we support now is\n\t1. add passenger\n\t3. display empty seat\n\t4.book a passenger\n\t0. quit\n");
		System.out.println("We only support 2 flight right now, x1(code:1) and x2(code: 2)\n");
		/*
		 * call the interface
		 */
		ManagerInterface aInterface = new ManagerInterface();
		/*
		 * call the controller
		 */
		Controller aController = new Controller();
		/*
		 * check if user want to exit
		 */
		while(aInterface.getCommand() != 0){
			/*
			 * read command from user
			 */
			aInterface.readCommand();
			/*
			 * process command and do task
			 */
			aController.processCommandsFor(aInterface.getCommand());
		}
		
		
	}

}
