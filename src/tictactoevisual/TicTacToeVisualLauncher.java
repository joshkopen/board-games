package tictactoevisual;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.util.Duration;

public class TicTacToeVisualLauncher extends Application {
	
    private static final int FRAMES_PER_SECOND = 60;
    private static final int MILLISECOND_DELAY = 1000 / FRAMES_PER_SECOND;
    private static final double SECOND_DELAY = 1.0 / FRAMES_PER_SECOND;
    
    private TicTacToeVisualRunner tttr;
    private Stage s;

	public static void main(String[] args) {
		launch(args);
	}
	
	public void start(Stage s) {
		this.s = s;
		tttr = new TicTacToeVisualRunner();
		s.setScene(tttr.setupBoard());
		
		s.show();
        // attach "game loop" to timeline to play it
        KeyFrame frame = new KeyFrame(Duration.millis(MILLISECOND_DELAY),
                                      e -> step(SECOND_DELAY));
        Timeline animation = new Timeline();
        animation.setCycleCount(Timeline.INDEFINITE);
        animation.getKeyFrames().add(frame);
        animation.play();
	}

	public void step(double elapsedTime) {
		tttr.runGameTwoPlayer(s);
	}
}
