package tictactoe;

import java.util.Scanner;

import boardbasics.Board;
import boardbasics.Piece;
import boardbasics.Player;

public class TicTacToeConsoleRunner extends TicTacToeRunner {

	
	
	public void runGameTwoPlayer() {
		
		Player currentPlayer;
		int x, y;
		Scanner sc = new Scanner(System.in);
		
		System.out.println(getTicTacToeGame().getTitle());
		
		while (true) {
			getTicTacToeGame().printBoard();
			if (getTicTacToeGame().checkWin()) {
				if (getTicTacToeGame().getMoveNum() % 2 == 1)
					System.out.println("Player 1 won the game.");
				else
					System.out.println("Player 2 won the game.");
				break;
			} else if (getTicTacToeGame().checkDraw()) {
				System.out.println("The game was drawn.");
				break;
			}
			
			if (getTicTacToeGame().getMoveNum() % 2 == 0)
				currentPlayer = getPlayer1();
			else
				currentPlayer = getPlayer2();
			System.out.println("Please enter the Y-coord for Player " + currentPlayer.getNum() + "'s move(1-3): ");
			x = sc.nextInt()-1;
			System.out.println("Please enter the X-coord for Player " + currentPlayer.getNum() + "'s move(1-3): ");
			y = sc.nextInt()-1;

			while(!getTicTacToeGame().placePiece(x, y, new TicTacToePiece(currentPlayer, "X"))) {
				System.out.println("This space is full! Please enter correct coorindates");
				System.out.println("Please enter the Y-coord for Player " + currentPlayer.getNum() + "'s move(1-3): ");
				x = sc.nextInt()-1;
				System.out.println("Please enter the X-coord for Player " + currentPlayer.getNum() + "'s move(1-3): ");
				y = sc.nextInt()-1;
			}
		}
		sc.close();
	}
}
