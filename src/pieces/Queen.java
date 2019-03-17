package pieces;

import board.Tile;
import javafx.util.Pair;
import java.util.ArrayList;
import java.util.List;

import board.Alliance;
import board.Board;
import board.Move;

import board.Move.*;

public class Queen extends Piece {

    private final List<Pair<Integer, Integer>> possibilities;

    public Queen(final int x, final int y, final Alliance color){
        super(x, y, color);
        possibilities = new ArrayList<>();
        possibilities.add(new Pair(-1, 0));
        possibilities.add(new Pair(1, 0));
        possibilities.add(new Pair(0, -1));
        possibilities.add(new Pair(0, 1));
        possibilities.add(new Pair(-1, -1));
        possibilities.add(new Pair(-1, 1));
        possibilities.add(new Pair(1, -1));
        possibilities.add(new Pair(1, 1));
    }

    @Override
    public List<Move> checkMoves(Board board) {
        List<Move> moves = new ArrayList<>();
        for (Pair<Integer, Integer> possibility : possibilities) {
            int x_ = possibility.getKey() + x;
            int y_ = possibility.getValue() + y;
            while (Tile.isValidCoordinate(x_, y_))
            {
                final Tile destination = board.getTile(x_, y_);
                if (destination.isEmpty()) {
                    moves.add(new SimpleMove(board, this, x_, y_));
                }
                else {
                    final Piece p = destination.getPiece();
                    if (p.getAlliance() != this.color)
                        moves.add(new AttackMove(board, this, x_, y_, p));
                    break;
                }
            }
        }
        return moves;
    }
}
