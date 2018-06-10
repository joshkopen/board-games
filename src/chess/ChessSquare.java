package chess;

import java.util.List;

import boardbasics.Coord;
import boardbasics.Piece;
import boardbasics.Square;
import chesspieces.ChessPiece;

public class ChessSquare extends Square{

	public ChessSquare(int xVal, int yVal) {
		super(xVal, yVal);
	}

	public List<ChessSquare> getMoves(ChessBoard cb, Coord pos) {
		ChessPiece cp = (ChessPiece) getContent();
		return cp.getMoves(cb, pos);
	}
	
	public ChessPiece getContent() {
		return (ChessPiece) super.getContent();
	}
}
