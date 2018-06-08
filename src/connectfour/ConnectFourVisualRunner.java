package connectfour;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

import boardbasics.Player;
import boardbasics.Square;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import tictactoe.TicTacToePiece;
import tictactoevisual.VisualRunner;

public class ConnectFourVisualRunner implements VisualRunner {

	private Scene scene;
	private Group root;
	
	private Rectangle[][] rectangleArray;
	private Map<Rectangle, Square> r2s;
	private Map<Square, Rectangle> s2r;
	private Player currentPlayer;
	
	private static final int HEIGHT = 300;
	private static final int WIDTH = 300;
	private static final Paint BACKGROUNDCOLOR = Color.BLACK;
	
	private ConnectFourGameAccess cfg;
	private Player player1;
	private Player player2;
	
	public ConnectFourVisualRunner() {
		this("Bob", "Joe");
	}
	
	public ConnectFourVisualRunner(String name1, String name2) {
		cfg = new ConnectFourGame();
		player1 = new Player(name1, 1);
		player2 = new Player(name2, 2);
	}
	
	@Override
	public void runGameTwoPlayer(Stage s) {
		if (cfg.checkWin()) {
			if (cfg.getMoveNum() % 2 == 1)
				System.out.println("Player 1 won the game.");
			else
				System.out.println("Player 2 won the game.");
			s.close();
		} else if (cfg.checkDraw()) {
			System.out.println("The game was drawn.");
			s.close();
		}
		
	}

	@Override
	public Scene setupBoard() {
		root = new Group();
		scene = new Scene(root, WIDTH, HEIGHT, BACKGROUNDCOLOR);
		r2s = new HashMap<Rectangle, Square>();
		s2r = new HashMap<Square, Rectangle>();
		rectangleArray = new Rectangle[7][6];
		currentPlayer = this.getPlayer1();
		Rectangle temp;
		
		for (int i = 0; i < 7; i++) {
			for (int j = 0; j < 6; j++) {
				temp = new Rectangle(i*40 + 10, j*40 + 30, 40,40);
				temp.setFill(Color.WHITE);
				temp.setStroke(Color.BLACK);
				temp.setOnMouseClicked(e -> handleMouseInput(e.getSource()));
				r2s.put(temp, cfg.getBoard().getSquare(i, j));
				s2r.put(cfg.getBoard().getSquare(i, j), temp);
				rectangleArray[i][j] = temp;
				root.getChildren().add(temp);
			}
		}
		System.out.println(scene.toString());
		return scene;
	}

	private Player getPlayer1() {
		return player1;
	}
	
	private Player getPlayer2() {
		return player2;
	}
	
	private void handleMouseInput(Object o) {
		try {
			Rectangle r = (Rectangle) o;
			String inputString;
			int toPlace = cfg.getRectangleNum(r2s.get(r).getCoord().getX());
			System.out.println(toPlace);
			if (toPlace >= 0) {
			
				cfg.placePiece(r2s.get(r).getCoord().getX(), new ConnectFourPiece(currentPlayer, "visual"));
				if (currentPlayer.equals(this.getPlayer1())) {
					inputString = "images/redcircle.png";
					currentPlayer = this.getPlayer2();
				}
				else {
					inputString = "images/yellowcircle.jpg";
					currentPlayer = this.getPlayer1();
				}
				Image image = new Image(new FileInputStream(inputString));
				rectangleArray[r2s.get(r).getCoord().getX()][toPlace].setFill(new ImagePattern(image));
				System.out.println();
			}
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			
		}
	}
}
