package G38_CENG211_HW4;
//import Product.ProductCategories;

import java.util.Map.Entry;

public class Shop {

	private Product.ProductCategories shopCategory;
	private String shopTitle;
	private String taxNumber;
	private ProductInventory<Product> productInventory;
	
	
	public void fillShop(ProductInventory<Product> allInventory) {
		for(Entry<Product, Integer> product: allInventory.getInventoryMap().entrySet()) {
			if(product.getKey().getCategory().equals(shopCategory)) {
				productInventory.addElementToInventory( product.getKey(), product.getValue());
			}
		}
	}
	public Shop(Product.ProductCategories shopCategory, String shopTitle, String taxNumber) {
		super();
		this.shopCategory = shopCategory;
		this.shopTitle = shopTitle;
		this.taxNumber = taxNumber;
		setProductInventory(new ProductInventory<Product>());

	}

	public String getShopTitle() {
		return shopTitle;
	}

	public void setShopTitle(String shopTitle) {
		this.shopTitle = shopTitle;
	}

	public String getTaxNumber() {
		return taxNumber;
	}

	public void setTaxNumber(String taxNumber) {
		this.taxNumber = taxNumber;
	}

	public Product.ProductCategories getShopCategory() {
		return shopCategory;
	}

	public void setShopCategory(Product.ProductCategories shopCategory) {
		this.shopCategory = shopCategory;
	}

	@Override
	public String toString() {
		
		return "Shop [shopCategory=" + shopCategory + ", shopTitle=" + shopTitle + ", taxNumber=" + taxNumber + "]"+"\n"+
					productInventory.toString();
	}

	public ProductInventory<Product> getProductInventory() {
		return productInventory;
	}

	public void setProductInventory(ProductInventory<Product> productInventory) {
		this.productInventory = productInventory;
	}
}
