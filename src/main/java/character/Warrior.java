package character;

public class Warrior extends Person {
    public Warrior(String name) {
        this.name = name;
        this.experience = 0;
        this.strength = 10;
        this.agility = 2;
        this.intelligence = 2;
    }

    @Override
    public void useClassPower() {
        this.strength *= 2;
    }
}
