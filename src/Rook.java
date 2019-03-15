import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

public class Rook extends Piece {

    Rook(final int x, final int y, final Alliance color){
        super(x, y, color);
    }
    @Override
    public List<Move> checkMoves(Board board) {
        List<Move> moves = new ArrayList<>();
        // TODO : factorize
        for (int i = x; Tile.isValidCoordinate(i , y); i++) {
            final Tile destination = board.getTile(i, y);
            if (destination.isEmpty()) {
                moves.add(new Move());
            }
            else {
                final Piece p = destination.getPiece();
                if (p.getAlliance() != this.color)
                    moves.add(new Move());
                break;
            }
        }
        for (int i = x; Tile.isValidCoordinate(i , y); i--) {
            final Tile destination = board.getTile(i, y);
            if (destination.isEmpty()) {
                moves.add(new Move());
            }
            else {
                final Piece p = destination.getPiece();
                if (p.getAlliance() != this.color)
                    moves.add(new Move());
                break;
            }
        }
        for (int i = y; Tile.isValidCoordinate(x , i); i++) {
            final Tile destination = board.getTile(x, i);
            if (destination.isEmpty()) {
                moves.add(new Move());
            }
            else {
                final Piece p = destination.getPiece();
                if (p.getAlliance() != this.color)
                    moves.add(new Move());
                break;
            }
        }
        for (int i = y; Tile.isValidCoordinate(x , i); i--) {
            final Tile destination = board.getTile(x, i);
            if (destination.isEmpty()) {
                moves.add(new Move());
            }
            else {
                final Piece p = destination.getPiece();
                if (p.getAlliance() != this.color)
                    moves.add(new Move());
                break;
            }
        }
        return moves;
    }
}
