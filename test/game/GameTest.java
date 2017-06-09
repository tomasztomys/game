package game;

import static org.junit.Assert.*;

import org.junit.Test;

import java.util.Arrays;

public class GameTest {
    @Test
    public void testDefaultMove() {
        Game game = new Game(Arrays.asList(Game.Player.X,Game.Player.O,Game.Player.X,Game.Player.O,Game.Player.X,Game.Player.EMPTY,Game.Player.O,Game.Player.X,Game.Player.O));
        assertEquals(5, game.bestMoveFor(Game.Player.X));

        game = new Game(Arrays.asList(Game.Player.X,Game.Player.O,Game.Player.X,Game.Player.O,Game.Player.X,Game.Player.O,Game.Player.O,Game.Player.X,Game.Player.EMPTY));
        assertEquals(8, game.bestMoveFor(Game.Player.O));

        game = new Game(Arrays.asList(Game.Player.EMPTY,Game.Player.EMPTY,Game.Player.EMPTY,Game.Player.EMPTY,Game.Player.EMPTY,Game.Player.EMPTY,Game.Player.EMPTY,Game.Player.EMPTY,Game.Player.EMPTY));
        assertEquals(0, game.bestMoveFor(Game.Player.X));

        game = new Game(Arrays.asList(Game.Player.X,Game.Player.X,Game.Player.X,Game.Player.X,Game.Player.X,Game.Player.X,Game.Player.X,Game.Player.X,Game.Player.X));
        assertEquals(Game.NoMove, game.bestMoveFor(Game.Player.X));
    }

    @Test
    public void testFindWinningMove() {
        Game game = new Game(Arrays.asList(Game.Player.X,Game.Player.O,Game.Player.EMPTY, Game.Player.X,Game.Player.X,Game.Player.EMPTY,Game.Player.O,Game.Player.O,Game.Player.X));
        assertEquals(5, game.bestMoveFor(Game.Player.X));
    }

    @Test
    public void testWinConditions() {
        Game game = new Game(Arrays.asList(Game.Player.EMPTY,Game.Player.EMPTY,Game.Player.EMPTY,Game.Player.X,Game.Player.X,Game.Player.X,Game.Player.EMPTY,Game.Player.EMPTY,Game.Player.EMPTY));
        assertEquals(Game.Player.X, game.winner());
    }
}