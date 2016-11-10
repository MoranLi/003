package commands;

import entities.Flight;
import containers.FlightSetAccess;


public class displayEmptySeat extends CommandStatus{
	
	/**
	 * Read the number for a flight, and then display its empty seats.
	 */
	public void displayEmptySeats(int number){
		Flight f = FlightSetAccess.dictionary().get(number);
		if (f == null)
			throw new RuntimeException("There is no flight with number " + number);
		else 
			System.out.println(f.availableSeats());
	}
}
