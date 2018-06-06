package boardbasics;

import java.util.HashMap;
import java.util.Map;

public class Board {
	
	private int height;
	private int width;
	private Square squares[][];
	
	public Board(int height, int width) {
		this.height = height;
		this.width = width;
		squares = new Square[height][width];
		squareGenerator(height, width);
	}
	
	protected void squareGenerator(int height, int width) {
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				squares[i][j] = new Square(i, j);
			}
		}
	}
	
	/**
	 * 
	 * Returns whether the piece placement is valid
	 */
	public boolean placePiece(int x, int y, Piece content) {
		Square square = squares[x][y];
		if (square.hasAPiece())
			return false;
		square.setContent(content);
		return true;
	}

	
	public void printBoard() {
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				if (squares[i][j].hasAPiece())
					System.out.print(squares[i][j].getContent().getOwner().getNum());
				else
					System.out.print("_");
			}
			System.out.println();
		}
		
		System.out.println();
	}
	
	public Square getSquare(int x, int y) {
		return squares[x][y];
	}
}
