package dungeon;

import java.util.Random;

public class Vampire extends Character {
    public Vampire(int x, int y){
        super(x, y);
    }

    @Override
    public char boardChar(){
        return '@';
    }

    @Override
    public void move(int newX, int newY) {}

    @Override
    public String toString(){
        return "v " + super.toString();
    }
}
