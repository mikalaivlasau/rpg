package character;

public class Wizard extends Person {
    public Wizard(String name) {
        this.name = name;
        this.experience = 0;
        this.strength = 2;
        this.agility = 2;
        this.intelligence = 10;
    }

    @Override
    public void useClassPower() {
        this.intelligence *= 2;
    }
}
