package G38_CENG211_HW4;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class OnlineMarketingApplicationMenu {
	public OnlineMarketingApplicationMenu() {	
	}

	public void menu() throws IOException {
		CSVReader csvReader = new CSVReader();
        DatabaseCreator databaseCreator = new DatabaseCreator();
        Database database = databaseCreator.createDatabase(csvReader.usersReader());
        AdminUser admin = database.getAdminsData().get(0);
        SellManager sellManager = new SellManager();
		System.out.println("Welcome to online marketing");
		Scanner scan= new Scanner(System.in);
		String input = "1";
		while(!(input.equals("0"))) {
			System.out.println("Which operation do you want to perform? ");
			System.out.println("1- SIGN IN");
			System.out.println("0- EXIT");
			
			input = scan.nextLine();
			if(input.equals("1")) {
				User user = SignInController.signIn(database);
				System.out.println(user.toString());
				if(user instanceof AdminUser) {
					user = (AdminUser) user;
					
					while(true) {
						System.out.println("Which operation to perform? ");
						System.out.println("1-Check your active balance");
						System.out.println("2-Check shop register queue");
						System.out.println("3-Register supplier");
						System.out.println("4-Logout");

						String input2_1 = scan.nextLine();
						if (input2_1.equals("1")) {
							System.out.println(((AdminUser) user).getActiveBalance() + " TL.");
						}
						else if (input2_1.equals("2")) {
							System.out.println(user.toString());
						}
						else if (input2_1.equals("3")) {
							((AdminUser) user).acceptRegister();
						}
						else if(input2_1.equals("4")) {
							break;
						}

						else {System.out.println("Invalid input!");}
					}
				}
				else if(user instanceof Supplier) {
					user = (Supplier) user;
					
					while(true) {
						System.out.println("Which operation to perform? ");
						System.out.println("1-Check your active balance");
						System.out.println("2-Check your income");
						System.out.println("3-Send registration request");
						System.out.println("4-Accept returning products");//csv update(supplier-customer)
						System.out.println("5-See your shop");
						System.out.println("6-Check sold products");
						System.out.println("7-Deposit money");//csv update
						System.out.println("8-Add address");
						System.out.println("0-Logout");
	
						String input2_2 = scan.nextLine();
						if (input2_2.equals("1")) {
							System.out.println(((Supplier) user).getActiveBalance()+" TL");
						}
						else if (input2_2.equals("2")) {
							System.out.println(((Supplier) user).calculateEndorsement() +" TL");
						}
						else if (input2_2.equals("3")) {
							((Supplier) user).registerShop(admin);
						}
						else if (input2_2.equals("4")) {
							System.out.println("Select which product to return:");
							System.out.println(((Supplier) user).getReturnProductInventory().toString());
							String input2_2_1=scan.nextLine();
							((Supplier) user).acceptReturn(input2_2_1);
							System.out.println(((Supplier) user).getReturnProductInventory().toString());
						}
						else if (input2_2.equals("5")) {
							System.out.println(((Supplier) user).getShop().toString());
						}
						else if (input2_2.equals("6")) {
							System.out.println(((Supplier) user).getSoldProductInventory().toString());
						}
						else if (input2_2.equals("7")){
							System.out.println("How much money would you like to deposit?:");
							int input2_2_1=scan.nextInt();
							((Supplier) user).setActiveBalance(((Supplier) user).getActiveBalance()+input2_2_1);
						}
						else if(input2_2.equals("8")){
							System.out.println("Type the new adrress informations.");
							System.out.print("Address Title:");
							String inputAddressTitle =  scan.nextLine();
							System.out.print("\nCountry:");
							String inputCountry = scan.nextLine();
							System.out.print("\nCity:");
							String inputCity = scan.nextLine();
							System.out.print("\nDistrict:");
							String inputDistrict = scan.nextLine();
							System.out.print("\nStreet:");
							String inputStreet = scan.nextLine();
							System.out.print("\nDoor Number:");
							String inputDoorNumber = scan.nextLine();
							Address newAdress = new Address(inputAddressTitle, inputCountry, 
									inputCity, inputDistrict, inputStreet, inputDoorNumber);
							((Supplier) user).addAddress(newAdress);
						}
						else if (input2_2.equals("0")) {
							break;
						}
						else {System.out.println("Invalid input!");}
					}
				}
				else if(user instanceof Customer) {
					user = (Customer) user;
					
					while(true) {
						System.out.println("Which operation to perform? ");
						System.out.println("1-Check your active balance");
						System.out.println("2-Check your basket");
						System.out.println("3-Check purchased history");
						System.out.println("4-Add products to your basket");
						System.out.println("5-Buy the products in the basket");//csv update
						System.out.println("6-Request to return the products");
						System.out.println("7-Add an address");//csv update
						System.out.println("8-See shops");
						System.out.println("9-Deposit money");//csv update
						System.out.println("0-Logout");
						String input2_3 = scan.nextLine();
							if (input2_3.equals("1")) {
								System.out.println(((Customer) user).getActiveBalance()+" TL");
							}
							else if (input2_3.equals("2")) {
								System.out.println(((Customer) user).getBasket().toString());
							}
							else if (input2_3.equals("3")) {
								System.out.println(((Customer) user).getBoughtProducts());
							}
							else if (input2_3.equals("4")) {
								System.out.print("What do you want to buy?:");
								String input2_3_1 = scan.nextLine();
								Product product = database.getAllInventory().findProduct(input2_3_1);
								
								System.out.println("How many "+ product.getName()+"s you want to buy?:");
			
								int input2_3_2 = scan.nextInt();
								//System.out.println("Invalid input!");
								
								if(product.isSupplierRegistered(database)) {
									((Customer) user).addToBasket(product, input2_3_2);
								}
								else {System.out.println("Product supplier is not registered.");}
								
				
							}
							else if (input2_3.equals("5")) {
								sellManager.manageSell((Customer)user, database);
							}
							else if (input2_3.equals("6")) {
								System.out.println("What do you want to return-back:");
								System.out.println(((Customer) user).getBoughtProducts().toString());
								String input2_3_1 = scan.nextLine();
								System.out.println("How many of "+ input2_3_1+" you want to return-back?:");
								int input2_3_2 = scan.nextInt();
								((Customer) user).sendReturnRequest(input2_3_1, database, input2_3_2);
							}
							else if (input2_3.equals("7")) {
								System.out.println("Type the new adrress informations.");
										
								System.out.print("Address Title:");
								String inputAddressTitle =  scan.nextLine();
								System.out.print("\nCountry:");
								String inputCountry = scan.nextLine();
								System.out.print("\nCity:");
								String inputCity = scan.nextLine();
								System.out.print("\nDistrict:");
								String inputDistrict = scan.nextLine();
								System.out.print("\nStreet:");
								String inputStreet = scan.nextLine();
								System.out.print("\nDoor Number:");
								String inputDoorNumber = scan.nextLine();
								Address newAdress = new Address(inputAddressTitle, inputCountry, 
										inputCity, inputDistrict, inputStreet, inputDoorNumber);
								((Customer) user).addAddress(newAdress);
								
							}
							else if (input2_3.equals("8")) {
								System.out.println(database.seeShops());
							}
							else if (input2_3.equals("9")) {
								//deposit money
								try {
									System.out.println("How much money would you like to deposit?:");
									int input2_3_1=scan.nextInt();
									((Customer) user).setActiveBalance(((Customer) user).getActiveBalance()+input2_3_1);
								} 
								catch (InputMismatchException e) {
									System.out.println("Invalid input!");
								}
							}
							else if (input2_3.equals("0")) {
								break;
							}
							
							else {System.out.println("Invalid input!");}
						}
				}
			}
			else if(input.equals("0")) {
				
			}
			else {System.out.println("Wrong input!");}
		}
		scan.close();
	}
}
