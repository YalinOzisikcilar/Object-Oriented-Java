package G38_CENG211_HW4;

import java.util.HashMap;

public abstract class Inventory<T> implements IInventory<T> {
	private HashMap<T, Integer> inventoryMap ;

	
	public Inventory() {
		
		inventoryMap = new HashMap<T, Integer>();
	}

	@Override
	public void addElementToInventory(T element, int quantity) {
		if (inventoryMap.containsKey(element)) {
			inventoryMap.replace(element, inventoryMap.get(element) + quantity);
		} else {
			inventoryMap.put(element, quantity);
		}

	}

	@Override
	public boolean removeElementFromInventory(T element, int quantity) {
		boolean removed = false;
		if (inventoryMap.containsKey(element)) {
			if (inventoryMap.get(element) > quantity) {
				inventoryMap.replace(element, inventoryMap.get(element) - quantity);
				removed = true;
			} else {
				System.out.println("You do not have enough " + element.toString());
			}
		}
		return removed;
	}

	public HashMap<T, Integer> getInventoryMap() {
		return inventoryMap;
	}

	public void setInventoryMap(HashMap<T, Integer> inventoryMap) {
		this.inventoryMap = inventoryMap;
	}

}
