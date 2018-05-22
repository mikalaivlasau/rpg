package attribute;

public class RawBonus implements Attribute {

    private int value;

    public RawBonus(int value) {
        this.value = value;
    }

    @Override
    public int calculate() {
        return value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
