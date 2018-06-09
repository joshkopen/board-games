package connectfour;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

import com.sun.glass.events.MouseEvent;

import boardbasics.PlayType;
import boardbasics.Player;
import boardbasics.Square;
import boardbasics.VisualRunner;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import tictactoe.TicTacToePiece;

public class ConnectFourVisualRunner implements VisualRunner {

	private Scene scene;
	private Group root;
	private Stage s;
	
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
	private PlayType playType;
	
	public ConnectFourVisualRunner(Stage s, PlayType pt) {
		this("Bob", "Joe", s, pt);
	}
	
	public ConnectFourVisualRunner(String name1, String name2, Stage s, PlayType pt) {
		cfg = new ConnectFourGame();
		player1 = new Player(name1, 1);
		player2 = new Player(name2, 2);
		this.s = s;
		playType = pt;
	}

	@Override
	public Scene setupBoard() {
		root = new Group();
		scene = new Scene(root, WIDTH, HEIGHT, BACKGROUNDCOLOR);
		r2s = new HashMap<Rectangle, Square>();
		s2r = new HashMap<Square, Rectangle>();
		rectangleArray = new Rectangle[7][6];
		currentPlayer = this.getPlayer1();
		
		for (int i = 0; i < 7; i++) {
			for (int j = 0; j < 6; j++) {
				root.getChildren().add(rectangleSetup(i,j));
			}
		}
		System.out.println(scene.toString());
		return scene;
	}
	
	private Rectangle rectangleSetup(int i, int j) {
		Rectangle temp = new Rectangle(i*40 + 10, j*40 + 30, 40,40);
		temp.setFill(Color.WHITE);
		temp.setStroke(Color.BLACK);
		temp.setOnMouseClicked(e -> handleMouseInput(e.getSource()));
		r2s.put(temp, cfg.getBoard().getSquare(i, j));
		s2r.put(cfg.getBoard().getSquare(i, j), temp);
		rectangleArray[i][j] = temp;
		return temp;
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
			int toPlace = cfg.getRectangleNum(r2s.get(r).getCoord().getX());
			if (toPlace >= 0) {
				if (playType.equals(PlayType.OnePlayer)) 
					makeMoveOnePlayer(toPlace, r);
				else if (playType.equals(PlayType.TwoPlayer))
					makeMoveTwoPlayer(toPlace, r);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			s.close();
		} finally {
			
		}
	}
	
	private void makeMoveTwoPlayer(int toPlace, Rectangle r) throws FileNotFoundException {
		String inputString;
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
	
	private void makeMoveOnePlayer(int toPlace, Rectangle r) throws FileNotFoundException {
		
	}
}
