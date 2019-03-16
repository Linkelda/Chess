import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

import static Move.*;

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
            if (Tile.isValidCoordinate(this.x + possibility.getKey(), this.y + possibility.getValue())) {
                final Tile destination = board.getTile(x, y);
                if (destination.isEmpty()) {
                    moves.add(new SimpleMove(board, this, x + possibility.getKey(), y + possibility.getValue()));
                } else if (destination.getPiece().getAlliance() != color) {

                }
            }
        }
        return moves;
    }
}
