package javaapplication4;

import java.util.Comparator;

public class Route {
	int cost;
	int time;
	int destination;

	public Route() {
		this.cost = 0;
		this.time = 0;
	}
	
	public Route(int destination, int cost, int time) {
		this.destination = destination;
		this.cost = cost;
		this.time = time;
	}

}

