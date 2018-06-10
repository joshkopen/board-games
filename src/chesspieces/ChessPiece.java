package chesspieces;

import java.util.ArrayList;
import java.util.List;

import boardbasics.Board;
import boardbasics.Coord;
import boardbasics.Piece;
import boardbasics.Player;
import boardbasics.Square;
import chess.ChessBoard;
import chess.ChessSquare;

public abstract class ChessPiece extends Piece {

	public ChessPiece(Player owner, String value) {
		super(owner, value);
	}

	public abstract List<ChessSquare> getMoves(ChessBoard cb, Coord pos);
	
	/*
	 * The method used by King and Knight because
	 * move generators weren't applicable to them
	 * like for the other non-pawn pieces
	 */
	protected List<ChessSquare> getMoves(ChessBoard cb, int [][] potentialMoves) {
		List<ChessSquare> moves = new ArrayList<ChessSquare>();
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
