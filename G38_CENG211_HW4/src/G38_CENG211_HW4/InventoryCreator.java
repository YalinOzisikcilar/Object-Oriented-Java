package G38_CENG211_HW4;

import java.util.ArrayList;

public class InventoryCreator<T extends Product> {

	@SuppressWarnings("unchecked")
	public ProductInventory<T> createProductInventory(ArrayList<String> inventoryList) {
		ProductInventory<T> newInventory = new ProductInventory<T>();
		for (int i = 1; i < inventoryList.size(); i++) {
			String line = inventoryList.get(i);
			String[] dataArray = line.split(",");

			if (dataArray[0].equalsIgnoreCase("accessories")) {
				FragileProduct newFragile = new FragileProduct(Product.ProductCategories.ACCESSORÝES, dataArray[1],
						Double.parseDouble(dataArray[2]), Double.parseDouble(dataArray[3]));
				newInventory.addElementToInventory((T) newFragile, Integer.parseInt(dataArray[4]));
			} else if (dataArray[0].equalsIgnoreCase("cosmetic")) {
				FastConsumptionProduct newProduct = new FastConsumptionProduct(Product.ProductCategories.COSMETÝC,
						dataArray[1], Double.parseDouble(dataArray[2]), Double.parseDouble(dataArray[3]));
				newInventory.addElementToInventory((T) newProduct, Integer.parseInt(dataArray[4]));
			} else {
				if (dataArray[0].equalsIgnoreCase("electronic")) {
					Product newProduct = new Product(Product.ProductCategories.ELECTRONÝC, dataArray[1],
							Double.parseDouble(dataArray[2]), Double.parseDouble(dataArray[3]));
					newInventory.addElementToInventory((T) newProduct, Integer.parseInt(dataArray[4]));
				} else if (dataArray[0].equalsIgnoreCase("houseware")) {
					Product newProduct = new Product(Product.ProductCategories.HOUSEWARE, dataArray[1],
							Double.parseDouble(dataArray[2]), Double.parseDouble(dataArray[3]));
					newInventory.addElementToInventory((T) newProduct, Integer.parseInt(dataArray[4]));
				} else {
					System.out.println("invalid category");
				}
			}
		}
		return newInventory;
	}
}
