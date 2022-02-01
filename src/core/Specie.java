package core;

/**
 * Manages common caracteristics of a specie of Pokemons
 */
public class Specie {
	/**
	 * Identifying number
	 */
	public final int number;
	/**
	 * Identifying name
	 */
	public final String name;
	/**
	 * Type of the Specie
	 */
	public final String type;
	/**
	 * Initial number of health points
	 */
	public final int initialHP;
	/**
	 * Initial strength
	 */
	public final int initialStrength;
	
	/**
	 * Creates a new specie
	 * @param number an identifying number
	 * @param name an identifying name
	 * @param type a type, String for now
	 * @param initialHP the intial number of health point of a Pokemon of this specie (> 0)
	 * @param initialStrength same for its initial strength (> 0)
	 */
	public Specie(int number, String name, String type, int initialHP, int initialStrength) {
		this.number = number;
		this.name = name;
		this.type = type;
		if (initialHP <= 0) {
			System.out.println("Warning: a Pokemon of this specie will start dead (initialHP <= 0).");
		}
		this.initialHP = initialHP;
		if (initialStrength <= 0) {
			System.out.println("Warning: a Pokemon of this specie will not be able to compete (initialStrength <= 0).");
		}
		this.initialStrength = initialStrength;
	}

	/**
	 * String representation of the specie
	 */
	@Override
	public String toString() {
		return "Specie [number=" + number
		           + ", name=" + name
				   + ", type=" + type
				   + ", initialHp=" + initialHP
				   + ", initialStrength=" + initialStrength
				    + "]";
	}
}
