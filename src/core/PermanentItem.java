package core;

/**
 * An item with a permanent effect
 */
public class PermanentItem extends Item {
    /**
     * Initialize the item
     * @return
     */
    public PermanentItem(String name, float price) {
        super(name, price);
    }

    @Override
    public boolean isSingleUse() {
        return false;
    }

    @Override
    public boolean isUnusable() {
        return false;
    }

    @Override
    public boolean isPermanent() {
        return true;
    }
}
