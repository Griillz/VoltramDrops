package managers;

import main.DropLocations;

public class DropLocationsManager {
	
	public static DropLocations createNewDropLocations(String name) {
		return new DropLocations(name);
	}
}
