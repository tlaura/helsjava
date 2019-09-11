package dungeon;

import java.util.Random;

public class Vampire {
    private int height, length, x, y;

    public Vampire(int height, int length){
        this.height = height;
        this.length = length;
        this.x = new Random().nextInt(height);
        this.y = new Random().nextInt(length);
    }

    public void setRandomCoordinates(int height, int length) {
        this.x = new Random().nextInt(height);
        this.y = new Random().nextInt(length);
    }

    @Override
    public String toString(){
        return "v " + this.x + " " + this.y;
    }
}
