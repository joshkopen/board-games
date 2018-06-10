package chess;

import boardbasics.Board;
import boardbasics.Game;
import boardbasics.Player;

public class ChessGame extends Game {

	public ChessGame(String title) {
		setTitle(title);
		setMoveNum(0);
		setBoard(generateBoard());
	}
	
	public ChessGame() {
		this("A friendly game between friends.");
	}
	
	private ChessBoard generateBoard() {
		return new ChessBoard(8,8);
	}
	
	public boolean placePiece(int x, int y, Player p) {
		return false;
	}
	
	@Override
	public ChessBoard getBoard() {
		return (ChessBoard) super.getBoard();
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
