package character;

public class Thief extends Person {
    public Thief(String name) {
        this.name = name;
        this.experience = 0;
        this.strength = 2;
        this.agility = 10;
        this.intelligence = 2;
    }

    @Override
    public void useClassPower() {
        this.agility *= 2;
    }
}
