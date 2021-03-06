package chesspieces;

import java.util.List;

import boardbasics.Board;
import boardbasics.Coord;
import boardbasics.Player;
import boardbasics.Square;

public class King extends ChessPiece {

	public King(Player owner, String value) {
		super(owner, value);
	}

	@Override
	public List<Square> getMoves(Board cb, Coord pos) {
		int [][] moveArray = {{pos.getX()+1, pos.getY()},
				{pos.getX() + 1, pos.getY() +1},
				{pos.getX() + 1, pos.getY() -1},
				{pos.getX(), pos.getY() + 1},
				{pos.getX(), pos.getY() - 1},
				{pos.getX() -1, pos.getY()},
				{pos.getX() -1, pos.getY() + 1},
				{pos.getX() -1, pos.getY() -1}};
		return getMoves(cb, moveArray);
	}

	@Override
	public String getTextRepresentation() {
		return "king";
	}

}
