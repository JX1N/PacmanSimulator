package main.java.util;

public enum Direction {
    NORTH,
    EAST,
    SOUTH,
    WEST;

    public static boolean contains(String type) {
        for (Direction direction : Direction.values()) {
            if (direction.name().equals(type)) {
                return true;
            }
        }
        return false;
    }
}
