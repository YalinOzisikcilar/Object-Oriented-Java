package G38_CENG211_HW4;

public class Product {

	public enum ProductCategories {
		ACCESSORÝES, COSMETÝC, ELECTRONÝC, HOUSEWARE
	}

	private ProductCategories category;
	private String name;
	private double price;
	private double weight;

	
	public boolean isSupplierRegistered(Database database) {
		boolean registered=false;
		Supplier supplier=database.findSupplier(this);
		if(supplier.isRegistered()) {
			registered=true;
		}
		return registered;
	}
	
	public Product(ProductCategories category, String name, double price, double weight) {
		super();
		this.category = category;
		this.name = name;
		this.price = price;
		this.weight = weight;
	}

	public Product() {
		// TODO Auto-generated constructor stub
	}

	public double calculateCargoPrice() {
		return weight * 2;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public ProductCategories getCategory() {
		return category;
	}

	public void setCategory(ProductCategories category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Product [category=" + category + ", name=" + name + ", price=" + price + ", weight=" + weight + "]";
	}
}
