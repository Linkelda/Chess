import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

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

    public List<Move> checkMoves(final Board board){
        for (Pair<Integer, Integer> possibility : possibilities) {
            
        }
    }
}
