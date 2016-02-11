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
	
	public Product getProduct(int type, int num) {
		Product p1 = null;
		for (Product p:products) {
			if (p.getType() == type) {
				p1 = p.retrieve(num);
				if (p.getWeight()== 0) {
					products.remove(p);
				}
				break;
			}
		}
		return p1;
	}
	
	public void setProduct(Product product) {
		boolean end = false;
		for (Product p:products) {
			if (p.getType() == product.getType()) {
				p.put(product.getAmmount());
				end = true;
				break;
			}
		}
		
		if (!end) {
			products.add(product);
		}
	}
	
	

}
