package chesspieces;

import boardbasics.Player;

public abstract class ChessPieceFirstMove extends ChessPiece {
	
	private boolean hasMoved;
	
	public ChessPieceFirstMove(Player owner, String value) {
		super(owner, value);
		hasMoved = false;
	}

	protected boolean getHasMoved() {
		return hasMoved;
	}
	
	protected void isMoving() {
		hasMoved = true;
	}
}
