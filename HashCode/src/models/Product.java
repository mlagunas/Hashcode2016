package models;

public class Product {

	
	private int weight;
	private int type;
	
	public Product(int weight, int type) {
		super();
		this.weight = weight;
		this.type = type;
	}
	
	public int getType(){
		return type;
	}
	
	public int getWeight(){
		return weight;
	}
	
	public boolean haveEnough(int weight){
		return this.weight <= weight;
	}
	
	public Product retrieve(int weight){
		this.weight = this.weight - weight;
		Product split = new Product(type, weight);

		return split;
	}
	
}
