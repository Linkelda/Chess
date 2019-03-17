package pieces;

import board.Alliance;
import board.Board;
import board.Move;
import board.Tile;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;
import board.Move.*;

public class Pawn extends Piece {

    private final List<Pair<Integer, Integer>> possibilities;
    private boolean isFirstMove;
    private int direction;

    public Pawn(final int x, final int y, final Alliance color){
        super(x, y, color);
        isFirstMove = true;
        direction = (color == Alliance.BLACK)? 1 : -1;
        possibilities = new ArrayList<>();
        possibilities.add(new Pair(1, 0));
        possibilities.add(new Pair(2, 0));
        possibilities.add(new Pair(1, -1));
        possibilities.add(new Pair(1, 1));
    }

    @Override
    public List<Move> checkMoves(Board board) {
        List<Move> moves = new ArrayList<>();
        for (Pair<Integer, Integer> possibility : possibilities) {
            final int x_ = possibility.getKey() * direction + x;
            final int y_ = possibility.getValue() + y;
            if (Tile.isValidCoordinate(x_, y_))
            {
                final Tile destination = board.getTile(x_, y_);

                if (possibility.getKey() == 2 && isFirstMove /* JUMP */) {
                    final int xMinus = direction + x;
                    if (board.getTile(xMinus, y_).isEmpty() && destination.isEmpty())
                    {
                        moves.add(new SimpleMove(board, this, x_, y_));
                    }
                }
                else if (possibility.getValue() != 0 && !destination.isEmpty())
                {
                    Piece pieceAtDestination = destination.getPiece();
                    if (pieceAtDestination.getAlliance() != color) {
                        moves.add(new AttackMove(board, this, x_, y_, pieceAtDestination));
                    }
                }
                else if (destination.isEmpty()) {
                    moves.add(new SimpleMove(board, this, x_, y_));
                }
            }
        }
        return moves;
    }
}
