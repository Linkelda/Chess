package pieces;

import board.Alliance;
import board.Board;
import board.Move;
import board.Tile;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

import board.Move.*;

public class Knight extends Piece {

    private final List<Pair<Integer, Integer>> possibilities;
    Knight(final int x, final int y, final Alliance color){
        super(x, y, color);
        possibilities = new ArrayList<>();
        possibilities.add(new Pair(-2, -1));
        possibilities.add(new Pair(-1, -2));
        possibilities.add(new Pair(2, -1));
        possibilities.add(new Pair(1, -2));
        possibilities.add(new Pair(-2, 1));
        possibilities.add(new Pair(-1, 2));
        possibilities.add(new Pair(2, 1));
        possibilities.add(new Pair(1, 2));
    }

    @Override
    public List<Move> checkMoves(final Board board){
        List<Move> moves = new ArrayList<>();
        for (Pair<Integer, Integer> possibility : possibilities) {

            final int x_ = possibility.getKey() + x;
            final int y_ = possibility.getValue() + y;

            if (Tile.isValidCoordinate(x_, y_)) {

                final Tile destination = board.getTile(x_, y_);
                if (destination.isEmpty()) {
                    moves.add(new SimpleMove(board, this, x_, y_));
                } else if (destination.getPiece().getAlliance() != color) {
                    moves.add(new AttackMove(board, this, x_, y_, destination.getPiece()));
                }
            }
        }
        return moves;
    }
}
