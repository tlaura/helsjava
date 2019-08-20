package skijumping;

import java.util.HashMap;
import java.util.Scanner;

public class Simulation {
    Scanner scan = new Scanner(System.in);
    public int round;
    public HashMap<Jumper, Integer> jumpers;

    public Simulation(){
        this.round = 0;
        this.jumpers = new HashMap<>();
    }

    public void names(){
        Print.start();
        while(true){
            System.out.print("Participant name: ");
            String name = scan.nextLine();
            if(name.length() > 0){
                Jumper jumper = new Jumper(name);
                addJumper(jumper);
            } else {
                this.round++;
                break;
            }
        }
    }

    public void addJumper(Jumper jumper){
        this.jumpers.put(jumper, jumper.getPoints());
    }

    public void printJumpers(){
        for(Jumper jumper: jumpers.keySet()){
            System.out.println(jumper.toString());
        }
    }

    public void jumpingPhase(){
        System.out.println();
        Print.printJumpStart();
        while(true){
            System.out.print("Write \"jump\" to jump; otherwise you quit: ");
            String jump = scan.nextLine();
            if(jump.equals("jump")){
                System.out.println();
                System.out.println("Round " + this.round + "\n");
                System.out.println("Jumping order: \n");
                printJumpers();
                System.out.println();
                System.out.println("Results of round " + this.round);
                for(Jumper jumper: jumpers.keySet()){
                    jumper.printResults();
                }

            } else {
                System.out.println("Thanks\n");
                System.out.println("Tournament results: \n");
                break;
            }
        }
    }
}
