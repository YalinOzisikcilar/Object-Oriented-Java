package G38_CENG211_HW4;

import java.util.Map.Entry;

public class Customer extends RegularUser {
    private Basket basket=new Basket();
    private ProductInventory<Product> boughtProducts=new ProductInventory<Product>();

    public void sendReturnRequest(String product,Database database,int quantity) {
    	Product returningProduct=boughtProducts.findProduct(product);
    	if(returningProduct==null) {
    		System.out.println("You haven't buy this item.");
    	}
    	
    	else {
    		Supplier supplier=database.findSupplier(returningProduct);
    		supplier.getReturnProductInventory().addElementToInventory(returningProduct, quantity);
    		boughtProducts.removeElementFromInventory(returningProduct, quantity);
    		double payback=returningProduct.getPrice()*quantity*98/100;
    		super.setActiveBalance(getActiveBalance()+payback);
    	}
    }
    
    
    public Customer(String userName, String password, double activeBalance, ContactInfo contactInfo) {
    	super(userName, password, activeBalance, contactInfo);
    }
    
    public void addToBasket(Product product,int quantity) {
    	basket.getProductInventory().addElementToInventory(product, quantity);
    }
    public double buyBasket() {
        double payment=basket.calculateCost();
        if(payment<2000) {
        	payment=payment+basket.calculateCargoCost();
        }
        if(makePayment(payment)) {
            for(Entry<Product, Integer> product: basket.getProductInventory().getInventoryMap().entrySet()) {
                boughtProducts.addElementToInventory(product.getKey(), product.getValue());        
            }
            return payment;
        }
        else {
        	return 0;
        }
    }
    public boolean makePayment(double payment) {
        if (super.getActiveBalance()>payment) {
            super.setActiveBalance(getActiveBalance()-payment);
            return true;
        }
        else {
            System.out.println("Customer do not have enough money.");
            return false;
        }


    }
    public Basket getBasket() {
        return basket;
    }
    public ProductInventory<Product> getBoughtProducts() {
        return boughtProducts;
    }
    public void setBoughtProducts(ProductInventory<Product> boughtProducts) {
        this.boughtProducts = boughtProducts;
    }
    public String toString() {
        return "Customer [userName=" + super.getUserName() + ", password=" + super.getPassword() + ", activeBalance=" + super.getActiveBalance()
                + ", contactInfo=" + super.getContactInfo() + "]";
    }
}
