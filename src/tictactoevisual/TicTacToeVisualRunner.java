package tictactoevisual;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;
import tictactoe.TicTacToeRunner;

public class TicTacToeVisualRunner extends TicTacToeRunner {

	private Scene scene;
	private Group root;
	private Stage stage;
	
	private static final int HEIGHT = 300;
	private static final int WIDTH = 300;
	private static final Paint BACKGROUNDCOLOR = Color.AQUA;
	
	public void runGameTwoPlayer(Stage s) {
		setupBoard();
		
	}
	
	private void setupBoard() {
		Group root = new Group();
		scene = new Scene(root, WIDTH, HEIGHT, BACKGROUNDCOLOR);
		
		
		stage.setScene(scene);
	}
}
