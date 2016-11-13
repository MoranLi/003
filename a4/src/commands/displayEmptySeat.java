package commands;

import entities.Flight;
import containers.FlightSetAccess;

/**
 * Command to show empty seat of a flight.
 */
public class displayEmptySeat extends CommandStatus{
	
	/**
	 * Read the number for a flight, and then display its empty seats.
	 * @param number identify number of flight
	 * @exception is the flight not exist
	 */
	public void displayEmptySeats(int number){
		Flight f = FlightSetAccess.dictionary().get(number);
		if (f == null)
			throw new RuntimeException("There is no flight with number " + number);
		else 
			System.out.println(f.availableSeats());
	}
}
