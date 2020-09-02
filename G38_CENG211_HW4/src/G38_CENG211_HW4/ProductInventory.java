
	package G38_CENG211_HW4;

	import java.util.Map.Entry;

	public class ProductInventory<T extends Product> extends Inventory<T> {

		public ProductInventory() {
			super();

		}

		public Product findProduct(String str) {
			Product returnProduct= new Product();
			try {
				
				for(Entry<T, Integer> product: super.getInventoryMap().entrySet()) {
					if(product.getKey().getName().equalsIgnoreCase(str)) {
						returnProduct=(Product) product.getKey();
						return returnProduct;
					}
					if(returnProduct==null) {
						throw new ProductNotFoundException();
					}
				}
			} catch (ProductNotFoundException e) {
				// TODO Auto-generated catch block
				System.out.println("Invalid product name.");
			}
			
			
			return returnProduct;

		}

		@Override
		public String toString() {
			String output = "";

			for (Entry<T, Integer> product : super.getInventoryMap().entrySet()) {
				output = output + (product.getKey() + ":" + product.getValue().toString()) + "\n";
			}
			return output;
		}

	}


