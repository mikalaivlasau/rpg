package character;

import experience.Level;

public class Wizard extends Person {
	public Wizard(String name) {
		this.name = name;
		this.health = 60;
		this.healthMax = 60;
		this.experience = 0;
		this.strength = 6;
		this.agility = 6;
		this.stamina = 10;
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
