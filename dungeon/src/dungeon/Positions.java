package dungeon;

public class Positions {
    //    coordinates
    protected int length, height;
    private int x, y;

    public Positions(int height, int length){
        this.height = height;
        this.length = length;
        this.x = 0;
        this.y = 0;
    }

    @Override
    public String toString(){
        return this.x + " " + this.y;
    }
}
