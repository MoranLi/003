package commands;

import entities.Flight;
import entities.Passenger;
import containers.PassengerSetAccess;
import containers.FlightSetAccess;

/**
 * Command to book a passenger to a flight.
 */
public class bookARegularPassenger extends CommandStatus{
	/**
	 * Read the name for a passenger, the number for a flight, and then book
	 * the passenger on the flight as a regular passenger.
	 * @param name used to find passenger
	 * @param number used to find flight
	 * @exception if the passenger not exist
	 * @exception if the flight not exist
	 */
	public void bookPassenger(String name, int number){
		Passenger p = PassengerSetAccess.dictionary().get(name);
		if (p == null)
			throw new RuntimeException("There is no passenger with name " + name);
		Flight f = FlightSetAccess.dictionary().get(number);
		if (f == null)
			throw new RuntimeException("There is no flight with number " + number);
		else f.makeBooking(p);
	}
}
