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

    public void goUp() {  //  command - w
        if(x > 0){
            this.x--;
        }
    }

    public void goDown(int height) { //  command - s
        if(x < height){
            x++;
        }
    }

    public void goLeft() {  //  command - a
        if(y > 0){
            y--;
        }
    }

    public void goRight(int length) {  //  command - d
        if(y < length){
            y++;
        }
    }

    @Override
    public String toString(){
        return "@ " + super.toString();
    }
}
