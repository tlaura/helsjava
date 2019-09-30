package dungeon;

public abstract class Position {
    protected int x, y;

    public Position(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX() { return x; }
    public int getY() {
        return y;
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

    protected abstract void move(int newX, int newY);

    @Override
    public String toString(){
        return this.x + " " + this.y;
    }
}
