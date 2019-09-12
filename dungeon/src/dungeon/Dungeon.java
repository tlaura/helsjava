package dungeon;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Dungeon {
    Scanner scan = new Scanner(System.in);
    private Random random = new Random();
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
        this.vampireList = new ArrayList<>();
        for (int i = 0; i < vampires; i++) {
            vampireList.add(new Vampire(random.nextInt(height), random.nextInt(length)));
        }

        this.board = setBoard();
    }

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

//    vampires cannot be at same position
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
        startingPositionVampires();
        for (Vampire v: vampireList) {
            System.out.println(v.toString());
        }
        System.out.println();
        printBoard();

        char[] command = scan.nextLine().toCharArray();
        for(char c: command){
            player.setCoordinates(c, height, length);
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
