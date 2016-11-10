package containers;

import java.util.HashMap;

import entities.Passenger;

/**
 * A singleton class to access the dictionary of Passengers.
 */
public class PassengerSetAccess {
	
	/**
     * Private constructor to ensure that no instance is created.
     */
	private PassengerSetAccess(){};
	
	/** The dictionary for Passengers. */
	private static HashMap<String, Passenger> dictionary;
	
	/**
     * Return the dictionary that maps Passenger numbers to Passenger objects.
     * 
     * @return the dictionary that maps Passenger numbers to Passenger objects
     */
	public static HashMap<String, Passenger> dictionary() {
        if (dictionary == null) {
            /* Create the initial dictionary. */
            dictionary = new HashMap<String, Passenger>();
        }
        return dictionary;
    }
	
}
