package character;

import experience.Level;

public class Thief extends Person {
	public Thief(String name) {
		this.name = name;
		this.health = 70;
		this.healthMax = 70;
		this.experience = 0;
		this.strength = 6;
		this.agility = 10;
		this.stamina = 6;
	}

	@Override
	public void useClassPower() {
		this.agility *= 2;
	}

	@Override
	public void levelUp(Level level) {
		super.levelUp(level);
		agility = (int) (agility * 1.25);
	}
}
