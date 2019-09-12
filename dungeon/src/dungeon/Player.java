package dungeon;

public class Player extends Character {
    public Player(){
        super(0, 0);
    }

    @Override
    public char boardChar(){
        return 'v';
    }

    public void setCoordinates(char c, int height, int length) {
        if(c == 'w'){
            goUp();
        } else if(c == 's'){
            goDown(height);
        } else if(c == 'd'){
            goRight(length);
        } else if(c == 'a'){
            goLeft();
        }
    }

    //  command - w
    public void goUp() {
        if(x > 0){
            this.x--;
        }
    }
    //  command - s
    public void goDown(int height) {
        if(x < height){
            x++;
        }
    }
    //  command - d
    public void goRight(int length) {
        if(y < length){
            y++;
        }
    }
    //  command - a
    public void goLeft() {
        if(y > 0){
            y--;
        }
    }

    @Override
    public void move(int newX, int newY) {
    }

    @Override
    public String toString(){
        return "@ " + super.toString();
    }
}
