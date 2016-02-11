package main;

import java.util.ArrayList;
import java.util.PriorityQueue;

import models.Drone;
import models.Order;

public class Simulator {

	PriorityQueue<Drone> drones;
	ArrayList<Order> orders;
	
	public Simulator() {
		this.drones = new PriorityQueue<Drone>();
	}
	
	public void addDrone(Drone dr) {
		drones.add(dr);
	}
	
	public void addTurnToDrone(int idDrone) {
		for (Drone d:drones) {
			if (d.getId() == idDrone) {
				d.addTurn();
				break;
			}
		}
	}
	
	
	public static void main(String[] args) {
		Simulator sm = new Simulator();
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
		System.out.println(dr1.getId() + "  " + dr1.getAccumulatedTurns());
		
	}
	
	
}
