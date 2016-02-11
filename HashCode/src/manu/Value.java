
package manu;

import models.Drone;
import models.Order;
import models.Warehouse;

public class Value {

	private static Warehouse wh;
	private static Order ord;
	private static Drone dron;
	public static Warehouse getWh() {
		return wh;
	}
	public static void setWh(Warehouse wh) {
		Value.wh = wh;
	}
	public static Order getOrd() {
		return ord;
	}
	public static void setOrd(Order ord) {
		Value.ord = ord;
	}
	public static Drone getDron() {
		return dron;
	}
	public static void setDron(Drone dron) {
		Value.dron = dron;
	}
	
	
}
