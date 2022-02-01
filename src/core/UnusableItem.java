package core;

/**
 * An item that has no special capabilities.
 */
public class UnusableItem extends Item {
    /**
     * Initialize the item
     * @return
     */
    public UnusableItem(String name, float price) {
        super(name, price);
    }

    @Override
    public boolean isSingleUse() {
        return false;
    }

    @Override
    public boolean isUnusable() {
        return true;
    }

    @Override
    public boolean isPermanent() {
        return false;
    }
}
