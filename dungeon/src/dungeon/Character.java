package dungeon;

public abstract class Character {
    protected int x, y;
    protected char c;

    public Character(int x, int y){
        this.x = x;
        this.y = y;
    }

    public char boardChar(){
        return 'c';
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y){
        this.y = y;
    }

//    public abstract void setCoordinates(char c, int height, int length);

    public abstract void move(int newX, int newY);

    @Override
    public String toString(){
        return this.x + " " + this.y;
    }
}
