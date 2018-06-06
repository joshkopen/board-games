package tictactoe;

import boardbasics.Piece;
import boardbasics.Player;

public class TicTacToePiece extends Piece {
	
	private String pieceString;

	public TicTacToePiece(Player owner, String value) {
		super(owner, value);
		pieceString = setUpPieceString();
	}

	private String setUpPieceString () {
		if (getOwner().getNum() == 1)
			return "X";
		return "Y";
	}
	@Override
	public String getTextRepresentation() {
		// TODO Auto-generated method stub
		return null;
	}

}
