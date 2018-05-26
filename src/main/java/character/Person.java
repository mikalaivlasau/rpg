package character;

import attribute.Attribute;
import attribute.CompositeAttribute;
import attribute.RawBonus;

public abstract class Person {
	String name;
	int health;
	int experience;
	int strength;
	int agility;
	int stamina;
	int attack;
	int defense;

	public abstract void useClassPower();

	public boolean isAlive() {
		return health > 0;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

	public int getStrength() {
		return strength;
	}

	public void setStrength(int strength) {
		this.strength = strength;
	}

	public int getAgility() {
		return agility;
	}

	public void setAgility(int agility) {
		this.agility = agility;
	}

	public int getStamina() {
		return stamina;
	}

	public void setStamina(int stamina) {
		this.stamina = stamina;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public int getAttack() {
		Attribute basic = new RawBonus(getStrength());
		CompositeAttribute finalAttack = new CompositeAttribute();
		finalAttack.addComponent(basic);
		return finalAttack.calculate();
	}

	public void setAttack(int attack) {
		this.attack = attack;
	}

	public int getDefense() {
		Attribute basic = new RawBonus(getStamina());
		CompositeAttribute finalDefense = new CompositeAttribute();
		finalDefense.addComponent(basic);
		return finalDefense.calculate();
	}

	public void setDefense(int defense) {
		this.defense = defense;
	}
}
