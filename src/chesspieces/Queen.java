package chesspieces;

import java.util.List;

import boardbasics.Board;
import boardbasics.Coord;
import boardbasics.Player;
import boardbasics.Square;
import chess.ChessBoard;
import chess.ChessSquare;

public class Queen extends ChessPiece{

	public Queen(Player owner, String value) {
		super(owner, value);
	}

	@Override
	public List<ChessSquare> getMoves(ChessBoard cb, Coord pos) {
		MoveGenerator mg1 = new DiagonalMoveGenerator();
		MoveGenerator mg2 = new StraightLineMoveGenerator();
		List<ChessSquare> moves = mg1.getMoves(cb, pos, getOwner());
		moves.addAll(mg2.getMoves(cb, pos, getOwner()));
		return moves;
	}

	@Override
	public String getTextRepresentation() {
		return "queen";
	}

}
