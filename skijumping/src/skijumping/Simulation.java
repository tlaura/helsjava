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

    public void names(){
        System.out.println("Kumpula ski jumping week\n");
        System.out.println("Write the names of the participants one at a time; " +
                "an empty string brings you to the jumping phase.");
        while(true){
            System.out.print("  Participant name: ");
            String name = scan.nextLine();
            Jumper j = new Jumper(name);
            if(name.length() > 0){
                addJumper(j);
            } else {
                break;
            }
        }
    }

    public void jumpingOrder(){
        Collections.sort(this.jumpers);
        System.out.println("Jumping order:");
        int order = 1;
        for(Jumper jumper: jumpers){
            System.out.println("  " + order + ". " + jumper.toString());
            order++;
        }
        System.out.println();
    }

    public void printResults(Jumper jumper){
        System.out.println("  " + jumper.getName());
        jumper.setAndAddLength();
        System.out.println("    length: " + jumper.getLength());
        jumper.setVotes();
        System.out.print("    judge votes: " + Arrays.toString(jumper.getVotes()));
        System.out.println();
        jumper.addPoints();
    }

    public void printTournamentResults(){
        System.out.println("Position    Name");
        Collections.reverse(jumpers);
        int order = 1;
        for(Jumper jumper: jumpers){
            System.out.println(order + "           " + jumper.toString());
            System.out.print("            jump lengths: ");
            jumper.printLengths();
            order++;
        }
    }

    public void jumpingPhase(){
        System.out.println();
        System.out.println("The tournament begins!\n");
        while(true){
            System.out.print("Write \"jump\" to jump; otherwise you quit: ");
            String jump = scan.nextLine();
            if(jump.equals("jump")){
                this.round++;
                System.out.println();
                System.out.println("Round " + this.round + "\n");
                jumpingOrder();
                System.out.println("Results of round " + this.round);
                for(Jumper jumper: jumpers){
                    printResults(jumper);
                }
                System.out.println();
            } else {
                System.out.println();
                System.out.println("Thanks!\n");
                System.out.println("Tournament results:");
                printTournamentResults();
                break;
            }
        }
    }
}
