package dungeon;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Dungeon {
    Scanner scan = new Scanner(System.in);
    private Random random = new Random();
    public int height, length, vampires, moves;
    private boolean vampiresMove; // if true vampires change position
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
        this.vampireList = new ArrayList<>();
        for (int i = 0; i < vampires; i++) {
//            if vampiresMove is false
            vampireList.add(new Vampire(random.nextInt(height), random.nextInt(height)));
        }
        this.board = setBoard();
    }

//  (0, 0) starting position not allowed or place is taken - move is not executed
    public void startingPositionVampires(){
        for (Vampire v: vampireList){
            while(true){
                int x = random.nextInt(height);
                int y = random.nextInt(length);
                if(!(x == 0 && y == 0) && !(isPlaceTaken(x, y))){
                    v.setX(x);
                    v.setY(y);
                    break;
                }
            }
        }
    }

//    vampires cannot be at the same position
    public boolean isPlaceTaken(int x, int y){
        for(Vampire v: vampireList){
            int xPos = v.getX();
            int yPos = v.getY();

            if(xPos == x && yPos == y){
                return true;
            }
         }
        return false;
    }

    public char[][] setBoard() {
        char[][] board = new char[height][length];
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                board[row][col] += '.';
                for (Vampire v: vampireList) {
                    if (row == v.getX() && col == v.getY()) {
                        board[row][col] = 'v';
                    }
                }
                if(row == player.getX() && col == player.getY()){
                    board[row][col] = '@';
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

    public void positions(){
        System.out.println(player.toString());
        for (Vampire v: vampireList) {
            System.out.println(v.toString());
        }
    }

//    set moves on board
    public void move(){
        char[] command = scan.nextLine().toCharArray();
        for(char c: command){
            player.setCoordinates(c, height, length);
        }
        player.move(player.getX(), player.getY());
        playerGotVampire();
        board = setBoard();
    }

//    if player and vampire same position remove vampire
    public void playerGotVampire(){
        ArrayList<Vampire> toBeRemoved = new ArrayList<>();
        for (Vampire v: vampireList){
            if(v.getX() == player.getX() && v.getY() == player.getY()) {
                toBeRemoved.add(v);
            }
        }
        vampireList.removeAll(toBeRemoved);
    }

    public void run(){
        while(this.moves > 0){
            if(vampiresMove){
                startingPositionVampires();
            }
            System.out.println(moves);
            System.out.println();
            positions();
            System.out.println();
            printBoard();
            System.out.println();
            move();
            this.moves--;
        }
    }
}
