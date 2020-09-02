package G38_CENG211_HW4;

import java.util.ArrayList;

public class DatabaseCreator {
	public DatabaseCreator() {
		
	}
	public Database createDatabase(ArrayList<String> usersList) {
		Database database = new Database();
		for (int i = 1; i < usersList.size(); i++) {
			String line = usersList.get(i);
			String[] dataArray = line.split(",");
			if (dataArray[0].equals("1")) {
				AdminUser newUser = new AdminUser(dataArray[1], dataArray[2], Double.parseDouble(dataArray[3]));
				database.getAdminsData().add(newUser);
			} else if (dataArray[0].equals("2")) {
				int arrayController = 9;
				ArrayList<Address> addressList = new ArrayList<Address>();

				while (dataArray.length > arrayController && dataArray[arrayController] != null) {
					Address newAddress = new Address(dataArray[arrayController], dataArray[arrayController + 1],
							dataArray[arrayController + 2], dataArray[arrayController + 3],
							dataArray[arrayController + 4], dataArray[arrayController + 5]);
					addressList.add(newAddress);
					arrayController = arrayController + 6;
				}

				ContactInfo contactInfo = new ContactInfo(dataArray[4], dataArray[5], addressList);
				Customer newCustomer = new Customer(dataArray[1], dataArray[2], Double.parseDouble(dataArray[3]),
						contactInfo);
				database.getUsersData().add(newCustomer);
			} else if (dataArray[0].equals("3")) {
				int arrayController = 9;
				Shop newShop = new Shop(Product.ProductCategories.valueOf(dataArray[6].toUpperCase()), dataArray[7],
					dataArray[8]);
				ArrayList<Address> addressList = new ArrayList<Address>();
				while (dataArray.length > arrayController && dataArray[arrayController] != null) {
					Address newAddress = new Address(dataArray[arrayController], dataArray[arrayController+1], dataArray[arrayController+2], dataArray[arrayController+3],
							dataArray[arrayController+4], dataArray[arrayController+5]);
					addressList.add(newAddress);
					arrayController=arrayController+6;
				}
			
				ContactInfo contactInfo = new ContactInfo(dataArray[4], dataArray[5], addressList);
				Supplier newSupplier = new Supplier(dataArray[1], dataArray[2], Double.parseDouble(dataArray[3]),
					newShop, contactInfo);
				database.getUsersData().add(newSupplier);
			}

		}
		return database;

	}
}
