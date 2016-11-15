package startup;

import commands.AddANewPassenger;
import commands.DisplayEmptySeat;
import commands.BookARegularPassenger;
import interfaces.ManagerInterface;
import containers.FlightSetAccess;
import containers.PassengerSetAccess;
import entities.Flight;
import entities.Passenger;

public class FlightReservationSystem {
	
	/**
	 * ManagerInterface is the interface used to obtain input form console
	 */
	ManagerInterface aInterface = new ManagerInterface();

		
	/**
	 * Run the reservation system: initialize, and then accept and carry out
	 * operations.  Output the passenger and flight dictionaries when finishing.
	 */
	public void run(int opId)
	{
		while (opId != 0)
		{
			try
			{
				switch (opId)
				{
				case 1:
					addPassenger();
	            	break;
				case 2:
					//addFlight();
					System.out.println("This command is not done yet.");
					break;
				case 3:
					 displayEmptySeats();
		             break;
				case 4:
					 bookPassenger();
		             break;
				case 5:
					//bookFirstClassPassenger();
					System.out.println("This command is not done yet.");
					break;
				case 6:
					//assignSeatForPassenger();
					System.out.println("This command is not done yet.");
					break;
				case 7:
					//System.out.println("\nThe passengers in the system are \n" + passengers);
					System.out.println("This command is not done yet.");
					break;
				case 8:
					//System.out.println("\nThe flights in the system are \n" + flights);
					System.out.println("This command is not done yet.");
					break;
				default:
					System.out.println("Invalid int value; try again");
				}
			} catch (RuntimeException e)
			{
				System.out.println(e.getMessage());
			}

			opId = readOpId();
		}
		
		System.out.println("The system at shutdown is as follows: " + toString());
	}
	
	/**
	 * Output the prompt to list the possible operations, 
	 * and read selection picked by the user.
	 * @return  the int corresponding to the operation selected
	 */
	public int readOpId()
	{
		int id;
		System.out.print("Please select an operation to do"
				+ "\n0: quit"
				+ "\n1: add a new passenger"
				+ "\n2: add a new flight"
				+ "\n3: display the empty seats of a flight"
				+ "\n4: book a passenger on a flight"
				+ "\n5: book a first-class passenger on a flight"
				+ "\n6: assign a passenger a seat"
				+ "\n7: display all the passengers"
				+ "\n8: display all the flights"
				+ "\nEnter the number of your selection: ");
		id = aInterface.readInt();
		return id;
	}
	
	/**
	 * Read the information for a new passenger and then add the passenger 
	 * to the dictionary of all passengers.
	 */
	public void addPassenger()
	{
		String name = aInterface.readName();
		String telNumber = aInterface.readTelNumber();
		AddANewPassenger addPeople = new AddANewPassenger();
		addPeople.addPassenger(name,telNumber);
		if (addPeople.wasSuccessful()) {
			aInterface.sendMessage("Add passenger successful.");
	    } 
		else{
			aInterface.sendMessage(addPeople.getErrorMessage());
		}
	}
	
	/**
	 * Read the information for a new flight and then add the flight 
	 * to the dictionary of all flights.
	 */
	public void addFlight()
	{
		System.out.print("Enter the number of the flight: ");
		int number = aInterface.readInt();
		if (FlightSetAccess.dictionary().containsKey(number))
			throw new RuntimeException("Flight not added as there already "
					+ "is a flight with the number " + number);
		System.out.print("Enter the width of the flight: ");
		int width = aInterface.readInt();
		System.out.print("Enter the capacity of the flight: ");
		int capacity = aInterface.readInt();
		Flight f = new Flight(number, width, capacity);
		Flight sameNumberFlight = FlightSetAccess.dictionary().put(number, f);
		if (sameNumberFlight != null)
		{
			FlightSetAccess.dictionary().put(number, sameNumberFlight); // put the original flight back
			throw new RuntimeException("Number in the dictionary even though " +
					"containsKey failed.  Flight "  + number + " not entered.");
		}
	}

	
	/**
	 * Read the number for a flight, and then display its empty seats.
	*/

