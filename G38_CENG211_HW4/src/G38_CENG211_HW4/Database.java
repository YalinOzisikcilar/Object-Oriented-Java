package G38_CENG211_HW4;

import java.util.ArrayList;


public class Database {
	private ArrayList<AdminUser> adminsData;
	private ArrayList<RegularUser> usersData;
	private ProductInventory<Product> allInventory;

	
	public Supplier findSupplier(Product product) {
		
		for(RegularUser supplier :usersData) {
			if(supplier instanceof Supplier) {
				if(product.getCategory().equals(((Supplier) supplier).getShop().getShopCategory())) {
					return (Supplier) supplier;
					}
				}
			}
		return null;
		 }
	
	
	public void fillShops() {
		for(RegularUser supplier :usersData) {
			if(supplier instanceof Supplier) {
				((Supplier) supplier).getShop().fillShop(allInventory);
			}
		}
			
	}
	
	
	public Database() {
		adminsData = new ArrayList<AdminUser>();
		usersData = new ArrayList<RegularUser>();
	}

	public Database(ArrayList<AdminUser> adminsData, ArrayList<RegularUser> usersData,ProductInventory<Product> allInventory) {

		this.adminsData = adminsData;
		this.usersData = usersData;
		this.setAllInventory(allInventory);
	}

	public ArrayList<AdminUser> getAdminsData() {
		return adminsData;
	}

	public void setAdminsData(ArrayList<AdminUser> adminsData) {
		this.adminsData = adminsData;
	}

	public ArrayList<RegularUser> getUsersData() {
		return usersData;
	}

	public void setUsersData(ArrayList<RegularUser> usersData) {
		this.usersData = usersData;
	}

	public String toString() {
		String output = "";
		for (int i = 0; i < adminsData.size(); i++) {
			output = output + adminsData.get(i).toString() + "\n";
		}
		for (int i = 0; i < usersData.size(); i++) {
			output = output + usersData.get(i).toString() + "\n";
		}
		return output;
	}

	public String seeShops() {
		String output = "";
		
		for (int i = 0; i < usersData.size(); i++) {
			if(usersData.get(i) instanceof Supplier) {
				output = output + usersData.get(i).toString() + "\n";
			}
		}
		return output;
	}
	public ProductInventory<Product> getAllInventory() {
		return allInventory;
	}

	public void setAllInventory(ProductInventory<Product> allInventory) {
		this.allInventory = allInventory;
	}
}
