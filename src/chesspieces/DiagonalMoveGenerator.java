package chesspieces;

import java.util.ArrayList;
import java.util.List;

import boardbasics.Board;
import boardbasics.Coord;
import boardbasics.Player;
import boardbasics.Square;

public class DiagonalMoveGenerator implements MoveGenerator {

	@Override
	public List<Square> getMoves(Board board, Coord pos, Player owner) {
		List<Square> moves = moveUpRight(board, pos, owner);
		moves.addAll(moveUpLeft(board, pos, owner));
		moves.addAll(moveDownRight(board, pos, owner));
		moves.addAll(moveDownLeft(board, pos, owner));
		return moves;
	}
	
	private List<Square> moveUpRight(Board board, Coord pos, Player owner) {
		int x = pos.getX(), y = pos.getY();
		List<Square> moves = new ArrayList<Square>();
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

	private List<Square> moveUpLeft(Board board, Coord pos, Player owner) {
		int x = pos.getX(), y = pos.getY();
		List<Square> moves = new ArrayList<Square>();
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

	private List<Square> moveDownRight(Board board, Coord pos, Player owner) {
		int x = pos.getX(), y = pos.getY();
		List<Square> moves = new ArrayList<Square>();
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

	private List<Square> moveDownLeft(Board board, Coord pos, Player owner) {
		int x = pos.getX(), y = pos.getY();
		List<Square> moves = new ArrayList<Square>();
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
