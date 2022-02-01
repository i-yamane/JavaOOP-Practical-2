package core;

/**
 * Greatball is a pokeball with efficiency multiplier 3.
 */
public class Greatball extends Pokeball {

    /**
     * Creates the ultraball pokeball, and initialize its efficiency
     * @param name Name of the ultraball
     * @param price Its price
     * @param efficiency Its base efficiency (before multiplier)
     */
    public Greatball(String name, float price, int efficiency) {
        super(name, price, efficiency);
    }

    /**
     * Multiplier: 3
     */
    public int getMultiplier() {
        return 3;
    }
}
