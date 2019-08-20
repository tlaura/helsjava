package skijumping;

import java.util.*;

public class Jumper implements Comparable<Jumper> {
    private String name;
    private int points;
    private ArrayList<Integer> votes;
    private int length;


    public Jumper(String name){
        this.name = name;
        this.points = 0;
        this.votes = new ArrayList<>();
        this.length = 0;
    }

    public int getPoints(){
        return this.points;
    }

    public void setLength(){
        Random num = new Random();
        this.length = num.nextInt(61) + 60;
    }

    public void votes(){
        int i = 0;
        while(i < 5){
            Random num = new Random();
            this.votes.add(num.nextInt(11)+10);
            i++;
        }
    }

    public void printResults(){
        votes();
        System.out.println(this.name);
        setLength();
        System.out.println(" length: " + this.length);
        System.out.print(" judge votes: ");
        System.out.println(Arrays.toString(this.votes.toArray()));
        System.out.println();
        updatePoints();
        clearVotes();
    }

    public int pointsPerRound(){
        Collections.sort(this.votes);
        int sum = 0;
        for (int i = 1; i < votes.size()-1; i++) {
            sum += this.votes.get(i);
        }
        System.out.println(sum);
        return sum + this.length;
    }

    public void updatePoints(){
        this.points += pointsPerRound();
    }

    public void clearVotes(){
        this.votes.clear();
    }

    @Override
    public String toString() {
        return this.name + " (" + this.points + " points)";
    }

    @Override
    public int compareTo(Jumper jumper) {
        return this.points - jumper.getPoints();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Jumper jumper = (Jumper) o;
        return points == jumper.points &&
                name.equals(jumper.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, points);
    }
}
