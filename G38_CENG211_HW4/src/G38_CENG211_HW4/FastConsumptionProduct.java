package G38_CENG211_HW4;

public class FastConsumptionProduct extends Product {

	public FastConsumptionProduct(ProductCategories category, String name, double price, double weight) {
		super(category, name, price, weight);
		// TODO Auto-generated constructor stub
	}

	public double calculateCargoPrice() {
		return super.calculateCargoPrice() * 3.5;
	}

	@Override
	public String toString() {
		return "FastConsumption" + super.toString();
	}
}
