package main.java;

import main.java.model.Pacman;
import main.java.model.World;

import java.io.File;
import java.util.Scanner;

public class Simulator {
    public static void main(String[] args) {

        System.out.println("Pacman Simulator/n");
        System.out.println("Please Choose the input method");
        System.out.println("1. Command Line");
        System.out.println("2. Text File");
        System.out.print("(1/2): ");

        Scanner scanner = new Scanner(System.in);
        if (scanner.nextInt() == 1) {
            System.out.println("Input Commands: ");
        } else {
            try {
                boolean isVaildPath = false;
                while (!isVaildPath) {
                    System.out.println("Put your text file in CommandFiles and input file name:");
                    if (scanner.hasNext()) {
                        String path = "CommandFiles/" + scanner.next();
                        File file = new File(path);
                        scanner = new Scanner(file);
                        isVaildPath = true;
                    }
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }

        //create world and pacman
        World world = new World(5, 5);
        Pacman pacman = new Pacman();
        pacman.setWorld(world);

        boolean notExit = true;
        while (notExit) {
            //Make sure all commands are uppercase
            if (scanner.hasNext()) {
                String command = scanner.nextLine().toUpperCase();
                if (!pacman.getStatus()) {
                    String[] comms = command.split("\\s+");
                    if (comms.length == 2 && comms[0].equals("PLACE")) {
                        pacman.place(comms[1]);
                    }
                } else {
                    switch (command) {
                        case "LEFT":
                        case "RIGHT":
                            pacman.turn(command);
                            break;
                        case "MOVE":
                            pacman.move();
                            break;
                        case "REPORT":
                            System.out.println(pacman.report());
                            break;
                        case "EXIT":
                            notExit = false;
                            break;
                        default:
                            break;
                    }
                }
            }
        }

        scanner.close();
        System.out.println("FINISHED");
    }

}
