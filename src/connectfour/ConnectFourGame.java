package connectfour;

import boardbasics.Board;
import boardbasics.Game;
import boardbasics.Piece;

public class ConnectFourGame extends Game implements ConnectFourGameAccess {
	
	private static final int XCONNECT4 = 7;
	private static final int YCONNECT4 = 6;
	
	public ConnectFourGame(String title) {
		setTitle(title);
		setMoveNum(0);
		setBoard(generateBoard());
	}
	
	public ConnectFourGame() {
		this("A friendly game between friends");
	}
	
	private Board generateBoard() {
		return new Board(XCONNECT4, YCONNECT4);
	}
	
	@Override
	public boolean placePiece(int x, Piece content) {
		for (int i = 0; i < getBoard().getYMax(); i++) {
			if (!getBoard().getSquare(x, i).hasAPiece()) {
				System.out.println("x: " + x);
				System.out.println("i: " + i);
				return placePiece(x, i, content);
			}
		}
		return false;
	}
	
	public int getRectangleNum(int x) {
		for (int i = 1; i <= getBoard().getYMax(); i++) {
			if (!getBoard().getSquare(x, i).hasAPiece()) {
				return getBoard().getYMax() - i;
			}
		}
		return -1;
	}

	@Override
	public boolean checkWin() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean checkDraw() {
		// TODO Auto-generated method stub
		return false;
	}

}
