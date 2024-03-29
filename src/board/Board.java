package board;

import board.Tile;
import javafx.util.Pair;
import pieces.*;

import java.util.*;

public class Board {

    private final List<Tile> chessBoard;
    private final Collection<Piece> whitePieces;
    private final Collection<Piece> blackPieces;

    private Board(Builder builder){
        this.chessBoard = createChessBoard(builder);
        this.whitePieces = calculatePieces(chessBoard, Alliance.WHITE);
        this.blackPieces = calculatePieces(chessBoard, Alliance.BLACK);
    }

    private static List<Tile> createChessBoard(final Builder builder) {
        List<Tile> tiles = new ArrayList<>();
        for (int i = 0; i < 8; i++){
            for (int j = 0; j < 8; j++){
                tiles.add(new Tile(i, j, builder.config.get(new Pair(i, j))));
            }

        }
        return tiles;
    }

    private Collection<Piece> calculatePieces(final List<Tile> chessBoard, final Alliance color)
    {
        final List<Piece> pieces = new ArrayList<>();
        for (Tile tile : chessBoard) {
            if (!tile.isEmpty() && tile.getPiece().getAlliance() == color)
                pieces.add(tile.getPiece());
        }
        return pieces;
    }

    public static Board createNewBoard() {
        final Builder builder = new Builder();

        builder.setPiece(new Rook(0,0, Alliance.BLACK));
        builder.setPiece(new Rook(0,7, Alliance.BLACK));
        builder.setPiece(new Knight(0,1, Alliance.BLACK));
        builder.setPiece(new Knight(0,6, Alliance.BLACK));
        builder.setPiece(new Bishop(0,2, Alliance.BLACK));
        builder.setPiece(new Bishop(0,5, Alliance.BLACK));
        builder.setPiece(new Queen(0,3, Alliance.BLACK));
        builder.setPiece(new King(0,4, Alliance.BLACK));
        for (int i = 0; i < 8; i++) {
            builder.setPiece(new Pawn(1, i, Alliance.BLACK));
        }

        builder.setPiece(new Rook(7,0, Alliance.WHITE));
        builder.setPiece(new Rook(7,7, Alliance.WHITE));
        builder.setPiece(new Knight(7,1, Alliance.WHITE));
        builder.setPiece(new Knight(7,6, Alliance.WHITE));
        builder.setPiece(new Bishop(7,2, Alliance.WHITE));
        builder.setPiece(new Bishop(7,5, Alliance.WHITE));
        builder.setPiece(new Queen(7,3, Alliance.WHITE));
        builder.setPiece(new King(7,4, Alliance.WHITE));
        for (int i = 0; i < 8; i++) {
            builder.setPiece(new Pawn(6, i, Alliance.WHITE));
        }

        builder.setCurrentPlayer(Alliance.WHITE);
        return builder.build();

    }

    public Tile getTile(int x, int y)
    {
        return chessBoard.get(x * 8 + y);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                String tile = chessBoard.get(i * 8 + j).toString();
                sb.append(tile);
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public static class Builder {
        Map<Pair<Integer, Integer>, Piece> config;
        Alliance currentPlayer;

        public Builder(){
            config = new HashMap<>();
        }

        public Builder setPiece(final Piece piece){
            this.config.put(piece.getPosition(), piece);
            return this;
        }

        public Builder setCurrentPlayer(final Alliance currentPlayer){
            this.currentPlayer = currentPlayer;
            return this;
        }

        public Board build(){
            return new Board(this);
        }
    }
}
