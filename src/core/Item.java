package core;

/**
 * Implements and item in the game.
 * 
 * Attention, one and only one of isUnusable(), isSingleUse() and isPermanent() can
 * return true.
 */
public abstract class Item {
    /**
     * The name of the item, as displayed to identify it.
     */
    public final String name;
    /**
     * Value of the item, in PM$.
     */
    private float price;

    /**
     * Initialize the item.
     * @param name
     * @param price
     */
    public Item(String name, float price) {
        this.name = name;
        this.price = price;
    }

    /**
     * Get the value of the item.
     * @return the price in PM$.
     */
    public float getPrice() {
        return price;
    }

    /**
     * Whether the item is not usable
     * @return
     */
    public abstract boolean isUnusable();
    /**
     * Whether the item can only be used once
     * @return
     */
    public abstract boolean isSingleUse();
    /**
     * Whether the item has a permanent effect
     * @return
     */
    public abstract boolean isPermanent();
}
