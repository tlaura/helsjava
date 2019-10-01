package wormgame.domain;

import wormgame.Direction;

import java.util.LinkedList;
import java.util.List;

public class Worm {
    private Direction direction;
    private LinkedList<Piece> pieces;
    private boolean isGrowing = false;

    public Worm(int originalX, int originalY, Direction originalDirection){
        this.direction = originalDirection;
        this.pieces = new LinkedList<>();
        pieces.add(new Piece(originalX, originalY));
    }

    public Direction getDirection(){
        return direction;
    }

    public void setDirection(Direction dir){
        this.direction = dir;
    }

    public int getLength(){
        return pieces.size();
    }

    public List<Piece> getPieces(){
        return pieces;
    }

    public void move(){
        if(pieces.size() < 3){
            grow();
        }
        Piece nextPiece;
        if(direction == Direction.RIGHT){
//            x++;
            nextPiece = new Piece(pieces.getLast().getX()+1, pieces.getLast().getY());
        } else if(direction == Direction.LEFT){
//            x--;
            nextPiece = new Piece(pieces.getLast().getX()-1, pieces.getLast().getY());
        } else if(direction == Direction.DOWN){
//            y++;
            nextPiece = new Piece(pieces.getLast().getX(), pieces.getLast().getY()+1);
        } else {
//            goUp = y--;
            nextPiece = new Piece(pieces.getLast().getX(), pieces.getLast().getY()-1);
        }
        if(isGrowing){
            pieces.add(nextPiece);
            isGrowing = false;
        } else {
            pieces.add(nextPiece);
            pieces.remove(0);
        }
    }

    public void grow(){
        isGrowing = true;
    }

    public boolean runsInto(Piece piece){
        for(Piece p: pieces){
            if(p.runsInto(piece)){
                return true;
            }
        }
        return false;
    }

    public boolean runsIntoItself(){
        for(Piece p: pieces){
            for(Piece piece: pieces){
                if(p == piece){
                    continue;
                }
                if(p.runsInto(piece)){
                    return true;
                }
            }
        }
        return false;
    }

}
