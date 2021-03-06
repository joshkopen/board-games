package chesspieces;

import java.util.List;

import boardbasics.Board;
import boardbasics.Coord;
import boardbasics.Player;
import boardbasics.Square;

public class Rook extends ChessPieceFirstMove {

	public Rook(Player owner, String value) {
		super(owner, value);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Square> getMoves(Board cb, Coord pos) {
		isMoving();
		MoveGenerator mg = new StraightLineMoveGenerator();
		return mg.getMoves(cb, pos, getOwner());
	}

	@Override
	public String getTextRepresentation() {
		
		return "rook";
	}

}
