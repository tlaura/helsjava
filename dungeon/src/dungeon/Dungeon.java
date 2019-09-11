package dungeon;

import java.util.Random;
import java.util.Scanner;

public class Dungeon {
    Scanner scan = new Scanner(System.in);
    private Random random;
    private int length, height, vampires, moves;
    private boolean vampiresMove;
    private Player player;
    private char[][] board;

    public Dungeon(int length, int height, int vampires, int moves, boolean vampiresMove){
        this.length = length;
        this.height = height;
        this.vampires = vampires;
        this.moves = moves;
        this.vampiresMove = vampiresMove;
        player = new Player(length, height);
        this.board = setBoard();
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
        printBoard();

        char[] command = scan.nextLine().toCharArray();
        for(char c: command){
            player.setCoordinates(c);
        }
        System.out.println();
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
