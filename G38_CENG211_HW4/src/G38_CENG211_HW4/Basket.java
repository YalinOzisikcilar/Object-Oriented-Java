package G38_CENG211_HW4;

import java.util.Map.Entry;

public class Basket {

    private ProductInventory<Product> productInventory=new ProductInventory<Product>();

    
    public String toString() {
    	return "Customer's Basket:"+"\n"+productInventory.toString();
    }
    
    
    public Basket() {
		super();
	}

	public ProductInventory<Product> getProductInventory() {
        return productInventory;
    }

    public void setProductInventory(ProductInventory<Product> productInventory) {
        this.productInventory = productInventory;
    }

    public double calculateCost() {
        double total=0;
        for(Entry<Product, Integer> product: productInventory.getInventoryMap().entrySet()) {
            double price =product.getKey().getPrice()*product.getValue();
            total=total+price;
        }
        return total;
    }

    public double calculateCargoCost() {
        double total=0;
        for(Entry<Product, Integer> product: productInventory.getInventoryMap().entrySet()) {
            double cost =product.getKey().calculateCargoPrice()*product.getValue();
            total=total+cost;
        }
        return total;
    }
    public void clear() {
        productInventory.getInventoryMap().clear();
    }
}