package board;

import pieces.Piece;

public class Tile {
    private int x;
    private int y;
    private boolean isEmpty;
    private Piece piece;

    Tile(int x, int y) {
        this.x = x;
        this.y = y;
        isEmpty = true;
        piece = null;
    }

    Tile(int x, int y, Piece piece) {
        this.x = x;
        this.y = y;
        isEmpty = piece == null;
        this.piece = piece;
    }

    public void setPiece(Piece piece){
        isEmpty = false;
        this.piece = piece;
    }

    public boolean isEmpty(){
        return isEmpty;
    }

    public Piece getPiece(){
        return piece;
    }

    public static boolean isValidCoordinate(int x, int y) {
        return x >= 0 && x < 8 && y >= 0 && y < 8;
    }

    @Override
    public String toString()
    {
        if (isEmpty)
            return "-";

        String text = piece.toString();
        return (piece.getAlliance() == Alliance.BLACK)? text.toLowerCase() : text;
    }
}
