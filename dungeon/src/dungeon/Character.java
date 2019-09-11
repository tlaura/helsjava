package dungeon;

public abstract class Character {
    protected int x, y;

    public Character(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public abstract void moveTo(int newX, int newY);

    @Override
    public String toString(){
        return this.x + " " + this.y;
    }
}
