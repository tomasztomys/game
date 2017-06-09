package game;

import java.util.ArrayList;
import java.util.List;

public class Game {
    public static int NoMove = -1;
    public enum Player { X, O, EMPTY }

    public List<Player> board;

    public Game(List<Player> board) {this.board = board;}

    public Game(List<Player> board, int position, Player player) {
        this.board = new ArrayList<>(board);
        this.board.set(position, player);
    }

    public int bestMoveFor(Player player) {
        for (int move = 0; move < 9; move++) {
            if (board.get(move) == Player.EMPTY) {
                Game game = play(move, player);
                if (game.winner() == player)
                    return move;
            }
        }

        for (int move = 0; move < 9; move++) {
            if (board.get(move) == Player.EMPTY)
                return move;
        }
        return NoMove;
    }

    public Game play(int i, Player player) {
        return new Game(this.board, i, player);
    }

    public Player winner() {
        for(int round = 0; round < 3; round++) {
            if (board.get(round * 3) != Player.EMPTY
                    && board.get(round * 3) == board.get(round * 3 + 1)
                    && board.get(round * 3 + 1) == board.get(round * 3 + 2)
                    ) 
                return board.get(round * 3);

        }
        return Player.EMPTY;
    }
}
