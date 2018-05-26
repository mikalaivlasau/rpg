package fight;

import character.Person;

public class Duel {

	private Person creature;
	private Person person;

	public Duel(Person person, Person creature) {
		this.person = person;
		this.creature = creature;
	}

	public Person getCreature() {
		return creature;
	}

	public void setCreature(Person creature) {
		this.creature = creature;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}
}
