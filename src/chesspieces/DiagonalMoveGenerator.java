package chesspieces;

import java.util.ArrayList;
import java.util.List;

import boardbasics.Board;
import boardbasics.Coord;
import boardbasics.Player;
import boardbasics.Square;
import chess.ChessBoard;
import chess.ChessSquare;

public class DiagonalMoveGenerator implements MoveGenerator {

	@Override
	public List<ChessSquare> getMoves(ChessBoard board, Coord pos, Player owner) {
		List<ChessSquare> moves = moveUpRight(board, pos, owner);
		moves.addAll(moveUpLeft(board, pos, owner));
		moves.addAll(moveDownRight(board, pos, owner));
		moves.addAll(moveDownLeft(board, pos, owner));
		return moves;
	}
	
	private List<ChessSquare> moveUpRight(ChessBoard board, Coord pos, Player owner) {
		int x = pos.getX(), y = pos.getY();
		List<ChessSquare> moves = new ArrayList<ChessSquare>();
		for (int i = x+1, j = y+1; i < 8 && j < 8; i++, j++) {
			if (!board.getSquare(i, j).hasAPiece()) {
				moves.add(board.getSquare(i, j));
			}
			else {
				if (!owner.equals(board.getSquare(i, j).getContent().getOwner()))
					moves.add(board.getSquare(i, j));
				break;
			}
		}
		return moves;
	}

	private List<ChessSquare> moveUpLeft(ChessBoard board, Coord pos, Player owner) {
		int x = pos.getX(), y = pos.getY();
		List<ChessSquare> moves = new ArrayList<ChessSquare>();
		for (int i = x+1, j = y-1; i < 8 && j >= 0; i++, j--) {
			if (!board.getSquare(i, j).hasAPiece()) {
				moves.add(board.getSquare(i, j));
			}
			else {
				if (!owner.equals(board.getSquare(i, j).getContent().getOwner()))
					moves.add(board.getSquare(i, j));
				break;
			}
		}
		return moves;
	}

	private List<ChessSquare> moveDownRight(ChessBoard board, Coord pos, Player owner) {
		int x = pos.getX(), y = pos.getY();
		List<ChessSquare> moves = new ArrayList<ChessSquare>();
		for (int i = x-1, j = y+1; i >= 0 && j < 8; i--, j++) {
			if (!board.getSquare(i, j).hasAPiece()) {
				moves.add(board.getSquare(i, j));
			}
			else {
				if (!owner.equals(board.getSquare(i, j).getContent().getOwner()))
					moves.add(board.getSquare(i, j));
				break;
			}
		}
		return moves;
	}

	private List<ChessSquare> moveDownLeft(ChessBoard board, Coord pos, Player owner) {
		int x = pos.getX(), y = pos.getY();
		List<ChessSquare> moves = new ArrayList<ChessSquare>();
		for (int i = x-1, j = y-1; i >= 0 && j >= 0; i--, j--) {
			if (!board.getSquare(i, j).hasAPiece()) {
				moves.add(board.getSquare(i, j));
			}
			else {
				if (!owner.equals(board.getSquare(i, j).getContent().getOwner()))
					moves.add(board.getSquare(i, j));
				break;
			}
		}
		return moves;
	}
}
