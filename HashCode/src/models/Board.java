package models;

import java.util.ArrayList;

public class Board {

	private ArrayList<Drone> drones;
	private ArrayList<Warehouse> whs;
	private ArrayList<Order> orders;
	
	private int rows;
	private int columns;
	
	public Board(ArrayList<Drone> drones, ArrayList<Warehouse> whs,
			ArrayList<Order> orders, int rows, int columns) {
		super();
		this.drones = drones;
		this.whs = whs;
		this.orders = orders;
		this.rows = rows;
		this.columns = columns;
	}
	
}
