
public class Gum extends Snack{
	
	private int pieces;
	private boolean minty;
	
	public Gum() {
		pieces = 5;
		minty = false;
	}
	
	public Gum(String name, double price, int maxQuantity, int currentQuantity, String flavor, int pieces, boolean minty) {
		setName(name);
		setPrice(price);
		setMaxQuantity(maxQuantity);
		setCurrentQuantity(currentQuantity);
		setFlavor(flavor);
		this.pieces = pieces;
		this.minty = minty;
	}
	
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
		return "Product Name\t" + getName() + "\nPrice\t\t" + getPrice() + "\nMax Quantity\t" + getMaxQuantity() + 
				"\nCurrent Quantity\t" + getCurrentQuantity() + "\nFlavor\t\t" + getFlavor() + "\nPieces\t\t" + pieces;
	}
}
