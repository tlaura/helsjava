package dungeon;

import java.util.Random;
import java.util.Scanner;

public class Dungeon {
    Scanner scan = new Scanner(System.in);
    private Random random;
    private int length, height, vampires, moves;
    private boolean vampiresMove;
    private Player player;

    public Dungeon(int length, int height, int vampires, int moves, boolean vampiresMove){
        this.length = length;
        this.height = height;
        this.vampires = vampires;
        this.moves = moves;
        this.vampiresMove = vampiresMove;
        player = new Player(length, height);
    }

    public void positions(){
        System.out.println(player.toString());
        Vampire vampire = new Vampire(height, length);
        System.out.println(vampire.toString());
        for (int i = 0; i < vampires; i++) {
            vampire.setRandomCoordinates(height, length);
            System.out.println(vampire.toString());
        }
        System.out.println();

        char[] command = scan.nextLine().toCharArray();
        for(char c: command){
            player.setCoordinates(c);
        }
        System.out.println();
    }

    public void run(){
        while(this.moves > 0){
            System.out.println(moves);
            this.moves--;
            System.out.println();
            positions();
        }
    }
}
