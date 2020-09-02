package G38_CENG211_HW4;

import java.util.ArrayList;

public class ContactInfo {
	private String phoneNumber;
	private String eMail;
	private ArrayList<Address> addressList= new ArrayList<Address>();

	public ContactInfo(String phoneNumber, String eMail, ArrayList<Address> addressList) {
		super();
		this.phoneNumber = phoneNumber;
		this.eMail = eMail;
		this.addressList = addressList;
	}
	public void addAddress(Address address) {
        addressList.add(address);
    }
	
	public String toString() {
		String adresses = "";
		for (int i = 0; i < addressList.size(); i++) {
			adresses = adresses + addressList.toString();
		}
		return "ContactInfo [phoneNumber=" + phoneNumber + ", eMail=" + eMail + ", addressList=" + adresses + "]";
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String geteMail() {
		return eMail;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

	public ArrayList<Address> getAddressList() {
		return addressList;
	}

	public void setAddressList(ArrayList<Address> addressList) {
		this.addressList = addressList;
	}

	public double calculatePayment(Product product) {
		return 0;
	}

}
