package javaapplication4;

import java.util.Comparator;
import java.util.LinkedList;

public class City {
	int id;
	LinkedList<Route> routes;
	int costFromSource;
	int timeFromSource;
	int numberOfStops;
	City parent;
	
	public City(int id) {
		this.id = id;
		routes = new LinkedList<Route>();
	}
	
	public void addRoute(int destination, int cost, int time) {
		routes.add(new Route(destination, cost, time));
	}

}

class CityComparator implements Comparator<City> {

	@Override
	public int compare(City c1, City c2) {
		if (c1.costFromSource < c2.costFromSource)
			return -1;
		else if (c2.costFromSource < c1.costFromSource)
			return 1;
		return 0;
	}
}

