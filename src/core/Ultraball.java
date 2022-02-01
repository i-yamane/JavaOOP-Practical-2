package core;

/**
 * Ultraball is a pokeball with efficiency multiplier 2.
 */
public class Ultraball extends Pokeball {
    /**
     * Creates the ultraball pokeball, and initialize its efficiency
     * @param name Name of the ultraball
     * @param price Its price
     * @param efficiency Its base efficiency (before multiplier)
     */
    public Ultraball(String name, float price, int efficiency) {
        super(name, price, efficiency);
    }

    /**
     * Multiplier: 2
     */
    public int getMultiplier() {
        return 2;
    }
}
