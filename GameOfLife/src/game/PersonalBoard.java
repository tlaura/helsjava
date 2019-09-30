package game;

import gameoflife.GameOfLifeBoard;

public class PersonalBoard extends GameOfLifeBoard {

    public PersonalBoard(int length, int height) {
        super(length, height);
    }

    @Override
    public void turnToLiving(int x, int y) {
        if(x < getWidth() && y < getHeight()){
            getBoard()[x][y] = true;
        }
    }

    @Override
    public void turnToDead(int x, int y) {
        if(x < getWidth() && y < getHeight()){
            getBoard()[x][y] = false;
        }
    }

    @Override
    public boolean isAlive(int x, int y) {
        if(getBoard()[x][y]){
            return true;
        }
        return false;
    }

    @Override
    public void initiateRandomCells(double probabilityForEachCell) {
        
    }

    @Override
    public int getNumberOfLivingNeighbours(int x, int y) {
        return 0;
    }

    @Override
    public void manageCell(int x, int y, int livingNeighbours) {

    }
}
