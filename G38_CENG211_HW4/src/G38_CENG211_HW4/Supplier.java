package G38_CENG211_HW4;

import java.util.ArrayList;
import java.util.Map.Entry;

public class Supplier extends RegularUser{
	
	private ProductInventory<Product> returnProductInventory=new ProductInventory<Product>();
	private ProductInventory<Product> soldProductInventory=new ProductInventory<Product>();
    private Shop shop;
    private boolean isRegistered;
    
    public double acceptReturn(String str) {
    	if(returnProductInventory.getInventoryMap().isEmpty()) {
    		System.out.println("You do no have any return request");
    		return 0;
    	}
    	Product returningProduct= returnProductInventory.findProduct(str);
    	int quantity=0;
    	for (Entry<Product, Integer> product: returnProductInventory.getInventoryMap().entrySet()) {
            if (returningProduct.getName().equals(product.getKey().getName())) {
                quantity=product.getValue();
            }
        }
    	soldProductInventory.removeElementFromInventory(returningProduct, quantity);
    	shop.getProductInventory().addElementToInventory(returningProduct, quantity);
    	return paybackReturnProduct(returningProduct,quantity);
    }
    private double paybackReturnProduct(Product returningProduct, int quantity) {
		double returnMoney=0;
		returnMoney=(returningProduct.getPrice()*quantity*98)/100;
		super.setActiveBalance(getActiveBalance()-returnMoney);
		return returnMoney;
		
	}
	public String toString() {
    	return "Supplier "+ super.toString()+"\n"+"Shop exposition:"+"\n"+shop.toString();
    }
    public Supplier(String userName, String password, double activeBalance, Shop shop, ContactInfo contactInfo) {
    	super(userName, password, activeBalance, contactInfo);
    	this.shop = shop;
    	isRegistered = false;
    }

    public double calculateEndorsement() {
        double endorsment=0;
        for(Entry<Product, Integer> product: soldProductInventory.getInventoryMap().entrySet()) {
        	endorsment=endorsment+(product.getKey().getPrice()*product.getValue());
        }
        endorsment=endorsment*98/100;
    	return endorsment;
    }

    public void registerShop(AdminUser admin) {
        if(isRegistered==false) {
            admin.getShopQueue().add(this);
        }
        else {
            System.out.println("This shop is already registered.");
        }
    }

    public ProductInventory<Product> getSoldProductInventory() {
        return soldProductInventory;
    }

    public void setSoldProductInventory(ProductInventory<Product> soldProductInventory) {
        this.soldProductInventory = soldProductInventory;
    }

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }

    public boolean isRegistered() {
        return isRegistered;
    }

    public void setRegistered(boolean isRegistered) {
        this.isRegistered = isRegistered;
    }
	
	public void addSale(Entry<Product, Integer> product, double payment,ArrayList<AdminUser>admins) {
		double total=0;
		if(payment>2000) {
			total=product.getKey().getPrice()*product.getValue();
		}
		else {
			total=(product.getKey().getPrice()*product.getValue())+product.getKey().calculateCargoPrice();
		}
		double yourMoney=admins.get(0).getRich(total);
		super.setActiveBalance(getActiveBalance()+yourMoney);
		soldProductInventory.addElementToInventory(product.getKey(), product.getValue());
	}
	public ProductInventory<Product> getReturnProductInventory() {
		return returnProductInventory;
	}
	public void setReturnProductInventory(ProductInventory<Product> returnProductInventory) {
		this.returnProductInventory = returnProductInventory;
	}
	
}

