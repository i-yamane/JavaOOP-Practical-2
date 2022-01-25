public class Pokemon {
	public static int counter = 0;

	public int id;
	public final String surname;
	public float size;
	public int level = 1;
	public Specie specie;
	public int xp = 0;
	public int hp;
	public int strength;

	public Pokemon(String surname, float size, int level, Specie specie) {
		// Semantic of var++: 1. save the value of var, 2. increment var, 3. return the saved value.
		this.id = counter++;

		this.surname = surname;
		this.size = size;
		if (level <= 0 || level > 5) {
			System.out.println("Level must be positive and smaller than 5.");
		} else {
			this.level = level;
		}
		this.specie = specie;
		this.hp = specie.initialHP;
		this.strength = specie.initialStrength;
	}

	public Pokemon(String surname, float size, int level, Specie specie, int xp) {
		this(surname, size, level, specie);
		if (xp < 0) {
			System.out.println("XP must be non-negative.");
		} else {
			this.xp = xp;
		}
	}

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

	public void attack(Pokemon target) {
		target.hp -= strength;
	}

	public void receiveXP(int toto) {
		xp += toto;
		level = getLevelFromXp(xp);
	}

	public void eatSweet(Sweet s) {
		if (s.alreadyEaten){
			System.out.println("Warning: this sweet has already been eaten.");
		} else {
			receiveXP(s.xp);
			s.alreadyEaten = true;
		}
	}

	@Override
	public String toString() {
		return "Pokemon [id=" + id
		            + ", surname=" + surname
					+ ", size=" + size
					+ ", level=" + level
					+ ", specie=" + specie
					+ ", xp=" + xp
					+ ", hp=" + hp
					+ ", strength=" + strength
					 + "]";
	}
}
