package main.java;

import main.java.model.Pacman;
import main.java.model.World;

import java.io.File;
import java.util.Scanner;

public class Simulator {

    private final int WORLD_MAX_WIDTH = 5;
    private final int WORLD_MAX_HEIGHT = 5;

    public void run(){
        System.out.println("Pacman Simulator Start");
        Scanner scanner = new Scanner(System.in);
        // create world and pacman
        World world = new World(WORLD_MAX_WIDTH,WORLD_MAX_HEIGHT);
        Pacman pacman = new Pacman();
        pacman.setWorld(world);

        //get input option
        scanner = getInputOption(scanner);

        //command handler
        handleCommand(scanner,pacman);

        scanner.close();
        System.out.println("Pacman Simulator Stop");


    }

    // Choose the input option, by file or by command line
    private Scanner getInputOption(Scanner scanner){
        System.out.println("Please Choose the input method");
        System.out.println("1. Command Line");
        System.out.println("2. Text File");
        System.out.print("(1/2): ");
        if (scanner.nextInt() == 1) {
            System.out.println("Input Commands: ");
        } else {
            try {
                boolean isVaildPath = false;
                System.out.println("Please put your text file in the directory CommandFiles and input filename:");
                while (!isVaildPath) {
                    if (scanner.hasNext()) {
                        File file = new File("CommandFiles/" + scanner.next());
                        if(file.exists()) {
                            scanner = new Scanner(file);
                            isVaildPath = true;
                        }else {
                            System.out.println("Please input an valid filename:");
                        }
                    }
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        return scanner;
    }

    private void handleCommand(Scanner scanner, Pacman pacman){
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
    }

}
