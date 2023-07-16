package javaapplication4;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;
import javaapplication4.CityComparator;

public class Problem3 {
	int M, numberOfCities, numberOfRoutes, source, destination, time, cost;
	
	public void run() { 		
		Scanner input = new Scanner(System.in);
		
		System.out.println("please enter amount M:");
		M = input.nextInt();
		
		System.out.println("please enter number of cities:");
		numberOfCities = input.nextInt();
		
		System.out.println("please enter number of routes:");
		numberOfRoutes = input.nextInt();
		
		City[] graph = new City[numberOfCities];
		for (int i = 0; i < numberOfCities; i++)
		{
			graph[i] = new City(i);
		}
		
		System.out.println("please enter source , destination, time and cost for each route:");
		for (int i = 0; i < numberOfRoutes; i++)
		{
			source = input.nextInt() - 1;
			destination = input.nextInt() - 1;
			time = input.nextInt();
			cost = input.nextInt();
			
			graph[source].addRoute(destination, cost, time);
			graph[destination].addRoute(source, cost, time);
		}
		
		System.out.println("please enter source city:");
		source = input.nextInt() - 1;
		
		System.out.println("please enter destination city:");
		destination = input.nextInt() - 1;
		
		dijkstra(graph, source, destination);
	}
	
	public void dijkstra(City[] graph, int source, int destination) {
		boolean[] SPT = new boolean[numberOfCities];
			
		for (int i = 0; i < numberOfCities; i++)
		{
			graph[i].costFromSource = Integer.MAX_VALUE;
			graph[i].timeFromSource = 0;
			graph[i].numberOfStops = 0;
			SPT[i] = false;
		}
		graph[source].costFromSource = 0;
		graph[source].numberOfStops = -1;
		graph[source].timeFromSource = -1;
		
		PriorityQueue<City> queue = new PriorityQueue<City>(numberOfCities, new CityComparator());
		queue.addAll(Arrays.asList(graph));
		
		while (!queue.isEmpty())
		{
			City u = queue.poll();
			SPT[u.id] = true;
			
			if (u.id == destination)
				break;
			
			for (Route r : u.routes)
			{
				City v = graph[r.destination];
				
				if ((!SPT[v.id]) && (u.costFromSource + r.cost + (r.time + u.numberOfStops + 1)*M < v.costFromSource))
				{
					v.numberOfStops = u.numberOfStops + 1;
					v.costFromSource = u.costFromSource + r.cost + (r.time + v.numberOfStops)*M;
					v.timeFromSource = u.timeFromSource + r.time + 1;
					v.parent = u;
					queue.remove(v);
					queue.add(v);
				}
			}
		}
		
		System.out.print("The route with minimum cost is ");
		printPath(graph[destination]);
		System.out.println("Total time " + graph[destination].timeFromSource + " hours");
		System.out.println("Total cost = " + graph[destination].costFromSource + "$");
		System.out.println();
			
	}
	
	public void printPath(City v) {
		if (v == null)
			return;
		
		printPath(v.parent);
		System.out.print(v.id+1);
		
		if (v.id != destination)
			System.out.print("->");
		else
			System.out.println();
	}

}

