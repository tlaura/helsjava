import dungeon.Dungeon;
import dungeon.Vampire;

public class Main {
    public static void main(String[] args) {
        Dungeon game = new Dungeon(10, 10, 3, 5, true);
        game.run();

    }
}
