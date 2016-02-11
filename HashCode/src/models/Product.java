package models;

public class Product {

	
	private int ammount;
	private int type;
	private int weight;
	
	
	public Product(int type, int ammount, int weight) {
		super();
		this.ammount = weight;
		this.type = type;
		this.weight = weight;
	}
	
	
	public int getType(){
		return type;
	}
	
	public int getWeight(){
		return ammount;
	}
	
	public boolean haveEnough(int ammount){
		return this.ammount <= ammount;
	}
	
	public Product retrieve(int ammount){
		this.ammount = this.ammount - ammount;
		Product split = new Product(type, ammount, weight);

		return split;
	}
	
	public void put(int ammount){
		this.ammount+=ammount;
	}
	
}
