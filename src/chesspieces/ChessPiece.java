package chesspieces;

import java.util.ArrayList;
import java.util.List;

import boardbasics.Board;
import boardbasics.Coord;
import boardbasics.Piece;
import boardbasics.Player;
import boardbasics.Square;
import chess.ChessBoard;

public abstract class ChessPiece extends Piece {

	public ChessPiece(Player owner, String value) {
		super(owner, value);
	}

	public abstract List<Square> getMoves(ChessBoard cb, Coord pos);
	
	protected List<Square> getMoves(ChessBoard cb, int [][] potentialMoves) {
		List<Square> moves = new ArrayList<Square>();
		for (int i = 0; i < potentialMoves.length; i++) {
			if (cb.getSquare(potentialMoves[i][0], potentialMoves[i][1]) != null) {
				if (!cb.getSquare(potentialMoves[i][0], potentialMoves[i][1]).hasAPiece()) {
					moves.add(cb.getSquare(potentialMoves[i][0], potentialMoves[i][1]));
				} else if (!cb.getSquare(potentialMoves[i][0], potentialMoves[i][1]).getContent().getOwner().equals(getOwner())) {
					moves.add(cb.getSquare(potentialMoves[i][0], potentialMoves[i][1]));
				}
			}
		}
		return moves;
	}

}
