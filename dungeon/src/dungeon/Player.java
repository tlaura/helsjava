package dungeon;

public class Player {
    private int height, length, x, y;

    public Player(int height, int length){
        this.height = height;
        this.length = length;
        this.x = 0;
        this.y = 0;
    }

    public void setCoordinates(char c) {
        if(c == 'w'){
            goUp();
        } else if(c == 's'){
            goDown();
        } else if(c == 'd'){
            goRight();
        } else if(c == 'a'){
            goLeft();
        }
    }

    //  command - w
    public void goUp() {
        if(this.x > 0){
            this.x--;
        }
    }

    //  command - s
    public void goDown() {
        if(this.x < height){
            this.x++;
        }
    }

    //  command - d
    public void goRight() {
        if(this.y < length){
            this.y++;
        }
    }

    //  command - a
    public void goLeft() {
        if(this.y > 0){
            this.y--;
        }
    }

    @Override
    public String toString(){
        return "@ " + this.x + " " + this.y;
    }
}
