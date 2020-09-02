package G38_CENG211_HW4;

import java.util.ArrayList;
import java.util.Scanner;

public class SignInController {
	public SignInController() {
	}
	
	public static User signIn(Database database) {
		boolean validUsername = false;
		boolean validPassword = false;
		
		@SuppressWarnings("resource")
		Scanner scan= new Scanner(System.in);
		while (validUsername==false && validPassword==false) {
			System.out.println("1-Admin sign-in");
			System.out.println("2-User sign-in");
			String userChoice = scan.nextLine();
			
			if(userChoice.equals("1")) {
				System.out.print("Username:");
				String adminUsername = scan.nextLine();
				ArrayList<AdminUser> adminData = database.getAdminsData();
				for(AdminUser admin : adminData) {
					if (adminUsername.equals(admin.getUserName())) {
						System.out.print("Password:");
						String adminPassword = scan.nextLine();
						if(adminPassword.equals(admin.getPassword())) {
							System.out.print("You succesfully logged in "+admin.getUserName());
							validUsername=true;
							validPassword=true;
							
							return admin;
						}
						else {System.out.println("Incorrect password!");}	
					}
					else {System.out.println("Incorrect username!");}
							
				}		
			}

			else if(userChoice.equals("2")) {
				System.out.print("Username:");
				String regularUsername = scan.nextLine();
				ArrayList<RegularUser> usersData = database.getUsersData();
				for(RegularUser regularUser : usersData) {
					if (regularUsername.equals(regularUser.getUserName())) {
						System.out.print("Password:");
						String adminPassword = scan.nextLine();
						if(adminPassword.equals(regularUser.getPassword())) {
							System.out.print("You succesfully logged in "+regularUser.getUserName());
							validUsername=true;
							validPassword=true;
							
							return regularUser;
						}
					}
				}
			}
			else {System.out.println("Invalid input!");
			continue;}

				
		}		
		return null;
	}
}