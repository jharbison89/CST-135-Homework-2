
public class Gum extends Snack{
	
	/*
	 * Created by James Harbison and Chase Hausman
	 * This class extends the Snack class with items unique to Gum in a vending machine
	 */
	
	private int pieces;		// indicates number of  pieces in a pack
	private boolean minty;	// true is a mint flavored gum, false is not mint flavored
	
	// no arg constructor
	public Gum() {
		pieces = 5;
		minty = false;
	}
	
	// overloaded constructor
	public Gum(String name, double price, int maxQuantity, int currentQuantity, String flavor, int pieces, boolean minty) {
		setName(name);
		setPrice(price);
		setMaxQuantity(maxQuantity);
		setCurrentQuantity(currentQuantity);
		setFlavor(flavor);
		this.pieces = pieces;
		this.minty = minty;
	}
	
	// constructor that copies an existing Gum
	public Gum(Gum gum) {
		setName(gum.getName());
		setPrice(gum.getPrice());
		setMaxQuantity(gum.getMaxQuantity());
		setCurrentQuantity(gum.getCurrentQuantity());
		setFlavor(gum.getFlavor());
		pieces = gum.pieces;
		minty = gum.minty;
	}
	
	public void setPieces(int pieces) {
		this.pieces = pieces;
	}
	
	public int getPieces() {
		return pieces;
	}
	
	public void setMinty(boolean minty) {
		this.minty = minty;
	}
	
	public boolean isMinty() {
		return minty;
	}
	
	@Override
	public String toString() {
		return "Product Name\t\t" + getName() + "\nPrice\t\t\t" + getPrice() + "\nMax Quantity\t\t" + getMaxQuantity() + 
				"\nCurrent Quantity\t" + getCurrentQuantity() + "\nFlavor\t\t\t" + getFlavor() + "\nPieces\t\t\t" + pieces;
	}
}
