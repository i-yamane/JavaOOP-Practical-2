package core;

/**
 * An item that can be used only once.
 */
public class SingleUseItem extends Item {
	/**
	 * Flag whether it has already been used.
	 */
	private boolean alreadyUsed = false;

    /**
     * Initialize the state of the item
     * @return
     */
    public SingleUseItem(String name, float price) {
        super(name, price);
    }

	/**
	 * Return whether it has been eaten
	 * @return true if eaten
	 */
	public boolean getAlreadyUsed() {
		return this.alreadyUsed;
	}

	/**
	 * Marks the sweet as eaten.
	 * 
	 * Note how this setter does not take any argument: the logic
	 * of alreadyEaten is such that it cannot be "uneaten", therefore,
	 * modifying it can only mean setting it to true.
	 */
	public void setAlreadyUsed() {
		this.alreadyUsed = true;
	}

    @Override
    public boolean isSingleUse() {
        return true;
    }

    @Override
    public boolean isUnusable() {
        return false;
    }

    @Override
    public boolean isPermanent() {
        return false;
    }
}
