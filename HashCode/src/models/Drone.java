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

	
	public void load(int type, int num, Warehouse wh) {
		boolean end = false;
		for (Product p:products) {
			if (p.getType() == type) {
				p.put(num);
				break;
			}
		}
		
		if (!end) {
			products.add(new Product(type, num));
		}
		
		wh.getProduct(type, num);
		this.position = wh.getCoordinates();
	}
	
	public void deliver(int type, int num, Order order) {
		for (Product p:products) {
			p.retrieve(num);
			if (p.getWeight()==0) {
				products.remove(p);
			}
		}
		order.getProduct(type, num);
		this.position = order.getCoordinates();
	}
	
	public void unload(int type, int num, Warehouse wh) {
		for (Product p:products) {
			p.retrieve(num);
			if (p.getWeight()==0) {
				products.remove(p);
			}
		}
		wh.setProduct(type, num);
		this.position = wh.getCoordinates();
	}
	
	public void waitDrone() {
		
	}
	
	

}
