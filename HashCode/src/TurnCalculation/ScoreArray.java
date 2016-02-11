package TurnCalculation;

import java.util.ArrayList;
import java.util.HashMap;

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

	private static boolean hasProduts(Warehouse wh, Order order) {
		boolean result = true;
		for (Product p : wh.getProducts()) {
			if (!order.getProducts().contains(p)) {
				result = false;
				break;
			}
		}
		return result;
	}

	private static long traceTurn(Drone dron, Order order, Warehouse wh) {
		long turn = actualTurn;
		if (hasProduts(wh, order)) {
			for (Product p : order.getProducts()) {
				dron.load(p.getType(), 1, wh);
			}
			turn += Utils.euclideanDistance(dron, order);
			for (Product p : order.getProducts()) {
				turn++;
				dron.deliver(p, order);
			}
		} else
			return -1;
		return Math.round(turn);
	}

	public static HashMap<Order, Long> getTurns(Drone dron,
			ArrayList<Order> orders, ArrayList<Warehouse> whs) {

		HashMap<Order, Long> scores = new HashMap<Order, Long>();
		long best = Long.MAX_VALUE;
		Order bestO = null;
		for (Order o : orders) {
			for (Warehouse w : whs) {
				if (hasProduts(w, o)) {
					long valor = traceTurn(dron, o, w);
					if (valor < best){
						bestO = o;
						best = valor;
					}
				}
			}
			scores.put(o, best);
		}
		return scores;
	}

}
