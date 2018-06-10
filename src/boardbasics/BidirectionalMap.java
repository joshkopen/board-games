package boardbasics;

import java.util.HashMap;
import java.util.Map;

import chess.ChessSquare;
import javafx.scene.shape.Rectangle;


public class BidirectionalMap {

	private Map<Rectangle, ChessSquare> r2s;
	private Map<ChessSquare, Rectangle> s2r;
	
	public BidirectionalMap() {
		r2s = new HashMap<Rectangle, ChessSquare>();
		s2r = new HashMap<ChessSquare, Rectangle>();
	}
	
	public void put(ChessSquare s, Rectangle r) {
		r2s.put(r,s);
		s2r.put(s, r);
	}
	
	public void put(Rectangle r, ChessSquare s) {
		put(s,r);
	}
	
	public ChessSquare get(Rectangle r) {
		return r2s.get(r);
	}
	
	public Rectangle get(ChessSquare s) {
		return s2r.get(s);
	}
}
