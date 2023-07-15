
public interface CellPressedListener {
	public void cellPressed(int i , int j);

	/**
	 * this is the interface of the cells, it has the cellPressed method in it.
	 * with this interface, I can make the cells become "listeners" to each other.
	 */
}
