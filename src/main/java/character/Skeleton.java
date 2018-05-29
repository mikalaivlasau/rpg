package character;

import experience.Level;

/**
 * Just a mob.
 */
public class Skeleton extends Person {
	public Skeleton() {
		this.name = "Skeleton";
		this.health = 40;
		this.healthMax = 40;
		this.experience = 100;
		this.strength = 7;
		this.agility = 2;
		this.stamina = 1;
	}

	@Override
	public void useClassPower() {
		System.out.println("Aaahhr!!!");
	}

	@Override
	public void levelUp(Level level) {
		// Nothing to do
	}
}
