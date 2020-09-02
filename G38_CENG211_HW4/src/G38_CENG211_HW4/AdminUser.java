package G38_CENG211_HW4;

import java.util.LinkedList;
import java.util.Queue;

public class AdminUser extends User {
	private String userName;
	private String password;
	private double activeBalance;
	private Queue<Supplier> shopQueue=new LinkedList<>();

	public void acceptRegister() {
		Supplier registeredSupplier = shopQueue.remove();
		registeredSupplier.setRegistered(true);
	}

	public AdminUser(String userName, String password, double activeBalance) {
		super();
		this.userName = userName;
		this.password = password;
		this.activeBalance = activeBalance;
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

	public Queue<Supplier> getShopQueue() {
		return shopQueue;
	}

	public void setShopQueue(Queue<Supplier> shopQueue) {
		this.shopQueue = shopQueue;
	}

	@Override
	public String toString() {
		String shops="";
		for(Supplier supplier:shopQueue) {
			shops=shops+", "+supplier.getShop().getShopTitle();
		}
		return "AdminUser [userName=" + userName + ", password=" + password + ", activeBalance=" + activeBalance
				+ ", shopQueue=" + shops + "]";
	}

	public double getRich(double total) {
		double income=(total*2)/100;
		activeBalance=activeBalance+income;
		total=total-income;
		return total;
	}

}