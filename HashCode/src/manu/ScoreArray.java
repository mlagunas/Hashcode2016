package manu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import models.Drone;
import models.Order;
import models.Product;
import models.Utils;
import models.Warehouse;

public class ScoreArray {
	private static int actualTurn = 0;

	public static int getActualTurn() {
		return actualTurn;
	}

	public static void setActualTurn(int actualTurn) {
		ScoreArray.actualTurn = actualTurn;
	}

	private static long traceScore(Drone dron, Order order, Warehouse wh) {
		long turn = actualTurn;
		turn += Utils.euclideanDistance(dron, wh);
		for (Product p : order.getProducts()) {
			dron.load(p.getType(), 1, wh);
		}
		turn += Utils.euclideanDistance(dron, order);
		for (Product p : order.getProducts()) {
			turn++;
			dron.deliver(p.getType(), 1, order);
		}
		return Math.round(turn);
	}

	public static HashMap<Value, Long> AllScores(Drone dron,
			ArrayList<Order> orders, ArrayList<Warehouse> whs) {
		HashMap<Value, Long> scores = new HashMap<Value, Long>();
		
			for (Order o : orders) {
				for (Warehouse w : whs) {
					scores.put(new Value(w, o, d), traceScore(d, o, w));
				}
			}
		
		return scores;
	}

	public static HashMap<Order, Long> bestScores(ArrayList<Order> orders,
			ArrayList<Warehouse> whs) {
		HashMap<Order,Long> scores = new HashMap<Order, Long>();
		HashMap
		for(Order o: orders){
			for(Warehouse w: whs){
				boolean visit = true;
				//TO-DO mirar si hay que ir a varios warehouses a coger productos
				for(Product p: o.getProducts()){
					if (!w.getProducts().contains(p)){
						visit = false;
					}
				}
				if(visit){
					
				}
			}
		}
		return null;

	}

}
