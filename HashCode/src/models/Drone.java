package models;

import java.lang.Character.Subset;
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

	
	public boolean load(int type, int num, Warehouse wh) {
		Product p1 = wh.getProduct(type, num);

		if (p1 != null) {
			boolean end = false;
			for (Product p:products) {
				if (p.getType() == type) {
					p.put(p1.getAmmount());
					addWieght(p1.getWeight());
					break;
				}
			}
			
			if (!end) {
				products.add(p1);
				addWieght(p1.getWeight());
			}
			
//			this.position = wh.getCoordinates();
			return true;
		}
		else {
			return false;
		}
	}
	
	public void deliver(Product p1, Order order) {
		for (Product p:products) {
			p.retrieve(p1.getAmmount());
			if (p.getAmmount()==0) {
				products.remove(p);
			}
			subWeight(p1.getAmmount()*p1.getWeight());
		}
		order.getProduct(p1);
//		this.position = order.getCoordinates();
	}
	
	public void unload(int type, int num, Warehouse wh) {
		Product p1 = null;
		for (Product p:products) {
			p1 = p.retrieve(num);
			if (p.getAmmount()==0) {
				products.remove(p);
			}
			subWeight(num*p.getWeight());
		}
		
		if (p1 != null){
			wh.setProduct(p1);
		}
		
//		this.position = wh.getCoordinates();
	}
	
	
	private void addWieght(int weight) {
		this.acumulatedWeight += weight;
	}
	
	private void subWeight(int weight) {
		this.acumulatedWeight -= weight;
		if (acumulatedWeight < 0) { acumulatedWeight = 0; }
	}
	
	

}
