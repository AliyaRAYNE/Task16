import org.example.Game;
import org.example.NotRegisteredException;
import org.example.Player;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {
    @Test
    public void whenPlayerOneWin() {
        Player zhenya = new Player(1, "Женя", 150);
        Player alisa = new Player(2, "Алиса", 110);
        Game game = new Game();
        game.register(zhenya);
        game.register(alisa);
        int expected = 1;
        int actual = game.round("Женя","Алиса");
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void whenPlayerTwoWin() {
        Player zhenya = new Player(1, "Женя", 150);
        Player alisa = new Player(2, "Алиса", 170);
        Game game = new Game();
        game.register(zhenya);
        game.register(alisa);
        int expected = 2;
        int actual = game.round("Женя","Алиса");
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void whenNobodyWin() {
        Player zhenya = new Player(1, "Женя", 150);
        Player alisa = new Player(2, "Алиса", 150);
        Game game = new Game();
        game.register(zhenya);
        game.register(alisa);
        int expected = 0;
        int actual = game.round("Женя","Алиса");
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void whenPlayerOneNotExist() {
        Player zhenya  = new Player(1, "Женя", 150);
        Player alisa = new Player(2, "Алиса", 120);
        Game game = new Game();
        game.register(zhenya);
        game.register(alisa);
        Assertions.assertThrows(NotRegisteredException.class, () -> game.round("Кирилл", "Петя"));
    }
    @Test
    public void whenPlayerTwoNotExist() {
        Player zhenya = new Player(1, "Женя", 150);
        Player alisa = new Player(2, "Алиса", 120);
        Game game = new Game();
        game.register(zhenya);
        game.register(alisa);
        Assertions.assertThrows(NotRegisteredException.class, () -> game.round("Ирина", "Марина"));
    }
}

