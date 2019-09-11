package dungeon;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Dungeon {
    Scanner scan = new Scanner(System.in);
    private Random random;
    public int height, length, vampires, moves;
    private boolean vampiresMove;
    private Player player;
    private char[][] board;
    private List<Vampire> vampireList;


    public Dungeon(int height, int length,  int vampires, int moves, boolean vampiresMove){
        this.height = height;
        this.length = length;
        this.vampires = vampires;
        this.moves = moves;
        this.vampiresMove = vampiresMove;
        player = new Player();
        this.board = setBoard();
        this.vampireList = new ArrayList<>();
    }


    public void positions(){
        System.out.println(player.toString());
        for (int i = 0; i < vampires; i++) {
            Vampire vampire = new Vampire(new Random().nextInt(height), new Random().nextInt(length));
            vampireList.add(vampire);
            System.out.println(vampire.toString());
        }
        changeVampiresInSamePlace();
        System.out.println();
        printBoard();

        char[] command = scan.nextLine().toCharArray();
        for(char c: command){
            player.setCoordinates(c, height, length);
        }
        System.out.println();
    }


    public void changeVampiresInSamePlace(){
        for (int i = 1; i < vampireList.size(); i++) {
            if(vampireList.get(i).getX() == vampireList.get(i-1).getX()
                    && vampireList.get(i).getY() == vampireList.get(i-1).getY()){
                vampireList.get(i).setRandomCoordinates(height, length);
            }
        }
    }


    public char[][] setBoard(){
        char[][] board = new char[height][length];
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                if(row == player.getX() && col == player.getY()){
                    board[row][col] = '@';
                } else {
                    board[row][col] = '*';
                }
            }
        }
        return board;
    }


    public void printBoard(){
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                System.out.print(board[row][col]);
            }
            System.out.println();
        }
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
