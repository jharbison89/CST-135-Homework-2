
public class Dispenser {
	
	/* 
	 * Created by James Harbison and Chase Hausman
	 * This class manages the products in a vending machine and is used to test the product class and its subclasses
	 */
	
	private Product[] products;
	private boolean boss;		// indicates if a boss user is logged in
	private final String CODE = "PASSWORD";	// the password needed to log a boss user in
	
	
	// creates a default dispenser of size 8
	public Dispenser(){
		products = new Product[8];
		boss = false;
		createProducts();
	}
	
	// creates a dispenser of specified size
	public Dispenser(int size) {
		products = new Product[size];
		boss = false;
		createRandomProducts();
	}
	
	// creates default products evenly dispersed between Drinks, Gum, Candy, and Chips for a dispenser
	void createProducts() {
		for(int i = 0; i < products.length; i ++) {
			if(i % 4 == 0) {
				products[i] = new Drink(); 
			}
			else if(i % 4 == 1) {
				products[i] = new Chips();
			}
			else if(i % 4 == 2) {
				products[i] = new Gum();
			}
			else {
				products[i] = new Candy();
			}
		}
	}
	
	// creates products with "random" filled properties using each class's overloaded constructor
	void createRandomProducts() {
		for(int i = 0; i < products.length; i ++) {
			if(i % 4 == 0) {
				products[i] = new Drink((int)(Math.random() * 32)); 
			}
			else if(i % 4 == 1) {
				products[i] = new Chips("Chips", Math.random() * 20, (int)(Math.random() * 10), (int)(Math.random() * 10), "Regular", "Kettle", Math.random() * 12);
			}
			else if(i % 4 == 2) {
				products[i] = new Gum("Gum", Math.random() * 20, (int)(Math.random() * 10), (int)(Math.random() * 10), "Regular", (int)(Math.random() * 25), true);
			}
			else {
				products[i] = new Candy("Candy", Math.random() * 20, (int)(Math.random() * 10), (int)(Math.random() * 10), "Regular", true, false, true, false, true);
			}
		}
	}
	
	// logs a boss user in
	public void bossLogin(String attempt) {
		if(attempt.equals(CODE)) {
			boss = true;
		}
	}
	
	public void bossLogout() {
		boss = false;
	}
	
	// displays a list of each product using each classes toString method
	public void displayProducts() {
		
		for(int i = 0; i < products.length; i ++) {
			System.out.println("Product " + i + "\n" + products[i] + "\n");
		}
		
	}
	
	// returns a list of each product using each classes toString method
	public String toString() {
		String string = "";
		
		for(int i = 0; i < products.length; i ++) {
			string = string + "Product " + i + "\n" + products[i] + "\n\n";
		}
		
		return string;
	}
	

}
