
public abstract class Product {

	private String name;
	private double price;
	private int maxQuantity;
	private int currentQuantity;
	
	protected Product() {
		name = "";
		price = 0;
		maxQuantity = 0;
		currentQuantity = 0;
	}
	
	protected Product(String name, double price, int maxQuantity, int currentQuantity) {
		this.name = name;
		this.price = price;
		this.maxQuantity = maxQuantity;
		this.currentQuantity = currentQuantity;
	}
	
	protected Product(Product input) {
		name = input.name;
		price = input.price;
		maxQuantity = input.maxQuantity;
		currentQuantity = input.currentQuantity;
	}
	
	public void setName(String name){
		
	}
	
	public String getName() {
		return name;
	}
	
	public void setPrice(double price) {
		
	}
	
	public double getPrice() {
		return price;
	}
	
	public void setCurrentQuantity(int currentQuantity) {
		
	}
	
	public int getCurrentQuantity() {
		return currentQuantity;
	}
	
	public void setMaxQuantity(int maxQuantity) {
		
	}
	
	public int getMaxQuantity() {
		return maxQuantity;
	}
}
