package location;

public enum MapFieldType {
    EMPTY("+"),
    PERSON("X"),
    MONSTER("@"),
    TREASURE("~");

    private final String sign;

    MapFieldType(String sign) {
        this.sign = sign;
    }

    public String getSign() {
        return sign;
    }
}
