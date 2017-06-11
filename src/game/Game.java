package game;

import java.util.List;

public class Game {
    Board board;

    Game(List<EPlayer> board) {this.board = new Board(board);}

    Game(List<EPlayer> board, int position, EPlayer player) {
        this.board = new Board(board, position, player);
    }

    public Game play(int i, EPlayer player) {
        return new Game(this.board.getBoard(), i, player);
    }

    int getBestMoveFor(EPlayer player) {
        return this.board.getBestMoveFor(player);
    }

    EPlayer getWinner() {
        return this.board.getWinner();
    }
}
