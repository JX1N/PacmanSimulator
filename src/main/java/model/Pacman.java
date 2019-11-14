package main.java.model;

import main.java.util.Direction;

public class Pacman {
    //pacman is placed or not
    private boolean status;
    private int locX;
    private int locY;
    private World world;

    //0: north 1:east 2:south 3:west
    private Direction faceDir;

    //initialize pacman as unplaced ststus
    public Pacman() {
        status = false;
    }

    // set world for pacman
    public void setWorld(World world) {
        this.world = world;
    }

    public boolean getStatus() {
        return this.status;
    }

    //PLACE
    public void place(String comm) {
        String[] comms = comm.split(",");
        if (comms.length == 3) {
            int x = Integer.parseInt(comms[0]);
            int y = Integer.parseInt(comms[1]);

            if (world.inWorld(x, y) && Direction.contains(comms[2])) {
                locX = x;
                locY = y;
                this.faceDir = Direction.valueOf(comms[2]);
                status = true;
            }
        }
    }

    //MOVE
    public void move() {
        //calculate the excepted position in the world
        int tempX = locX;
        int tempY = locY;
        switch (faceDir.ordinal()) {
            case 0:
                tempY++;
                break;
            case 1:
                tempX++;
                break;
            case 2:
                tempY--;
                break;
            case 3:
                tempX--;
                break;
            default:
                return;
        }

        //check whether this point is in selected world
        if (world.inWorld(tempX, tempY)) {
            locX = tempX;
            locY = tempY;
        }
    }

    //RIGHT or LEFT
    public void turn(String comm) {
        if (comm.equals("LEFT")) {
            faceDir = Direction.values()[(faceDir.ordinal() + 4 - 1) % 4];
        }
        if (comm.equals("RIGHT")) {
            faceDir = Direction.values()[(faceDir.ordinal() + 4 + 1) % 4];
        }
    }

    //REPORT
    public String report() {
        if (this.status) {
            return "Output: " + locX + "," + locY + "," + faceDir.toString();
        } else {
            return "Waiting to be placed";
        }
    }

}
