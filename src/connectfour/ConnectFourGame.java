package connectfour;

import boardbasics.Board;
import boardbasics.Game;
import boardbasics.Piece;
import boardbasics.Player;

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
			if (!getBoard().getSquare(x, i-1).hasAPiece()) {
				return getBoard().getYMax() - i;
			}
		}
		return -1;
	}

	@Override
	public boolean checkWin() {
		if ((horizontalCheck()) || (verticalCheck()) || (diagonalCheck()))
			return true;
		return false;
	}
	
	private boolean verticalCheck() {
		int runningTotal = 0;
		Player currentPlayer;
		for (int i = 0; i < getBoard().getXMax(); i++) {
			currentPlayer = new Player("dummy", 3);
			for (int j = 0; j < getBoard().getYMax(); j++) {
				if (!getBoard().getSquare(i, j).hasAPiece()) {
					currentPlayer = new Player("dummy", 3);
				}
				else if (getBoard().getSquare(i, j).getContent().getOwner().equals(currentPlayer)) {
					runningTotal++;
				} else {
					currentPlayer = getBoard().getSquare(i, j).getContent().getOwner();
					runningTotal = 1;
				}
				
				if (runningTotal >= 4)
					return true;
			}
		}
		return false;
	}

	private boolean horizontalCheck() {
		int runningTotal = 0;
		Player currentPlayer;
		for (int j = 0; j < getBoard().getYMax(); j++) {
			currentPlayer = new Player("dummy", 3);
			for (int i = 0; i < getBoard().getXMax(); i++) {
				if (!getBoard().getSquare(i, j).hasAPiece()) {
					currentPlayer = new Player("dummy", 3);
				}
				else if (getBoard().getSquare(i, j).getContent().getOwner().equals(currentPlayer)) {
					runningTotal++;
				} else {
					currentPlayer = getBoard().getSquare(i, j).getContent().getOwner();
					runningTotal = 1;
				}
				
				if (runningTotal >= 4)
					return true;
			}
		}
		return false;
	}
	
	//Needed some help on this so I consulted the interwebs
	//found this very helpful stack overflow answer
	//https://stackoverflow.com/questions/32770321/connect-4-check-for-a-win-algorithm?utm_medium=organic&utm_source=google_rich_qa&utm_campaign=google_rich_qa
	private boolean diagonalCheck() {
		Player currentPlayer;
		int runningTotal = 0;
		
		for (int i = 0; i < getBoard().getXMax() - 4; i++) {
			currentPlayer = new Player("dummy", 3);
			for (int k = i, j = 0; (k < getBoard().getXMax() && j < getBoard().getYMax()); k++, j++) {
				if (!getBoard().getSquare(k, j).hasAPiece()) {
					currentPlayer = new Player("dummy", 3);
				}
				else if (getBoard().getSquare(k, j).getContent().getOwner().equals(currentPlayer)) {
					runningTotal++;
				} else {
					currentPlayer = getBoard().getSquare(k, j).getContent().getOwner();
					runningTotal = 1;
				}
				
				if (runningTotal >= 4)
					return true;
			}
		}
		
		for (int j = 1; j < getBoard().getYMax() - 4; j++) {
			currentPlayer = new Player("dummy", 3);
			for (int i = 0, k = j; (i < getBoard().getXMax() && k < getBoard().getYMax()); i++, k++) {
				if (!getBoard().getSquare(i, k).hasAPiece()) {
					currentPlayer = new Player("dummy", 3);
				}
				else if (getBoard().getSquare(i, k).getContent().getOwner().equals(currentPlayer)) {
					runningTotal++;
				} else {
					currentPlayer = getBoard().getSquare(i, k).getContent().getOwner();
					runningTotal = 1;
				}
				
				if (runningTotal >= 4)
					return true;
			}
		}
		return false;
	}
	
	@Override
	public boolean checkDraw() {
		for (int i = 0; i < getBoard().getXMax(); i++) {
			for (int j = 0; j < getBoard().getYMax(); j++) {
				if (!getBoard().getSquare(i, j).hasAPiece())
					return false;
			}
		}
		return true;
	}

}
