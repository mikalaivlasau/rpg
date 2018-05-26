package character;

public class Thief extends Person {
	public Thief(String name) {
		this.name = name;
		this.health = 70;
		this.experience = 0;
		this.strength = 2;
		this.agility = 10;
		this.stamina = 2;
	}

	@Override
	public void useClassPower() {
		this.agility *= 2;
	}
}