	public void displayEmptySeats()
	{
		int number = aInterface.readFlightNumber();
		DisplayEmptySeat displayObjectA = new DisplayEmptySeat();
		displayObjectA.displayEmptySeats(number);
		if (displayObjectA.wasSuccessful()) {
			aInterface.sendMessage("Print empty seat successful");
	    } 
		else{
			aInterface.sendMessage(displayObjectA.getErrorMessage());
		}
	}
	
	/**
	 * Read the name for a passenger, the number for a flight, and then book
	 * the passenger on the flight as a regular passenger.
	 */
	public void bookPassenger()
	{
		String name = aInterface.readName();
		int number = aInterface.readFlightNumber();
		BookARegularPassenger bookOne = new BookARegularPassenger();
		bookOne.bookPassenger(name,number);
		if (bookOne.wasSuccessful()) {
			aInterface.sendMessage("Book Passenger successful.");
	    }
		else{
			aInterface.sendMessage(bookOne.getErrorMessage());
		}
	}

	/**
	 * Read the name for a passenger, the number for a flight, the seat for the passenger,
	 * and the meal plan for the passenger, and then book
	 * the passenger on the flight as a first class passenger.
	 */
	public void bookFirstClassPassenger()
	{
		System.out.print("Enter the name of the passenger: ");
		String name = aInterface.readName();;
		Passenger p = PassengerSetAccess.dictionary().get(name);
		if (p == null)
			throw new RuntimeException("There is no passenger with name " + name);
		System.out.print("Enter the number of the flight: ");
		int number = aInterface.readFlightNumber();
		Flight f = FlightSetAccess.dictionary().get(number);
		if (f == null)
			throw new RuntimeException("There is no flight with number " + number);
		System.out.print("Enter the seat for the passenger: ");
		String seat = aInterface.readString();
		System.out.print("Enter the meal plan of the passenger: ");
		String meal = aInterface.readString();
		f.makeFirstClassBooking(p, seat, meal);
	}
	
	/** 
	 * Read the name for a passenger, the number for a flight, and the seat for the
	 * passenger on the flight, and then assign the passenger the seat on the flight.
	 */
	public void assignSeatForPassenger()
	{
		System.out.print("Enter the name of the passenger: ");
		String name = aInterface.readName();
		Passenger p = PassengerSetAccess.dictionary().get(name);
		if (p == null)
			throw new RuntimeException("There is no passenger with name " + name);
		System.out.print("Enter the number of the flight: ");
		int number = aInterface.readFlightNumber();
		Flight f = FlightSetAccess.dictionary().get(number);
		if (f == null)
			throw new RuntimeException("There is no flight with number " + number);
		System.out.print("Enter the seat for the passenger: ");
		String seat = aInterface.readString();
		f.assignSeat(p, seat);
	}
	
	/**
	 * @return a String that contains all the passengers and flights in the system.
	 */
	public String toString()
	{
		/* The output should be formatted much better, 
		 * but show the format from a Map. */
		String result = "\nThe passengers in the system are \n" + PassengerSetAccess.dictionary();
		result = result + "\n\nThe flights in the system are \n" + FlightSetAccess.dictionary();
		return result + "\n";
	}
	/**
	 * Run the flight reservation system.
	 * @param args not used
	 */
	public static void main(String[] args) 
	{
		System.out.print("Please select an operation to do"
				+ "\n0: quit"
				+ "\n1: add a new passenger"
				+ "\n2: add a new flight"
				+ "\n3: display the empty seats of a flight"
				+ "\n4: book a passenger on a flight"
				+ "\n5: book a first-class passenger on a flight"
				+ "\n6: assign a passenger a seat"
				+ "\n7: display all the passengers"
				+ "\n8: display all the flights"
				+ "\nEnter the number of your selection: ");
		/*
		 * call the interface
		 */
		ManagerInterface aInterface = new ManagerInterface();
		/*
		 * call the controller
		 */
		FlightReservationSystem aController = new FlightReservationSystem();
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
			aController.run(aInterface.getCommand());
		}	
	}
}
