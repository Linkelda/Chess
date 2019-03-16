package board;

import pieces.Piece;

public abstract class Move {

    final Board board;
    final Piece movedPiece;
    final int x;
    final int y;

    protected Move(final Board board, final Piece movedPiece, final int x, final int y){
        this.board = board;
        this.movedPiece = movedPiece;
        this.x = x;
        this.y = y;
    }

    public static final class SimpleMove extends Move {
        public SimpleMove(final Board board, final Piece movedPiece, final int x, final int y) {
            super(board, movedPiece, x, y);
        }

    }

    public static final class AttackMove extends Move {

        private final Piece attackedPiece;
        public AttackMove(final Board board, final Piece movedPiece, final int x, final int y, Piece attackedPiece) {
            super(board, movedPiece, x, y);
            this.attackedPiece = attackedPiece;
        }
    }
}
