package G38_CENG211_HW4;

@SuppressWarnings("serial")
public class ProductNotFoundException extends Exception{
	public ProductNotFoundException(String message) {
		super(message);
	}
	public ProductNotFoundException() {
		super("Invalid product name");
	}
}
