package chesspieces;

import java.util.List;

import boardbasics.Board;
import boardbasics.Coord;
import boardbasics.Player;
import boardbasics.Square;
import chess.ChessBoard;
import chess.ChessSquare;

public class Bishop extends ChessPiece {

	public Bishop(Player owner, String value) {
		super(owner, value);
	}

	@Override
	public List<ChessSquare> getMoves(ChessBoard cb, Coord pos) {
		MoveGenerator mg = new DiagonalMoveGenerator();
		return mg.getMoves(cb, pos, getOwner());
	}

	@Override
	public String getTextRepresentation() {
		return "bish";
	}

}
