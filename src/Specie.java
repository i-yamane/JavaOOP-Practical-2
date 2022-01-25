

public class Specie {
	public final int number;
	public final String name;
	public final String type;
	public final int initialHP;
	public final int initialStrength;
	
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
