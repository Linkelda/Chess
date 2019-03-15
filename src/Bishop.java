import java.util.ArrayList;
import java.util.List;

public class Bishop extends Piece {

    Bishop(final int x, final int y, final Alliance color){
        super(x, y, color);
    }

    @Override
    public List<Move> checkMoves(Board board) {
        List<Move> moves = new ArrayList<>();
        // TODO : factorize
        for (int i = x, j = y; Tile.isValidCoordinate(i , j); i++, j++) {
            final Tile destination = board.getTile(i, j);
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
        for (int i = x, j = y; Tile.isValidCoordinate(i , j); i--, j++) {
            final Tile destination = board.getTile(i, j);
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
        for (int i = x, j = y; Tile.isValidCoordinate(i , j); i++, j--) {
            final Tile destination = board.getTile(i, j);
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
        for (int i = x, j = y; Tile.isValidCoordinate(i , j); i--, j--) {
            final Tile destination = board.getTile(i, j);
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
