package chesspieces;

import java.util.List;

import boardbasics.Board;
import boardbasics.Coord;
import boardbasics.Player;
import boardbasics.Square;

public interface MoveGenerator {

	public List<Square> getMoves(Board board, Coord pos, Player owner);
}
