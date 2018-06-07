package tictactoeai;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import boardbasics.Square;
import tictactoe.TicTacToeGame;

public class BoardAnalyzer {

	public static Square getMove(TicTacToeGame tttg) {
		// TODO Auto-generated method stub
		return null;
	}

	public static Square getRandomMove(TicTacToeGame tttg) {
		List<Square> potential = new ArrayList<Square>();
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (!tttg.getBoard().getSquare(i, j).hasAPiece()) {
					potential.add(tttg.getBoard().getSquare(i, j));
				}	
			}
		}
		
		return randomListSelection(potential);
	}
	
	private static Square randomListSelection(List<Square> potential) {
		Random rand = new Random();
		return potential.get(rand.nextInt(potential.size()));
	}
	
}
