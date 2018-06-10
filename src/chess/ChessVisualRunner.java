package chess;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import boardbasics.BidirectionalMap;
import boardbasics.Coord;
import boardbasics.PlayType;
import boardbasics.Player;
import boardbasics.Square;
import boardbasics.VisualRunner;
import chesspieces.Bishop;
import chesspieces.ChessPiece;
import chesspieces.King;
import chesspieces.Knight;
import chesspieces.Pawn;
import chesspieces.Queen;
import chesspieces.Rook;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class ChessVisualRunner implements VisualRunner{
	
	private Scene scene;
	private Group root;
	private Stage stage;
	
	private PlayType playType;
	private Player currentPlayer;
	private BidirectionalMap rsMap;
	private Rectangle [][] rectangleArray;
	private Map<Rectangle, Coord> rectanglePlacementMap;
	private Player player1;
	private Player player2;
	private ChessGame cg;
	
	private ChessSquare currentlySelected;
	
	private static final int HEIGHT = 600;
	private static final int WIDTH = 600;
	private static final Paint BACKGROUNDCOLOR = Color.WHITE;

	public ChessVisualRunner(Stage stage, PlayType playType) {
		this("Bob", "Joe", stage, playType);
	}
	
	private ChessVisualRunner(String name1, String name2, Stage stage, PlayType playType) {
		this.stage = stage;
		this.playType = playType;
		player1 = new Player(name1, 1);
		player2 = new Player(name2, 2);
		cg = new ChessGame();
		currentPlayer = player1;
		currentlySelected = null;
	}
	
	@Override
	public Scene setupBoard() {
		root = new Group();
		scene = new Scene(root, WIDTH, HEIGHT, BACKGROUNDCOLOR);
		rsMap = new BidirectionalMap();
		rectanglePlacementMap = new HashMap<Rectangle, Coord>();
		rectangleArray = new Rectangle[8][8];
		currentPlayer = this.getPlayer1();
		
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				root.getChildren().add(rectangleSetup(i,j));
			}
		}
		placePieces();
		return scene;
	}

	private Rectangle rectangleSetup(int i, int j) {
		Rectangle temp = new Rectangle(i*70 + 20, j*70 + 20, 70,70);
		rectanglePlacementMap.put(temp, new Coord(i * 70 + 20, j * 70 + 20));
		if ((i+j) % 2 == 0)
			temp.setFill(Color.WHITE);
		else
			temp.setFill(Color.BROWN);
		temp.setStroke(Color.BLACK);
		temp.setOnMouseClicked(e -> handleMouseInput(e.getSource()));
		rsMap.put(temp, cg.getBoard().getSquare(i, j));
		rectangleArray[i][j] = temp;
		return temp;
	}
	
	private void placePieces() {
		setPawns(1, "black", getPlayer2());
		setPawns(6, "white", getPlayer1());
		setPieces(0, "black", getPlayer2());
		setPieces(7, "white", getPlayer1());
	}
	
	private void setPawns(int row, String color, Player player) {
		Image image;
		ImageView iv;
		try {
			image = new Image(new FileInputStream("images/" + color + "pawn.png"));
			for (int i = 0; i < 8; i++) {
				iv = new ImageView(image);
				iv.setX(rectanglePlacementMap.get(rectangleArray[i][row]).getX());
				iv.setY(rectanglePlacementMap.get(rectangleArray[i][row]).getY());
				iv.setFitHeight(70);
				iv.setFitWidth(70);
				root.getChildren().add(iv);
				cg.placePiece(row, i, new Pawn(player, null));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	private void setPieces(int row, String color, Player player) {
		Image image;
		ImageView iv;
		String [] pieceNameArray = {"rook", "knight", "bishop", "queen", "king",
									"bishop", "knight", "rook"};
		ChessPiece [] pieceArray = {new Rook(player, null), new Knight(player, null),
									new Bishop(player, null), new Queen(player, null),
									new King(player, null), new Bishop(player, null),
									new Knight(player, null), new Rook(player, null)
		};
		
		try {
			for (int i = 0; i < 8; i++) {
				image = new Image(new FileInputStream("images/" + color + pieceArray[i] + ".png"));
				iv = new ImageView(image);
				iv.setX(rectanglePlacementMap.get(rectangleArray[i][row]).getX());
				iv.setY(rectanglePlacementMap.get(rectangleArray[i][row]).getY());
				iv.setFitHeight(70);
				iv.setFitWidth(70);
				root.getChildren().add(iv);
				cg.placePiece(row, i, new Pawn(player, null));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	private void handleMouseInput(Object o) {
		Rectangle r = (Rectangle) o;
		List<ChessSquare> moves;
		
		if (currentlySelected == null) {
			if (rsMap.get(r).hasAPiece()) {
				if (rsMap.get(r).getContent().getOwner().equals(currentPlayer)) {
					currentlySelected = rsMap.get(r);
					moves = currentlySelected.getContent().getMoves(cg.getBoard(), currentlySelected.getCoord());
					for (ChessSquare move: moves) {
						rsMap.get(move)
					}
				}
			}
		}
	}
	
	private Player getPlayer1() {
		return player1;
	}
	
	private Player getPlayer2() {
		return player2;
	}
}
