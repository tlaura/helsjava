package dungeon;

public class Player extends Position {
    public Player(){
        super(0, 0);
    }

    @Override
    public void move(int newX, int newY) {
        x = newX;
        y = newY;
    }

    @Override
    public String toString(){
        return "@ " + super.toString();
    }
}
