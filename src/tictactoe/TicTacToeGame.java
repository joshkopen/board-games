package tictactoe;

import java.util.Map;

import boardbasics.Board;
import boardbasics.Coord;
import boardbasics.Piece;
import boardbasics.Player;
import boardbasics.Square;

public class TicTacToeGame {

	private String gameTitle;
	private Board board;
	private int moveNum;
	
	private static final int TICTACTOESIZE = 3;
	
	public TicTacToeGame() {
		gameTitle = "A friendly game between friends";
		board = generateBoard();
		moveNum = 0;
	}
	
	public TicTacToeGame(String gameTitle) {
		this.gameTitle = gameTitle;
		board = generateBoard();
		moveNum = 0;
	}
	
	private Board generateBoard() {
		return new Board(TICTACTOESIZE, TICTACTOESIZE);
	}
	
	/**
	 * 
	 * Returns whether the piece placement is valid
	 */
	public boolean placePiece(int x, int y, Piece content) {
		boolean result = board.placePiece(x, y, content);
		if (result)
			moveNum++;
		return result;
	}
	
	private Player getOwner(int x, int y) {
		return board.getSquare(x,y).getContent().getOwner();
	}
	
	public boolean checkDraw() {
		for (int i = 0; i < TICTACTOESIZE; i++) {
			for (int j = 0; j < TICTACTOESIZE; j++) {
				if (!board.getSquare(i, j).hasAPiece()) {
					return false;
				}
			}
		}
		return true;
	}
	
	public boolean checkWin() {
		boolean winning;
		Player winner = null;
		
		//vertical checking
		for (int i = 0; i < TICTACTOESIZE; i++) {
			if (board.getSquare(i, 0).hasAPiece()) {
				winning = true;
				winner = board.getSquare(i, 0).getContent().getOwner();
			} else {
				winning = false;
			}
			for (int j = 1; j < TICTACTOESIZE; j++) {
				if (!winning) 
					break;
				
				if (!board.getSquare(i, j).hasAPiece()) {
					winning = false;
				}
				else if (getOwner(i,j).getNum() != winner.getNum()) {
					winning = false;
				}
			}
			if (winning)
				return winning;
		}
		
		//horizontal checking
		for (int j = 0; j < TICTACTOESIZE; j++) {
			if (board.getSquare(0, j).hasAPiece()) {
				winning = true;
				winner = board.getSquare(0, j).getContent().getOwner();
			} else {
				winning = false;
			}
			for (int i = 1; i < TICTACTOESIZE; i++) {
				if (!winning) 
					break;
				
				if (!board.getSquare(i, j).hasAPiece()) {
					winning = false;
				}
				else if (getOwner(i, j).getNum() != winner.getNum()) {
					winning = false;
				}
			}
			if (winning)
				return winning;
		}
		
		//diagonal checking
		if ((board.getSquare(0, 0).hasAPiece()) && (board.getSquare(1, 1).hasAPiece()) && (board.getSquare(2, 2).hasAPiece())) {
			if ((getOwner(0,0).getNum() == getOwner(1,1).getNum()) && (getOwner(1,1).getNum() == getOwner(2,2).getNum())) {
				return true;
			}
		}
		
		if ((board.getSquare(0, 2).hasAPiece()) && (board.getSquare(1, 1).hasAPiece()) && (board.getSquare(2, 0).hasAPiece())) {
			if ((getOwner(0,2).getNum() == getOwner(1,1).getNum()) && (getOwner(1,1).getNum() == getOwner(2,0).getNum())) {
				return true;
			}
		}
		
		return false;
	}
	
	public int getMoveNum() {
		return moveNum;
	}
	
	public String getTitle() {
		return gameTitle;
	}
	
	public void printBoard() {
		board.printBoard();
	}
	
	public Board getBoard() {
		return board;
	}
}
