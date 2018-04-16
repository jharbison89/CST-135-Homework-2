
public abstract class Snack extends Product {

	/* 
	 * Created by James Harbison and Chase Hausman
	 * This class extends the product class with items unique to snacks in a vending machine
	 */
	
	// initialize variables
	private String flavor;
	
	// no arg constructor
	protected Snack(){
		flavor = "Regular";
	}
	
	// overloaded constructor
	protected Snack(String name, double price, int maxQuantity, int currentQuantity, String flavor) {
		setName(name);
		setPrice(price);
		setMaxQuantity(maxQuantity);
		setCurrentQuantity(currentQuantity);
		this.flavor = flavor;
	}
	
	// constructor that copies an existing snack
	protected Snack(Snack snack) {
		setName(snack.getName());
		setPrice(snack.getPrice());
		setMaxQuantity(snack.getMaxQuantity());
		setCurrentQuantity(snack.getCurrentQuantity());
		flavor = snack.flavor;
	}
	
	public void setFlavor(String flavor) {
		this.flavor = flavor;
	}
	
	public String getFlavor() {
		return flavor;
	}
	
	public String toString() {
		return "Product Name\t" + getName() + "\nPrice\t\t" + getPrice() + "\nMax Quantity\t" + getMaxQuantity() + 
				"\nCurrent Quantity\t" + getCurrentQuantity() + "\nFlavor\t\t" + flavor;
	}
	
}
