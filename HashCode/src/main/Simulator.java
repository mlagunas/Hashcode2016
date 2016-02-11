package main;

import java.util.ArrayList;
import java.util.PriorityQueue;

import models.Drone;
import models.Order;
import models.Utils;
import models.Warehouse;

public class Simulator {

	PriorityQueue<Drone> drones;
	ArrayList<Warehouse> warehouses;
	
	public Simulator() {
		this.drones = new PriorityQueue<Drone>();
		this.warehouses = new ArrayList<Warehouse>();
	}
	
	
	public void getMinWH() {
		Drone dr = drones.poll();
		
		float minDistance = 0;
		Warehouse goodWH = null;
		
		for (Warehouse wh: warehouses) {
			if (Utils.euclideanDistance(dr, wh)<minDistance) {
				minDistance = Utils.euclideanDistance(dr, wh);
				goodWH = wh;
			}
		}
		
		dr.addTurn((int) Math.ceil(minDistance+1));
		dr.setPosition(goodWH.getCoordinates());
		updateQueueDrones();
	}
	
	
	public void addDrone(Drone dr) {
		drones.add(dr);
	}
	
	private void updateQueueDrones() {
		PriorityQueue<Drone> aux = new PriorityQueue<Drone>();
		
		while (drones.size()!= 0) {
			aux.add(drones.poll());
		}
		
		this.drones = aux;
	}
 	
	
	public static void main(String[] args) {
		/*Simulator sm = new Simulator();
		Drone dr1 = new Drone(0, null, null, 0);
		dr1.addTurn();dr1.addTurn();dr1.addTurn();
		sm.addDrone(dr1);
		Drone dr2 = new Drone(0, null, null, 0);
		dr2.addTurn();
		sm.addDrone(dr2);
		Drone dr3= new Drone(0, null, null, 0);
		dr3.addTurn();dr3.addTurn();dr3.addTurn();dr3.addTurn();dr3.addTurn();
		sm.addDrone(dr3);
		
		PriorityQueue<Drone> pd = sm.drones;
		
		
		System.out.println(pd.size());
		dr1 = pd.poll();
		System.out.println(dr1.getId() + "  " + dr1.getAccumulatedTurns());
		dr1 = pd.poll();
		System.out.println(dr1.getId() + "  " + dr1.getAccumulatedTurns());
		dr1 = pd.poll();
		System.out.println(dr1.getId() + "  " + dr1.getAccumulatedTurns());*/
		
		System.out.println((int) Math.ceil(2));
		
	}
	
	
}
