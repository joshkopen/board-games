package tictactoe;

import boardbasics.Player;

public abstract class TicTacToeRunner {

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
		
	protected TicTacToeGame getTicTacToeGame() {
		return tttg;
	}
	
	protected Player getPlayer1() {
		return player1;
	}
	protected Player getPlayer2() {
		return player2;
	}

}
