import java.util.List;

public abstract class Piece {

    protected final int x;
    protected final int y;
    protected final Alliance color;

    Piece(final int x, final int y, final Alliance color){
        this.x = x;
        this.y = y;
        this.color = color;
    }

    public Alliance getAlliance(){
        return color;
    }

    public abstract List<Move> checkMoves(final Board board);
}
