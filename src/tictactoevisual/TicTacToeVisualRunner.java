package tictactoevisual;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

import boardbasics.PlayType;
import boardbasics.Player;
import boardbasics.Square;
import boardbasics.VisualRunner;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import tictactoe.TicTacToePiece;
import tictactoe.TicTacToeRunner;

public class TicTacToeVisualRunner extends TicTacToeRunner implements VisualRunner {

	private Scene scene;
	private Group root;
	private Stage stage;
	private PlayType playType;
	
	private Map<Rectangle, Square> spaces;
	private Player currentPlayer;
	
	private static final int HEIGHT = 300;
	private static final int WIDTH = 300;
	private static final Paint BACKGROUNDCOLOR = Color.WHITE;
	
	public TicTacToeVisualRunner(Stage s, PlayType pt) {
		super("Bob", "Joe");
		stage = s;
		playType = pt;
	}
	
	public Scene setupBoard() {
		root = new Group();
		scene = new Scene(root, WIDTH, HEIGHT, BACKGROUNDCOLOR);
		spaces = new HashMap<Rectangle, Square>();
		currentPlayer = this.getPlayer1();
		
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				root.getChildren().add(rectangleSetup(i,j));
			}
		}
		System.out.println(scene.toString());
		return scene;
	}
	
	private Rectangle rectangleSetup(int i, int j) {
		Rectangle temp = new Rectangle(i*90 + 15, j*90 + 15, 90,90);
		temp.setFill(Color.WHITE);
		temp.setStroke(Color.BLACK);
		temp.setOnMouseClicked(e -> handleMouseInput(e.getSource()));
		spaces.put(temp, this.getTicTacToeGame().getBoard().getSquare(i, j));
		return temp;
	}
	
	private void handleMouseInput(Object o) {
		try {
			Rectangle r = (Rectangle) o;
			
			if (!spaces.get(r).hasAPiece()) {
				if (playType.equals(PlayType.OnePlayer))
					makeMoveOnePlayer(r);
				else if (playType.equals(PlayType.TwoPlayer))
					makeMoveTwoPlayer(r);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			
		}
	}
	
	private void makeMoveTwoPlayer(Rectangle r) throws FileNotFoundException {
		String inputString;
		this.getTicTacToeGame().placePiece(spaces.get(r).getCoord().getX(), spaces.get(r).getCoord().getY(), new TicTacToePiece(currentPlayer, "visual"));

		if (currentPlayer.equals(this.getPlayer1())) {
			inputString = "images/X.png";
			currentPlayer = this.getPlayer2();
		}
		else {
			inputString = "images/O.png";
			currentPlayer = this.getPlayer1();
		}
		Image image = new Image(new FileInputStream(inputString));
		r.setFill(new ImagePattern(image));
		if (getTicTacToeGame().checkWin()) {
			if (getTicTacToeGame().getMoveNum() % 2 == 1)
				System.out.println("Player 1 won the game.");
			else
				System.out.println("Player 2 won the game.");
			stage.close();
		} else if (getTicTacToeGame().checkDraw()) {
			System.out.println("The game was drawn.");
			stage.close();
		}
	}
	
	private void makeMoveOnePlayer(Rectangle r) {
		
	}
}
