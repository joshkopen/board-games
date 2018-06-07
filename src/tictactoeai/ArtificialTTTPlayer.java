package tictactoeai;

import java.util.Random;

import boardbasics.InvalidEntryException;
import boardbasics.Player;
import boardbasics.Square;
import tictactoe.TicTacToeGame;

public class ArtificialTTTPlayer extends Player {

	private int difficulty;
	
	private final static int DIFFICULTYCAP = 100;
	
	public ArtificialTTTPlayer(String name, int num, int difficulty) throws InvalidEntryException {
		super(name, num);
		
		if ((difficulty > DIFFICULTYCAP) || (difficulty < 1)) {
			throw new InvalidEntryException("Difficulty not valid");
		}
		this.difficulty = difficulty;
	}

	public Square getMove(TicTacToeGame tttg) {
		if (makeGoodDecision()) {
			return BoardAnalyzer.getMove(tttg);
		}
		else {
			return BoardAnalyzer.getRandomMove(tttg);
		}
	}
	
	public boolean makeGoodDecision() {
		Random rand = new Random();
		return (rand.nextInt(DIFFICULTYCAP) + 1) < difficulty;
	}
}
