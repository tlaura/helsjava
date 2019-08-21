package skijumping;

import java.util.*;

public class Jumper implements Comparable<Jumper> {
    private String name;
    private int points;
    private ArrayList<Integer> lengths;
    private int length;
    private Random random;
    private int[] votes;


    public Jumper(String name){
        this.name = name;
        this.points = 0;
        this.lengths = new ArrayList<>();
        this.length = 0;
        this.random = new Random();
        this.votes = new int[5];
    }

    public void setAndAddLength(){
        this.length = random.nextInt(120 - 60 + 1) + 60;
        this.lengths.add(this.length);
    }

    public int getLength(){
        return this.length;
    }

    public int getPoints(){
        return this.points;
    }

    public String getName(){
        return this.name;
    }

    public void addPoints(){
        this.points += this.length + totalPointsFromVotes();
    }

    public int[] getVotes(){
        return this.votes;
    }

    public void setVotes(){
        int i = 0;
        while(i < 5){
            this.votes[i++] = random.nextInt(11)+10;
        }
    }

    public int totalPointsFromVotes(){
        ArrayList<Integer> sortedVotes = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            sortedVotes.add(this.votes[i]);
        }
        Collections.sort(sortedVotes);
        sortedVotes.remove(0);
        sortedVotes.remove(sortedVotes.size()-1);

        int sum = 0;
        for(int vote: sortedVotes){
            sum += vote;
        }
        return sum;
    }


    @Override
    public String toString() {
        return this.name + " (" + this.points + " points)";
    }

    @Override
    public int compareTo(Jumper jumper) {
        return this.points - jumper.getPoints();
    }

}
