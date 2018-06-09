package chesspieces;

import java.util.List;

import boardbasics.Board;
import boardbasics.Coord;
import boardbasics.Player;
import boardbasics.Square;
import chess.ChessBoard;

public class Knight extends ChessPiece {

	public Knight(Player owner, String value) {
		super(owner, value);
	}

	@Override
	public List<Square> getMoves(ChessBoard cb, Coord pos) {
		int [][] moveArray = {{pos.getX()+2, pos.getY() + 1},
				{pos.getX() + 2, pos.getY() -1},
				{pos.getX() - 2, pos.getY() +1},
				{pos.getX() - 2, pos.getY() - 1},
				{pos.getX() + 1, pos.getY() + 2},
				{pos.getX() -1, pos.getY() + 2},
				{pos.getX() +1, pos.getY() - 2},
				{pos.getX() -1, pos.getY() -2}};
		return getMoves(cb, moveArray);
	}

	@Override
	public String getTextRepresentation() {
		return "knight";
	}

}
