package war;

public class Product {

    public Product(String name, String player, int size) {
        this.name = name;
        this.player = player;
        this.size = size;
    }

	private String name;
	private String player;
	private int size;

	public String getName() {
		return this.name;
	}

	/**
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	public String getPlayer() {
		return this.player;
	}

	/**
	 * 
	 * @param player
	 */
	public void setPlayer(String player) {
		this.player = player;
	}

	public int getSize() {
		return this.size;
	}

	/**
	 * 
	 * @param size
	 */
	public void setSize(int size) {
		this.size = size;
	}

	public void getAttribute() {
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param attribute
	 */
	public void setAttribute(int attribute) {
		// TODO - implement Product.setAttribute
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param size
	 */

}