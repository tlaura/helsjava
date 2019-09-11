import dungeon.Dungeon;

public class Main {
    public static void main(String[] args) {
        Dungeon game = new Dungeon(10, 10, 5, 3, false);
        game.run();
    }
}
