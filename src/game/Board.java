package game;

import java.util.ArrayList;
import java.util.List;

class Board {
    private List<EPlayer> board;
    static int NoMove = -1;

    Board(List<EPlayer> board) {
        this.board = new ArrayList<>(board);
    }

    Board(List<EPlayer> board, int position, EPlayer player) {
        this.board = new ArrayList<>(board);
        this.board.set(position, player);
    }

    List<EPlayer> getBoard() {
        return this.board;
    }

    int getBestMoveFor(EPlayer player) {
        int winningMove = findWinningMove(player);
        if(findWinningMove(player) != NoMove) {
            return winningMove;
        }

        return findFirstPossibleMove();
    }


    EPlayer getWinner() {
        for(int round = 0; round < 9; round = round + 3) {
            if (!isEmpty(round, round + 1, round + 2) && hasTheSameValue(round, round+1, round+2))
                return board.get(round);

        }
        return EPlayer.EMPTY;
    }

    private int findWinningMove(EPlayer player) {
        for (int move = 0; move < 9; move++) {
            if (board.get(move) == EPlayer.EMPTY) {
                Game game = new Game(this.board, move, player);
                if (game.board.getWinner() == player)
                    return move;
            }
        }

        return NoMove;
    }

    private int findFirstPossibleMove() {
        for (int move = 0; move < 9; move++) {
            if (board.get(move) == EPlayer.EMPTY)
                return move;
        }

        return NoMove;
    }

    private boolean isEmpty(int first, int second, int third) {
       return board.get(first) == EPlayer.EMPTY || board.get(second) == EPlayer.EMPTY || board.get(third) == EPlayer.EMPTY;
    }

    private boolean hasTheSameValue(int first, int second, int third) {
        return board.get(first) == board.get(second) && board.get(second) == board.get(third);
    }
}
