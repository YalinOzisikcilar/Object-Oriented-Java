package G38_CENG211_HW4;

public class FragileProduct extends Product {
	public FragileProduct(ProductCategories category, String name, double price, double weight) {
		super(category, name, price, weight);
		// TODO Auto-generated constructor stub
	}

	public double calculateCargoPrice() {
		return super.calculateCargoPrice() * 3.5;
	}

	public String toString() {
		return "Fragile" + super.toString();
	}
}
