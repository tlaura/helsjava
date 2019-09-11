package dungeon;

import java.util.Random;

public class Vampire extends Character {
    public Vampire(int x, int y){
        super(x, y);
    }

    public void setRandomCoordinates(int height, int length) {
        this.x = new Random().nextInt(height);
        this.y = new Random().nextInt(length);
    }

    @Override
    public void moveTo(int newX, int newY) {}

    @Override
    public String toString(){
        return "v " + super.toString();
    }
}
