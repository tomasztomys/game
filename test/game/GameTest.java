package game;

import static org.junit.Assert.*;

import org.junit.Test;

import java.util.Arrays;

public class GameTest {
    @Test
    public void testDefaultMove() {
        Game game = new Game(Arrays.asList(EPlayer.X,EPlayer.O,EPlayer.X,EPlayer.O,EPlayer.X,EPlayer.EMPTY,EPlayer.O,EPlayer.X,EPlayer.O));
        assertEquals(5, game.getBestMoveFor(EPlayer.X));

        game = new Game(Arrays.asList(EPlayer.X,EPlayer.O,EPlayer.X,EPlayer.O,EPlayer.X,EPlayer.O,EPlayer.O,EPlayer.X,EPlayer.EMPTY));
        assertEquals(8, game.getBestMoveFor(EPlayer.O));

        game = new Game(Arrays.asList(EPlayer.EMPTY,EPlayer.EMPTY,EPlayer.EMPTY,EPlayer.EMPTY,EPlayer.EMPTY,EPlayer.EMPTY,EPlayer.EMPTY,EPlayer.EMPTY,EPlayer.EMPTY));
        assertEquals(0, game.getBestMoveFor(EPlayer.X));

        game = new Game(Arrays.asList(EPlayer.X,EPlayer.X,EPlayer.X,EPlayer.X,EPlayer.X,EPlayer.X,EPlayer.X,EPlayer.X,EPlayer.X));
        assertEquals(Board.NoMove, game.getBestMoveFor(EPlayer.X));
    }

    @Test
    public void testFindWinningMove() {
        Game game = new Game(Arrays.asList(EPlayer.X,EPlayer.O,EPlayer.EMPTY, EPlayer.X,EPlayer.X,EPlayer.EMPTY,EPlayer.O,EPlayer.O,EPlayer.X));
        assertEquals(5, game.getBestMoveFor(EPlayer.X));
    }

    @Test
    public void testWinConditions() {
        Game game = new Game(Arrays.asList(EPlayer.EMPTY,EPlayer.EMPTY,EPlayer.EMPTY,EPlayer.X,EPlayer.X,EPlayer.X,EPlayer.EMPTY,EPlayer.EMPTY,EPlayer.EMPTY));
        assertEquals(EPlayer.X, game.getWinner());
    }
}