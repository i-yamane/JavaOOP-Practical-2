package core;

/**
 * Implements sweets in the game.
 * 
 * These are meant to be eaten by Pokemons for an increase of experience.
 */
public class Sweet extends SingleUseItem {
	/**
	 * Experience gain from eating it.
	 */
	public final int xp;
	
	/**
	 * Builds a new sweet
	 * @param name of the sweet
	 * @param xp experience gain from eating it
	 */
	public Sweet(String name, int price, int xp) {
        super(name, price);
		this.xp = xp;
	}
}
