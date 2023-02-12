import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {

    Player player1 = new Player(1,"Bob", 10);
    Player player2 = new Player(2,"Jack", 23);
    Player player3 = new Player(3,"Peter", 30);
    Player player4 = new Player(4,"Nick", 23);

    @Test
    public void roundFirstStrongerTest() {
        Game game = new Game();

        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);

        int expected = 1;
        int actual = game.round("Peter", "Nick");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void roundSecondStrongerTest() {
        Game game = new Game();

        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);

        int expected = 2;
        int actual = game.round("Bob", "Nick");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void roundTieTest() {
        Game game = new Game();

        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);

        int expected = 0;
        int actual = game.round("Jack", "Nick");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void roundErrorTest() {
        Game game = new Game();

        game.register(player2);
        game.register(player3);
        game.register(player4);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Bob", "Nick");
        });
    }

}
