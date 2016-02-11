package TurnCalculation;

import models.Drone;
import models.Order;
import models.Warehouse;

public class Value {

	private Warehouse wh;
	private Order ord;
	private Drone dron;

	public Value(Warehouse wh, Order ord, Drone dron) {
		this.wh = wh;
		this.ord = ord;
		this.dron = dron;
	}

	public Warehouse getWh() {
		return wh;
	}

	public void setWh(Warehouse wh) {
		this.wh = wh;
	}

	public Order getOrd() {
		return ord;
	}

	public void setOrd(Order ord) {
		this.ord = ord;
	}

	public Drone getDron() {
		return dron;
	}

	public void setDron(Drone dron) {
		this.dron = dron;
	}

}
