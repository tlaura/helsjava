package dungeon;

public class Vampire extends Position {

    public Vampire(int x, int y){
        super(x, y);
    }

    @Override
    protected void move(int newX, int newY) {

    }

    @Override
    public String toString(){
        return "v " + super.toString();
    }
}
