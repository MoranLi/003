package commands;

import entities.Flight;
import containers.FlightSetAccess;

/**
 * Command to show empty seat of a flight.
 */
public class DisplayEmptySeat extends CommandStatus{
	
	/**
	 * Read the number for a flight, and then display its empty seats.
	 * @param number identify number of flight
	 * @exception is the flight not exist
	 */
	public void displayEmptySeats(int number){
		Flight f = FlightSetAccess.dictionary().get(number);
		if (f == null){
			errorMessage =("There is no flight with number " + number);
			successful = false;
		}
		else {
			successful = true;
			System.out.println(f.availableSeats());
		}
	}
}
