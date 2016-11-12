package startup;

import java.util.Scanner;

import interfaces.ManagerInterface;

public class startup {
	
	Scanner codeScan = new Scanner(System.in);

	public static void main(String[] args) {
		
		System.out.println("Welcome to the Flight Reservation System!\n");
		System.out.println("The only functions we support now is\n\t1. add passenger\n\t3. display empty seat\n\t4.book a passenger\n\t0. quit\n");
		System.out.println("We only support 2 flight right now, x1(code:1) and x2(code: 2)\n");
		ManagerInterface aInterface = new ManagerInterface();
		Controller aController = new Controller();
		while(aInterface.getCommand() != 0){
			aInterface.readCommand();
			aController.processCommandsFor(aInterface.getCommand());
		}
		
		
	}

}
