

public abstract class Product {

	/*
	 * Created by James Harbison and Chase Hausman
	 * This class holds information for products in a vending machine
	 */
	
	private String name;
	private double price;
	private int maxQuantity;
	private int currentQuantity;

	// No-argument constructor, with default values
	protected Product() {
		name = "A New Product";
		price = 0;
		maxQuantity = 0;
		currentQuantity = 0;
	}

	// Constructor with setting new values
	protected Product(String name, double price, int maxQuantity, int currentQuantity) {
		this.name = name;
		this.price = price;
		this.maxQuantity = maxQuantity;
		this.currentQuantity = currentQuantity;
	}

	// Constructor that copies fields (if available) from a similar product
	protected Product(Product input) {
		name = input.name;
		price = input.price;
		maxQuantity = input.maxQuantity;
		currentQuantity = input.currentQuantity;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	public double getPrice() {
		return price;
	}
	
	public void setCurrentQuantity(int currentQuantity) {
		this.currentQuantity = currentQuantity;
	}
	
	public int getCurrentQuantity() {
		return currentQuantity;
	}
	
	public void setMaxQuantity(int maxQuantity) {
		this.maxQuantity = maxQuantity;
	}
	
	public int getMaxQuantity() {
		return maxQuantity;
	}

	// returns a string of all variables in tabular format
	public String toString() {
		return "Product Name\t\t" + getName() + "\nPrice\t\t\t" + getPrice() + "\nMax Quantity\t\t" + getMaxQuantity() +
				"\nCurrent Quantity\t" + getCurrentQuantity();
	}
}