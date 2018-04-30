
public class Main {
	/* 
	 * Created by James Harbison and Chase Hausman
	 * This class tests the dispenser class in a way to ensure that the Product class and its subclasses are working as designed
	 */
	public static void main(String[] args) {
		
		// tests the default values for a Dispenser with default values
		Dispenser dispenser1 = new Dispenser();
		dispenser1.displayProducts();
		
		// tests the specified size constructor with "random" assigned values
		Dispenser dispenser2 = new Dispenser(12);
		dispenser2.displayProducts();
	}

}
