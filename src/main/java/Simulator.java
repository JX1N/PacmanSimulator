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
        System.out.println("2. Text File (Input your commands in commands.txt)");
        System.out.print("(1/2): ");

        Scanner scanner = new Scanner(System.in);
        if (scanner.nextInt() == 1) {
            System.out.println("Input Commands: ");
        } else {
            try {
                File file = new File("commands.txt");
                scanner = new Scanner(file);
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
                    } else{
                        System.out.println("Invalid Command");
                    }
                    continue;
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
                            System.out.println("Output: " + pacman.report());
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
    }
}
