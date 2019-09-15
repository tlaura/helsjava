package dungeon;

public class Vampire extends Position {

    public Vampire(int x, int y){
        super(x, y);
    }

    @Override
    public void move(int newX, int newY) {
        x = newX;
        y = newY;
    }

    @Override
    public String toString(){
        return "v " + super.toString();
    }
}
