/**
 * Baseline Artificial Intelligence to compare against.
 * 
 * This AI has some drawbacks. Find them!
 */
public class BaselineAI {
	public void play(Pokemon active, Pokemon target) {
		int damageOnTarget = estimateDamage(active, target);
		int damageOnActive = estimateDamage(target, active);

		double survivalActive = active.hp / damageOnActive;
		double survivalTarget = target.hp / damageOnTarget;
		
		if (survivalActive >= survivalTarget) {
			// We will still lead if we attack, so we do
			active.attack(target);
		} else {
			// Chances of loosing, we defend
			// active.defend(); // TODO: Uncomment after exercise 5
		}
	}
	
	public int estimateDamage(Pokemon active, Pokemon target) {
		// TODO: Uncomment after exercise 5
		// int damage = active.strength * (1 - target.defense / 100);
		// if (damage <= 0) {
		// 	damage = 1;
		// }
		// return damage;
		
		return 0; // TODO: Comment after exercise 5
	}
	
}
