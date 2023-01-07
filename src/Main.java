

/**
 * Class whose sole responsibility is to start the program, and execute something.
 */
public class Main {
	/**
	 * Entrypoint to the program
	 * @param args
	 */
	public static void main(String[] args) {
		// 2 Pokemons
		Species bulbzaurus = new Species(0,"Bulbzaurus", "GRASS", 10, 1);
		Pokemon myPokemon = new Pokemon("Bulbzaurus 1", 12f, 1, bulbzaurus);
		System.out.println(myPokemon.nickname + " (" + myPokemon.species.name + ")");
		Pokemon myPokemon2 = new Pokemon("Bulbzaurus 2", 12f, 58, bulbzaurus);
		
		// Basic info about them
		System.out.println(myPokemon.level);
		System.out.println(myPokemon.id);
		System.out.println(myPokemon2.id);
		
		System.out.println(myPokemon);
		
		// Increment experience
		for(int i = 0; i < 100; ++i) {
			myPokemon.receiveXP(1);
			System.out.println(myPokemon);
		}
		
		// Eat a sweet
		Sweet s = new Sweet("Licorice", 3);
		myPokemon.eatSweet(s);
		System.out.println(myPokemon);
		System.out.println(myPokemon2);
		myPokemon2.eatSweet(s);
		System.out.println(myPokemon2);
		
		// Pokemon interaction
		while (myPokemon.hp > 0 && myPokemon2.hp > 0) {
			myPokemon.attack(myPokemon2);
			if (myPokemon2.hp > 0) {
				myPokemon2.attack(myPokemon);
			}
		}
		if (myPokemon.hp > 0) {
			myPokemon.receiveXP(5);
		} else {
			myPokemon2.receiveXP(5);
		}

		// End of interaction info
		System.out.println(myPokemon);
		System.out.println(myPokemon2);
	}

}
