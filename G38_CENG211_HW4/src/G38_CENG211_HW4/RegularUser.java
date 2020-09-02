package G38_CENG211_HW4;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public abstract class RegularUser extends User {

	private String userName;
	private String password;
	private double activeBalance;
	private ContactInfo contactInfo;

	@Override
	public String toString() {
		return "[userName=" + userName + ", password=" + password + ", activeBalance=" + activeBalance
				+ ", contactInfo=" + contactInfo + "]";
	}
	
	public void addAddress(Address address) throws IOException {
        contactInfo.addAddress(address);
        ArrayList<String> lineArray = new ArrayList<String>();
		try {
			BufferedReader csvReader = new BufferedReader(new FileReader("products.csv"));

			String line;
			while ((line = csvReader.readLine()) != null) {
				lineArray.add(line);
			}
			csvReader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		 for(int i =1;i<lineArray.size();i++) {
			 String[] data= lineArray.get(i).split(",");
			 if(this.userName.equals(data[1])) {
				 
			 }
		 }
    }
	public RegularUser(String userName, String password, double activeBalance, ContactInfo contactInfo) {
		this.userName = userName;
		this.password = password;
		this.activeBalance = activeBalance;
		this.contactInfo = contactInfo;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public double getActiveBalance() {
		return activeBalance;
	}

	public void setActiveBalance(double activeBalance) {
		this.activeBalance = activeBalance;
	}

	public ContactInfo getContactInfo() {
		return contactInfo;
	}

	public void setContactInfo(ContactInfo contactInfo) {
		this.contactInfo = contactInfo;
	}

}
