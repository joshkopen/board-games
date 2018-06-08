package boardbasics;

public abstract class Game {
	private String gameTitle;
	private Board board;
	private int moveNum;
	
	public abstract boolean checkWin();
	public abstract boolean checkDraw();
	
	public boolean placePiece(int x, int y, Piece content) {
		boolean result = getBoard().placePiece(x, y, content);
		if (result)
			setMoveNum(getMoveNum() + 1);
		return result;
	}
	
	public int getMoveNum() {
		return moveNum;
	}
	
	public String getTitle() {
		return gameTitle;
	}
	
	public Board getBoard() {
		return board;
	}
	
	protected void setMoveNum(int mn) {
		moveNum = mn;
	}
	
	protected void setTitle(String t) {
		gameTitle = t;
	}
	
	protected void setBoard(Board b) {
		board = b;
	}
}
