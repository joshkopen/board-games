package chesspieces;

import java.util.ArrayList;
import java.util.List;

import boardbasics.Board;
import boardbasics.Coord;
import boardbasics.Player;
import boardbasics.Square;
import chess.ChessBoard;
import chess.ChessSquare;

public class StraightLineMoveGenerator implements MoveGenerator{

		
	@Override
	public List<ChessSquare> getMoves(ChessBoard board, Coord pos, Player owner) {
		List<ChessSquare> moves = movingUp(board, pos, owner);
		moves.addAll(movingDown(board, pos, owner));
		moves.addAll(movingRight(board, pos, owner));
		moves.addAll(movingLeft(board, pos, owner));
		return moves;
	}
	
	private List<ChessSquare> movingUp(ChessBoard board, Coord pos, Player owner) {
		int x = pos.getX(), y = pos.getY();
		List<ChessSquare> moves = new ArrayList<ChessSquare>();
		
		for (int i = y+1; i < 8; i++) {
			if (!board.getSquare(x, i).hasAPiece()) {
				moves.add(board.getSquare(x, i));
			}
			else {
				if (!owner.equals(board.getSquare(x, i).getContent().getOwner()))
					moves.add(board.getSquare(x, i));
				break;
			}
		}
		return moves;
	}
	
	private List<ChessSquare> movingDown(ChessBoard board, Coord pos, Player owner) {
		int x = pos.getX(), y = pos.getY();
		List<ChessSquare> moves = new ArrayList<ChessSquare>();
		for (int i = y-1; i >= 0; i--) {
			if (!board.getSquare(x, i).hasAPiece()) {
				moves.add(board.getSquare(x, i));
			}
			else {
				if (!owner.equals(board.getSquare(x, i).getContent().getOwner()))
					moves.add(board.getSquare(x, i));
				break;
			}
		}
		return moves;
	}
	
	private List<ChessSquare> movingRight(ChessBoard board, Coord pos, Player owner) {
		int x = pos.getX(), y = pos.getY();
		List<ChessSquare> moves = new ArrayList<ChessSquare>();
		for (int i = x+1; i < 8; i++) {
			if (!board.getSquare(i, y).hasAPiece()) {
				moves.add(board.getSquare(i, y));
			}
			else {
				if (!owner.equals(board.getSquare(i, y).getContent().getOwner()))
					moves.add(board.getSquare(i, y));
				break;
			}
		}
		return moves;
	}
	
	private List<ChessSquare> movingLeft(ChessBoard board, Coord pos, Player owner) {
		int x = pos.getX(), y = pos.getY();
		List<ChessSquare> moves = new ArrayList<ChessSquare>();
		for (int i = x-1; i >= 0; i--) {
			if (!board.getSquare(i, y).hasAPiece()) {
				moves.add(board.getSquare(i, y));
			}
			else {
				if (!owner.equals(board.getSquare(i, y).getContent().getOwner()))
					moves.add(board.getSquare(i, y));
				break;
			}
		}
		return moves;
	}
}

	
