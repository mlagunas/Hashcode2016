package models;

import java.util.ArrayList;

public class Drone {
	
	private Coordinates position;
	private ArrayList<Product> products;
	private int maxWeight;
	private int acumulatedWeight;

	public Drone(Coordinates position, ArrayList<Product> products, int maxWeight) {
		this.position = position;
		this.products = products;
		this.maxWeight = maxWeight;
		this.acumulatedWeight = 0;
	}

	public ArrayList<Product> getProducts() {
		return products;
	}

	public void setProducts(ArrayList<Product> products) {
		this.products = products;
	}
	
	
	public Coordinates getPosition() {
		return position;
	}

	public void setPosition(Coordinates position) {
		this.position = position;
	}

	public int getMaxWeight() {
		return maxWeight;
	}

	public void setMaxWeight(int maxWeight) {
		this.maxWeight = maxWeight;
	}

	public int getAcumulatedWeight() {
		return acumulatedWeight;
	}

	public void setAcumulatedWeight(int acumulatedWeight) {
		this.acumulatedWeight = acumulatedWeight;
	}

	public void unload(String pId, int num) {
		boolean end = false;
		for (Product p:products) {
			if (p.getId().equals(pId)) {
				p.unload(num);
				end = true;
				break;
			}
		}
		
		if (!end) {
			products.add(new Productp(pId, num));
		}
	}
	

	public void load(String pId, int num, Warehouse wh) {
		boolean end = false;
		for (Product p:products) {
			if (p.getId().equals(pId)) {
				p.add(num);				// Aumenta la cantidad de items
				end = true;
				break;
			}
		}
		
		if (!end) {
			products.add(new Productp(pId, num));
		}
		
		wh.unload(wh);
	}
	

}
