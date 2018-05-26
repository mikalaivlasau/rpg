package character;

public class Warrior extends Person {
	public Warrior(String name) {
		this.name = name;
		this.health = 100;
		this.experience = 0;
		this.strength = 10;
		this.agility = 2;
		this.stamina = 2;
	}

	@Override
	public void useClassPower() {
		this.strength *= 2;
	}
}
