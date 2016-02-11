package models;

import java.util.ArrayList;

public class Warehouse {

	private Coordinates coordinates;
	private ArrayList<Product> products;

	public Warehouse(Coordinates coordinates, ArrayList<Product> products) {
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
	
	public void setProduct(int type, int num) {
		boolean end = false;
		for (Product p:products) {
			if (p.getType() == type) {
				p.put(num);
				end = true;
				break;
			}
		}
		
		if (!end) {
			products.add(new Product(type, num));
		}
	}
	
	

}
