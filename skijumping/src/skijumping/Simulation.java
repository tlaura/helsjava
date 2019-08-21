package skijumping;

import java.util.*;

public class Simulation {
    Scanner scan = new Scanner(System.in);
    public ArrayList<Jumper> jumpers;
    private int round;

    public Simulation(){
        this.jumpers = new ArrayList<>();
        this.round = 0;
    }

    public void addJumper(Jumper jumper){
        this.jumpers.add(jumper);
    }

    public void printResults(Jumper jumper){
        System.out.println(jumper.getName());
        jumper.setAndAddLength();
        System.out.println(" length: " + jumper.getLength());
        jumper.setVotes();
        System.out.print(" judge votes: " + Arrays.toString(jumper.getVotes()));
        System.out.println();
        jumper.addPoints();
    }


    public void printJumpers(){
        Collections.sort(jumpers);
    }

    public void jumpingOrder(){
        System.out.println("Jumping order:");
        int order = 1;
        Collections.sort(this.jumpers);
        for(Jumper jumper: jumpers){
            System.out.println(" " + order + ". " + jumper.toString());
            order++;
        }
        System.out.println();
    }

    public void names(){
        Print.start();
        while(true){
            System.out.print("Participant name: ");
            String name = scan.nextLine();
            Jumper j = new Jumper(name);
            if(name.length() > 0){
                addJumper(j);
            } else {
                break;
            }
        }
    }

    public void jumpingPhase(){
        System.out.println();
        Print.printJumpStart();
        while(true){
            System.out.print("Write \"jump\" to jump; otherwise you quit: ");
            String jump = scan.nextLine();
            if(jump.equals("jump")){
                this.round++;
                System.out.println();
                jumpingOrder();
                printJumpers();
                System.out.println();
                for(Jumper jumper: jumpers){
                    jumper.toString();
                }
                System.out.println("Round " + this.round + "\n");
                for(Jumper jumper: jumpers){
                    printResults(jumper);
                }
                System.out.println();
            } else {
                System.out.println();
                System.out.println("Thanks!\n");
                System.out.println("Tournament results: \n");
                break;
            }
        }
    }
}
