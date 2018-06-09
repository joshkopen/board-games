package chess;

import boardbasics.Board;

/*The main point of this class is to add En Passant 
 * functionality. The current plan is to do this
 * by adding "ghost pieces" which is when a pawn
 * moves two squares and leaves behind a ghost
 * piece that only other pawns can capture.
 * The board will remove the ghost piece
 * after the next move is made as is the
 * way En Passant functions.
 */

public class ChessBoard extends Board{

	public ChessBoard(int height, int width) {
		super(height, width);
	}

}
