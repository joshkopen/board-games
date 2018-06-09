package chesspieces;

import java.util.ArrayList;
import java.util.List;

import boardbasics.Board;
import boardbasics.Coord;
import boardbasics.Player;
import boardbasics.Square;
import chess.ChessBoard;

public class Pawn extends ChessPieceFirstMove {

	public Pawn(Player owner, String value) {
		super(owner, value);
	}

	@Override
	public List<Square> getMoves(ChessBoard board, Coord pos) {
		List<Square> retList = new ArrayList<Square>();
		retList = forwardMoves(retList, board, pos);
		retList = captureMoves(retList, board, pos);
		isMoving();
		return retList;
	}

	private List<Square> forwardMoves(List <Square> retList, Board board, Coord pos) {
		if (!board.getSquare(pos.getX(), pos.getY() + 1).hasAPiece()) {
			retList.add(board.getSquare(pos.getX(), pos.getY() + 1));
			if (!getHasMoved()) {
				if (!board.getSquare(pos.getX(), pos.getY() + 2).hasAPiece()) {
					retList.add(board.getSquare(pos.getX(), pos.getY() + 2));
				}
			}
		}
		return retList;
	}
	
	private List<Square> captureMoves(List<Square> retList, Board board, Coord pos) {
		if (pos.getX() < 7) {
			Square toCapture = board.getSquare(pos.getX() + 1, pos.getY() + 1);
			if (toCapture.hasAPiece()) {
				if (!toCapture.getContent().getOwner().equals(getOwner())) {
					retList.add(toCapture);
				}
			}
		}
		if (pos.getX() > 0) {
			Square toCapture = board.getSquare(pos.getX() - 1, pos.getY() + 1);
			if (toCapture.hasAPiece()) {
				if (!toCapture.getContent().getOwner().equals(getOwner())) {
					retList.add(toCapture);
				}
			}
		}
		
		//have to add En passant functionality later
		return retList;
	}
	
	@Override
	public String getTextRepresentation() {
		return "p";
	}
}
