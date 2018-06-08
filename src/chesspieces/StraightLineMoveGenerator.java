package chesspieces;

import java.util.ArrayList;
import java.util.List;

import boardbasics.Board;
import boardbasics.Coord;
import boardbasics.Player;
import boardbasics.Square;

public class StraightLineMoveGenerator implements MoveGenerator{

		
	@Override
	public List<Square> getMoves(Board board, Coord pos, Player owner) {
		List<Square> moves = movingUp(board, pos, owner);
		moves.addAll(movingDown(board, pos, owner));
		moves.addAll(movingRight(board, pos, owner));
		moves.addAll(movingLeft(board, pos, owner));
		return moves;
	}
	
	private List<Square> movingUp(Board board, Coord pos, Player owner) {
		int x = pos.getX(), y = pos.getY();
		List<Square> moves = new ArrayList<Square>();
		
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
	
	private List<Square> movingDown(Board board, Coord pos, Player owner) {
		int x = pos.getX(), y = pos.getY();
		List<Square> moves = new ArrayList<Square>();
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
	
	private List<Square> movingRight(Board board, Coord pos, Player owner) {
		int x = pos.getX(), y = pos.getY();
		List<Square> moves = new ArrayList<Square>();
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
	
	private List<Square> movingLeft(Board board, Coord pos, Player owner) {
		int x = pos.getX(), y = pos.getY();
		List<Square> moves = new ArrayList<Square>();
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

	
