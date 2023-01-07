

/**
 * Manages the status and caracteristics of a Pokemon
 */
public class Pokemon {
	/**
	 * Global counter of Pokemons, used to generate unique ids
	 */
	public static int counter = 0;

	/**
	 * Unique id of the Pokemon
	 */
	public final int id;
	/**
	 * Identifying name of the Pokemon
	 */
	public final String nickname;

	/**
	 * Size of the Pokemon
	 */
	public float size;
	/**
	 * Current level of the Pokemon, should be consistent with xp.
	 */
	public int level = 1;
	/**
	 * Species of the Pokemon
	 */
	public Species species;
	/**
	 * Current number of experience points of the Pokemon, should be consistent with level
	 */
	public int xp = 0;
	/**
	 * Current number of health points
	 */
	public int hp;
	/**
	 * Current strength
	 */
	public int strength;

	/**
	 * Creates a new Pokemon, and initializes it according to its species
	 * @param nickname given name of the Pokemon
	 * @param size initial size of the Pokemon
	 * @param level initial level of the Pokeon, determining its initial experience
	 * @param species the species it belongs to
	 */
	public Pokemon(String nickname, float size, int level, Species species) {
		// Semantic of var++: 1. save the value of var, 2. increment var, 3. return the saved value.
		this.id = counter++;

		this.nickname = nickname;
		this.size = size;
		if (level <= 0 || level > 5) {
			System.out.println("Level must be positive and smaller than 5.");
		} else {
			this.level = level;
		}
		this.species = species;
		this.hp = species.initialHP;
		this.strength = species.initialStrength;
	}

	/**
	 * Same as Pokemon(String nickname, float size, int level, Species species),
	 * but setting an experience too (if consistent with level)
	 * @param nickname
	 * @param size
	 * @param level
	 * @param species
	 * @param xp
	 */
	public Pokemon(String nickname, float size, int level, Species species, int xp) {
		this(nickname, size, level, species);
		if (xp < 0) {
			System.out.println("XP must be non-negative.");
		} else if (getLevelFromXp(xp) != level) {
			System.out.println("XP level must be consistent.");
		} else {
			this.xp = xp;
		}
	}

	/**
	 * Computes the level from an experience.
	 *
	 * Note: this helper method has been converted to public.
	 * @param xp the experience to convert
	 * @return the level
	 */
	public static int getLevelFromXp(int xp) {
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
	 * Attack a target pokemon, and update its number of health points
	 * @param target the pokemon that will take damages
	 */
	public void attack(Pokemon target) {
		target.hp -= strength;
	}

	/**
	 * Add some XP, and update the level.
	 * @param xp
	 */
	public void receiveXP(int xp) {
		this.xp += xp;
		level = getLevelFromXp(xp);
	}

	/**
	 * Take a potion to recover some HP.
	 * @param healer
	 */
	public void getHealed(Potion potion) {
		this.hp += potion.heal();
	}

	/**
	 * Eat a sweet and gain XP.
	 *
	 * @param sweet
	 */
	public void eatSweet(Sweet sweet) {
		receiveXP(sweet.xp);
	}

	/**
	 * Status of the Pokemon
	 */
	@Override
	public String toString() {
		return "Pokemon [id=" + id
			+ ", nickname=" + nickname
			+ ", size=" + size
			+ ", level=" + level
			+ ", species=" + species
			+ ", xp=" + xp
			+ ", hp=" + hp
			+ ", strength=" + strength
			+ "]";
	}
}
