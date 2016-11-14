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
		if (p == null){
			errorMessage=("There is no passenger with name " + name);
			successful = false; 
		}
		else{
			Flight f = FlightSetAccess.dictionary().get(number);
			if (f == null){
				errorMessage=("There is no flight with number " + number);
				successful = false; 
			}
			else 
				f.makeBooking(p);
				successful = true;
		}
	}
}
