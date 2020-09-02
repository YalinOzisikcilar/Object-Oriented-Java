package G38_CENG211_HW4;

import java.util.Map.Entry;

public class SellManager {
    public void manageSell(Customer customer,Database database) {
        double payment= customer.buyBasket();
	    if(payment>0)	{
        	for(Entry<Product, Integer> product: customer.getBasket().getProductInventory().getInventoryMap().entrySet()) {
	    		Supplier seller=database.findSupplier(product.getKey());
	    		seller.addSale(product,payment,database.getAdminsData());
	    		seller.getShop().getProductInventory().removeElementFromInventory(product.getKey(), product.getValue());
	        }
        	customer.getBasket().clear();
	    }
    }
}