package character;

import experience.Level;

import java.io.Serializable;

/**
 * An abstract class represents the character.
 */
public abstract class Person implements Serializable {
	String name;
	int health;
	int healthMax;
	int experience;
	int strength;
	int agility;
	int stamina;
	int attack;
	int defense;
	Level level = Level.ONE;

	/**
	 * Allow person use a class power. Not used for now.
	 */
	public abstract void useClassPower();

	public void levelUp(Level level) {
		double k = 1.2;
		healthMax = (int) (healthMax * k);
		health = healthMax;
		strength = (int) (strength * k);
		agility = (int) (agility * k);
		stamina = (int) (stamina * k);
		this.level = level;
	}

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

	public int getHealthMax() {
		return healthMax;
	}

	public void setHealthMax(int healthMax) {
		this.healthMax = healthMax;
	}

	public int getAttack() {
		return attack;
	}

	public void setAttack(int attack) {
		this.attack = attack;
	}

	public int getDefense() {
		return defense;
	}

	public void setDefense(int defense) {
		this.defense = defense;
	}

	public Level getLevel() {
		return level;
	}

	public void setLevel(Level level) {
		this.level = level;
	}
}
