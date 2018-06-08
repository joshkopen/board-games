package connectfour;

import boardbasics.Board;
import boardbasics.Piece;

public interface ConnectFourGameAccess {

	public boolean placePiece(int x, Piece content);
	public int getRectangleNum(int x);
	public boolean checkWin();
	public boolean checkDraw();
	public Board getBoard();
	public int getMoveNum();
}
