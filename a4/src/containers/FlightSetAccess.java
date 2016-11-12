package containers;

import java.util.HashMap;

import entities.Flight;

/**
 * A singleton class to access the dictionary of Flights.
 */
public class FlightSetAccess {
	
	/**
     * Private constructor to ensure that no instance is created.
     */
	private FlightSetAccess(){};
	
	/** The dictionary for Flights. */
	private static HashMap<Integer, Flight> dictionary;
	
	/**
     * Return the dictionary that maps Flight numbers to Flight objects.
     * 
     * @return the dictionary that maps Flight numbers to Flight objects
     */
	public static HashMap<Integer, Flight> dictionary() {
        if (dictionary == null) {
            /* Create the initial dictionary. */
            dictionary = new HashMap<Integer, Flight>();
            Flight x1 = new Flight(1,4,36);
            Flight x2 = new Flight(2,9,36);
            dictionary.put(1, x1);
            dictionary.put(2, x2);
        }
        return dictionary;
    }
	
}
