package tictactoevisual;
import javafx.application.Application;
import javafx.stage.Stage;
import tictactoe.TicTacToeRunner;;

public class TicTacToeVisualLauncher extends Application {

	public static void main(String[] args) {
		launch(args);
	}
	
	public void start(Stage s) {
		TicTacToeVisualRunner tttr = new TicTacToeVisualRunner();
		tttr.runGameTwoPlayer(s);
	}

}
