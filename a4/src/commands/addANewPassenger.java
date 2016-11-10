package commands;

import entities.Passenger;
import containers.PassengerSetAccess;

public class addANewPassenger extends CommandStatus{
	/**
	 * Read the information for a new passenger and then add the passenger 
	 * to the dictionary of all passengers.
	 */
	public void addPassenger(String name, String telNumber){
		if (PassengerSetAccess.dictionary().containsKey(name)){
			throw new RuntimeException("Person not added as there already "
								+ "is a person by the name " + name);
		}
		else{
			Passenger p = new Passenger(name, telNumber);
			Passenger sameNamePerson = PassengerSetAccess.dictionary().put(name, p);
			if (sameNamePerson != null){
				PassengerSetAccess.dictionary().put(name, sameNamePerson);  // put the original person back
				throw new RuntimeException("Name in the dictionary even though " +
						"containsKey failed.  Passenger " + name + " not entered.");
			}
		}	
	}

}
