package chesspieces;

import java.util.List;

import boardbasics.Board;
import boardbasics.Coord;
import boardbasics.Piece;
import boardbasics.Player;
import boardbasics.Square;

public abstract class ChessPiece extends Piece {

	public ChessPiece(Player owner, String value) {
		super(owner, value);
	}

	public abstract List<Square> getMoves(Board cb, Coord pos);

}
