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
	
	public void getProduct(Product p1) {
		for (Product p:products) {
			if (p.getType() == p1.getType()) {
				p.retrieve(p1.getAmmount());
				if (p.getAmmount()==0) {
					products.remove(p);
				}
				break;
			}
		}
	}
	
}
