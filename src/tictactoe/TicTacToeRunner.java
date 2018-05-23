package tictactoe;

import java.util.Scanner;

import boardbasics.Board;
import boardbasics.Piece;
import boardbasics.Player;
import boardbasics.TicTacToePiece;

public class TicTacToeRunner {

	private Player player1;
	private Player player2;
	private TicTacToeGame tttg;
	
	public TicTacToeRunner() {
		this("Bob", "Joe");
	}
	
	public TicTacToeRunner(String name1, String name2) {
		tttg = new TicTacToeGame();
		player1 = new Player(name1, 1);
		player2 = new Player(name2, 2);
	}
	
	public void consoleRun() {
		
		Player currentPlayer;
		int x, y;
		Scanner sc = new Scanner(System.in);
		
		System.out.println(tttg.getTitle());
		
		while (true) {
			tttg.printBoard();
			if (tttg.checkWin()) {
				if (tttg.getMoveNum() % 2 == 1)
					System.out.println("Player 1 won the game.");
				else
					System.out.println("Player 2 won the game.");
				break;
			} else if (tttg.checkDraw()) {
				System.out.println("The game was drawn.");
				break;
			}
			
			if (tttg.getMoveNum() % 2 == 0)
				currentPlayer = player1;
			else
				currentPlayer = player2;
			System.out.println("Please enter the Y-coord for Player " + currentPlayer.getNum() + "'s move(1-3): ");
			x = sc.nextInt()-1;
			System.out.println("Please enter the X-coord for Player " + currentPlayer.getNum() + "'s move(1-3): ");
			y = sc.nextInt()-1;

			while(!tttg.placePiece(x, y, new TicTacToePiece(currentPlayer, "X"))) {
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
