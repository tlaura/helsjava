package game;

import gameoflife.GameOfLifeBoard;

import java.util.Random;

public class PersonalBoard extends GameOfLifeBoard {

    public PersonalBoard(int length, int height) {
        super(length, height);
    }

    @Override
    public void turnToLiving(int x, int y) {
        if(x >= 0 && x < getWidth() && y >= 0 && y < getHeight()){
            getBoard()[x][y] = true;
        }
    }

    @Override
    public void turnToDead(int x, int y) {
        if(x >= 0 && x < getWidth() && y >= 0 && y < getHeight()){
            getBoard()[x][y] = false;
        }
    }

    @Override
    public boolean isAlive(int x, int y) {
        if(x >= 0 && x < getWidth() && y >= 0 && y < getHeight()){
            if(getBoard()[x][y]){
                return true;
            }
        }
        return false;
    }

    @Override
    public void initiateRandomCells(double probabilityForEachCell) {
        Random random = new Random();
        for (int row = 0; row < getBoard().length; row++) {
            for (int col = 0; col < getBoard()[row].length; col++) {
                if(random.nextDouble() <= probabilityForEachCell && probabilityForEachCell != 0){
                    getBoard()[row][col] = true;
                } else {
                    getBoard()[row][col] = false;
                }
            }
        }
    }

    @Override
    public int getNumberOfLivingNeighbours(int x, int y) {
        int count = 0;
//        central cells
        if(x >= 0 && x < getWidth() && y >= 0 && y < getHeight()) {
            if(x != 0 && y != 0 && x != getWidth()-1 && y != getHeight()-1){
                count = countLivingByCoordinates(x, y, x-1, x+2, y-1, y+2);
            }

//       side cells
            if(x == 0 && y != 0){
                count = countLivingByCoordinates(x, y, x, x+2, y-1, y+2);
            }
            if(y == 0 && x != 0){
                count = countLivingByCoordinates(x, y, x-1, x+2, 0, 2);
            }
            if(x == getWidth()-1 && y != getHeight()-1){
                count = countLivingByCoordinates(x, y, x-1, x+1, y-1, y+2);
            }
            if(y == getHeight()-1 && x != getWidth()-1){
                count = countLivingByCoordinates(x, y, x-1,x+2, y-1, y+1);
            }

//            corner cells
            if(x == 0 && y == 0){
                if(getBoard()[0][1]){
                    count++;
                }
                if(getBoard()[1][1]) {
                    count++;
                }
                if(getBoard()[1][0]) {
                    count++;
                }
            }
            if(x == getWidth()-1 && y == 0){
                if(getBoard()[getWidth()-2][0]){
                    count++;
                }
                if(getBoard()[getWidth()-2][1]){
                    count++;
                }
                if(getBoard()[getWidth()-1][1]){
                    count++;
                }
            }
            if(x == getWidth()-1 && y == getHeight()-1){
                if(getBoard()[getWidth()-2][getHeight()-1]){
                    count++;
                }
                if(getBoard()[getWidth()-2][getHeight()-2]){
                    count++;
                }
                if(getBoard()[getWidth()-1][getHeight()-2]){
                    count++;
                }
            }
            if(x == 0 && y == getHeight()-1){
                if(getBoard()[0][getHeight()-2]){
                    count++;
                }
                if(getBoard()[1][getHeight()-2]){
                    count++;
                }
                if(getBoard()[1][getHeight()-1]){
                    count++;
                }
            }

        }

        return count;
    }


    public int countLivingByCoordinates(int x, int y, int xStart, int xEnd, int yStart, int yEnd){
        int count = 0;
        for (int xInd = xStart; xInd < xEnd; xInd++) {
            for (int yInd = yStart; yInd < yEnd; yInd++) {
                if (xInd == x && yInd == y) {
                    continue;
                }
                if (getBoard()[xInd][yInd]) {
                    count++;
                }
            }
        }
        return count;
    }

    @Override
    public void manageCell(int x, int y, int livingNeighbours) {
        if(isAlive(x, y)){
//        Every living cell dies if they have less than two living neighbours
            if(livingNeighbours < 2){
                turnToDead(x, y);
            }
//        Every living cell keeps on living during the following iteration (i.e. turn) if they have two or three living neighbours
            if(livingNeighbours == 2 || livingNeighbours == 3){
                return;
            }
//            Every living cell dies if they have more than three living neighbours
            if(livingNeighbours > 3){
                turnToDead(x, y);
            }
        } else {
//            Every dead cell is turned back to life if they have exactly three living neighbours
            if(livingNeighbours == 3){
                turnToLiving(x, y);
            }
        }



    }
}
