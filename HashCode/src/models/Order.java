package models;

import java.util.ArrayList;

public class Order {

	private Coordinates coordinates;
	private ArrayList<Product> products;

	public Order(Coordinates coordinates, ArrayList<Product> products) {
		this.coordinates = coordinates;
		this.products = products;
	}

	public Coordinates getCoordinates() {
		return coordinates;
	}

	public void setCoordinates(Coordinates coordinates) {
		this.coordinates = coordinates;
	}

	public ArrayList<Product> getProducts() {
		return products;
	}

	public void setProducts(ArrayList<Product> products) {
		this.products = products;
	}
	
	public void getProduct(int type, int num) {
		for (Product p:products) {
			if (p.getType() == type) {
				Product p1 = p.retrieve(num);
				if (p.getWeight()==0) {
					products.remove(p);
				}
				break;
			}
		}
	}
	
}
