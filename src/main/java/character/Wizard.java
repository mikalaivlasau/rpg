package character;

import experience.Level;

/**
 * Wizard. Primary skill is stamina.
 */
public class Wizard extends Person {
	public Wizard(String name) {
		this.name = name;
		this.health = 40;
		this.healthMax = 40;
		this.experience = 0;
		this.strength = 2;
		this.agility = 1;
		this.stamina = 2;
	}

	@Override
	public void useClassPower() {
		this.stamina *= 2;
	}

	@Override
	public void levelUp(Level level) {
		super.levelUp(level);
		stamina = (int) (stamina * 1.25);
	}
}
