package connectfour;

import boardbasics.PlayType;
import boardbasics.VisualRunner;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.application.Application;


public class ConnectFourVisualLauncher extends Application{

	private static final int FRAMES_PER_SECOND = 60;
    private static final int MILLISECOND_DELAY = 1000 / FRAMES_PER_SECOND;
    private static final double SECOND_DELAY = 1.0 / FRAMES_PER_SECOND;
    
    private VisualRunner c4r;

	public static void main(String[] args) {
		launch(args);
	}
	
	//TODO: Add decision making for how many players
	public void start(Stage s) {
		c4r = new ConnectFourVisualRunner(s, PlayType.TwoPlayer);
		s.setScene(c4r.setupBoard());
		
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

	}
}
