package EntiyСreature;

public enum Direction {

    NORTH("Север"),
    SOUTH("Юг"),
    WEST("Запад"),
    EAST("Восток");

    private String name;

    Direction(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
