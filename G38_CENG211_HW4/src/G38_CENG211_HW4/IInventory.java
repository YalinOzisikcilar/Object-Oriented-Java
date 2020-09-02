package G38_CENG211_HW4;

public interface IInventory<T> {
	public void addElementToInventory(T elemenet, int index);

	public boolean removeElementFromInventory(T element, int index);
}
