package main.java.model;

public class World {

    private int maxX;
    private int maxY;

    public World(int x, int y) {
        maxX = x;
        maxY = y;
    }

    public boolean inWorld(int x, int y) {
        return x <= maxX && y <= maxY;
    }

}
