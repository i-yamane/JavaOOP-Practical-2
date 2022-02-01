package core;

/** 
 * Base class for Pokeballs
 */
public abstract class Pokeball extends PermanentItem {
    /**
     * Base efficiency of the ball
     */
    private int baseEfficiency;

    /**
     * Create new Item with a baseEfficiency in [0, 100] (changed to the closest int in that interval)
     * @param name to identify the Pokeball
     * @param price cost to acquire it
     * @param baseEfficiency the base efficiency, before applying a multiplier
     */
    public Pokeball(String name, float price, int baseEfficiency) {
        super(name, price);
        if (baseEfficiency < 0) {
            baseEfficiency = 0;
        }
        if (baseEfficiency > 100) {
            baseEfficiency = 100;
        }
        this.baseEfficiency = baseEfficiency;
    }

    /**
     * Computes and returns the effective efficiency.
     */
    public final int getEfficiency() {
        return getMultiplier() * baseEfficiency;
    }

    /**
     * Computes the base efficiency multiplier.
     * @return the multiplier
     */
    public abstract int getMultiplier();
}
