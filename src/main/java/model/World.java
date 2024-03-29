package main.java.model;

public class World {

    private int maxX;
    private int maxY;

    public World(int x, int y) {
        maxX = x - 1;
        maxY = y - 1;
    }

    public boolean inWorld(int x, int y) {
        return x <= maxX && y <= maxY && x >= 0 && y >= 0;
    }

}
