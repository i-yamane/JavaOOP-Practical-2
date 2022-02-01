package core;

/**
 * Manages the status and caracteristics of a Pokemon
 */
public class Pokemon {
	/**
	 * Global counter of Pokemons, used to generate unique ids
	 */
	private static int counter = 0;

	/**
	 * Unique id of the Pokemon
	 */
	public final int id;
	/**
	 * Identifying name of the Pokemon
	 */
	public final String SURNAME;

	/**
	 * Size of the Pokemon
	 */
	private float size;
	/**
	 * Current level of the Pokemon, should be consistent with xp.
	 */
	private int level = 1;
	/**
	 * Current number of experience points of the Pokemon, should be consistent with level
	 */
	private int xp = 0;
	/**
	 * Specie of the Pokemon
	 */
	private Specie specie;
	/**
	 * Current number of health points
	 */
	private int hp;
	/**
	 * Current strength
	 */
	private int strength;

	/**
	 * Creates a new Pokemon, and initializes it according to its specie
	 * @param surname given name of the Pokemon
	 * @param size initial size of the Pokemon
	 * @param level initial level of the Pokeon, determining its initial experience
	 * @param specie the specie it belongs to
	 */
	public Pokemon(String surname, float size, int level, Specie specie) {
		// Semantic of var++: 1. save the value of var, 2. increment var, 3. return the saved value.
		this.id = counter++;

		this.SURNAME = surname;
		this.size = size;
		if (level <= 0 || level > 5) {
			System.out.println("Level must be positive and smaller than 5.");
		} else {
			this.level = level;
		}
		// For coherence between xp and level
		while (getLevelFromXp(xp) < this.level) {
			this.xp++;
		}
		this.specie = specie;
		this.hp = specie.initialHP;
		this.strength = specie.initialStrength;
	}

	/**
	 * Same, but setting an experience too (if consistent with level)
	 * @param surname
	 * @param size
	 * @param level
	 * @param specie
	 * @param xp
	 */
	public Pokemon(String surname, float size, int level, Specie specie, int xp) {
		this(surname, size, level, specie);
		if (xp < 0) {
			System.out.println("XP must be non-negative.");
		} else if (getLevelFromXp(xp) != level) {
			System.out.println("XP level must be consistent.");
		} else {
			this.xp = xp;
		}
	}

	/**
	 * Current size
	 * @return
	 */
	public float getSize() {
		return this.size;
	}

	/**
	 * Current level
	 * @return
	 */
	public int getLevel() {
		return this.level;
	}

	/**
	 * Specie
	 * @return
	 */
	public Specie getSpecie() {
		return this.specie;
	}

	/**
	 * Current experience
	 * @return
	 */
	public int getXp() {
		return this.xp;
	}

	/**
	 * Current health points
	 * @return
	 */
	public int getHp() {
		return this.hp;
	}

	/**
	 * Current strength
	 * @return
	 */
	public int getStrength() {
		return this.strength;
	}

	/**
	 * Computes the level from an experience.
	 * 
	 * Note: this helper method has been converted to private.
	 * @param xp the experience to convert
	 * @return the level
	 */
	private static int getLevelFromXp(int xp) {
		int res = 1;
		if(xp >= 5) {
			res = 2;
		}
		if(xp >= 15) {
			res = 3;
		}
		if(xp >= 30) {
			res = 4;
		}
		if(xp >= 100) {
			res = 5;
		}
		return res;
	}

	/**
	 * Attack a target pokemon, and update its number of health points and defense
	 * @param target the pokemon that will take damages
	 */
	public void attack(Pokemon target) {
        target.hp -= strength;
	}

	/**
	 * Add some experience, and update the level.
	 * @param xp
	 */
	public void receiveXP(int xp) {
		this.xp += xp;
		level = getLevelFromXp(xp);
	}

	/**
	 * Eat a sweet, udpate the experience.
	 * @param sweet
	 */
	public void eatSweet(Sweet sweet) {
		if (sweet.getAlreadyUsed()){
			System.out.println("Warning: this sweet has already been eaten.");
		} else {
			receiveXP(sweet.xp);
			sweet.setAlreadyUsed();
		}
	}

	/**
	 * Status of the Pokemon
	 */
	@Override
	public String toString() {
		return "Pokemon [id=" + id
		            + ", surname=" + SURNAME
					+ ", size=" + size
					+ ", level=" + level
					+ ", specie=" + specie
					+ ", xp=" + xp
					+ ", hp=" + hp
					+ ", strength=" + strength
					 + "]";
	}
}
