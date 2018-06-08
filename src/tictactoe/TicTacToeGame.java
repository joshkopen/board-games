package tictactoe;

import java.util.Map;

import boardbasics.Board;
import boardbasics.Coord;
import boardbasics.Game;
import boardbasics.Piece;
import boardbasics.Player;
import boardbasics.Square;

public class TicTacToeGame extends Game {
	
	private static final int TICTACTOESIZE = 3;
	
	public TicTacToeGame() {
		this("A friendly game between friends");
	}
	
	public TicTacToeGame(String gameTitle) {
		setTitle(gameTitle);
		setBoard(generateBoard());
		setMoveNum(0);
	}
	
	private Board generateBoard() {
		return new Board(TICTACTOESIZE, TICTACTOESIZE);
	}
	
	private Player getOwner(int x, int y) {
		return getBoard().getSquare(x,y).getContent().getOwner();
	}
	
	public boolean checkDraw() {
		for (int i = 0; i < TICTACTOESIZE; i++) {
			for (int j = 0; j < TICTACTOESIZE; j++) {
				if (!getBoard().getSquare(i, j).hasAPiece()) {
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
			if (getBoard().getSquare(i, 0).hasAPiece()) {
				winning = true;
				winner = getBoard().getSquare(i, 0).getContent().getOwner();
			} else {
				winning = false;
			}
			for (int j = 1; j < TICTACTOESIZE; j++) {
				if (!winning) 
					break;
				
				if (!getBoard().getSquare(i, j).hasAPiece()) {
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
			if (getBoard().getSquare(0, j).hasAPiece()) {
				winning = true;
				winner = getBoard().getSquare(0, j).getContent().getOwner();
			} else {
				winning = false;
			}
			for (int i = 1; i < TICTACTOESIZE; i++) {
				if (!winning) 
					break;
				
				if (!getBoard().getSquare(i, j).hasAPiece()) {
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
		if ((getBoard().getSquare(0, 0).hasAPiece()) && (getBoard().getSquare(1, 1).hasAPiece()) && (getBoard().getSquare(2, 2).hasAPiece())) {
			if ((getOwner(0,0).getNum() == getOwner(1,1).getNum()) && (getOwner(1,1).getNum() == getOwner(2,2).getNum())) {
				return true;
			}
		}
		
		if ((getBoard().getSquare(0, 2).hasAPiece()) && (getBoard().getSquare(1, 1).hasAPiece()) && (getBoard().getSquare(2, 0).hasAPiece())) {
			if ((getOwner(0,2).getNum() == getOwner(1,1).getNum()) && (getOwner(1,1).getNum() == getOwner(2,0).getNum())) {
				return true;
			}
		}
		
		return false;
	}
		
	public void printBoard() {
		getBoard().printBoard();
	}

}
