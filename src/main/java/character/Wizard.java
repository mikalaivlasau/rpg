package character;

public class Wizard extends Person {
	public Wizard(String name) {
		this.name = name;
		this.health = 60;
		this.experience = 0;
		this.strength = 2;
		this.agility = 2;
		this.stamina = 10;
	}

	@Override
	public void useClassPower() {
		this.stamina *= 2;
	}
}
