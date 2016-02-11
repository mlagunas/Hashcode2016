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
				//LOAD
				turn ++;
				//dron.load(p.getType(), 1, wh);
			}
			turn += Utils.euclideanDistance(dron, order);
			for (Product p : order.getProducts()) {
				turn++;
				//DELIVER
				//dron.deliver(p, order);
			}
		} else
			return -1;
		return Math.round(turn);
	}

	public static Order getTurns(Drone dron,
			ArrayList<Order> orders, ArrayList<Warehouse> whs) {
		long best = Long.MAX_VALUE;
		Order bestO = null;
		Warehouse wh = null;
		for (Order o : orders) {
			for (Warehouse w : whs) {
				if (hasProduts(w, o)) {
					long valor = traceTurn(dron, o, w);
					if (valor != -1 && valor < best){
						bestO = o;
						best = valor;
						wh = w;
					}
				}
			}
		}
		int initialWeight = dron.getMaxWeight();
		for (Product p : bestO.getProducts()) {
			//LOAD
			int weight = initialWeight - p.getWeight();
			if(weight<0)
				break;
			dron.setMaxWeight(weight);
			dron.load(p.getType(), 1, wh);
			ArrayList<Product> pa = bestO.getProducts();
			pa.remove(p);
			bestO.setProducts(pa);
		}
		for (Product p : bestO.getProducts()) {
			//DELIVER
			dron.deliver(p, bestO);
		}
		dron.setMaxWeight(initialWeight);
		return bestO;
	}

}
