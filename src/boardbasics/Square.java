package boardbasics;

public class Square {
	
	private Coord location;
	private boolean full;
	private Piece content;
	
	public Square(int xVal, int yVal) {
		location = new Coord(xVal, yVal);
		full = false;
		content = null;
	}
	
	public Coord getCoord() {
		return location;
	}
	
	public boolean hasAPiece() {
		return full;
	}
	
	public Piece getContent() {
		return content;
	}
	
	public void setContent(Piece content) {
		this.content = content;
		if (content != null) 
			full = true;
	}
	
	public void removeContent() {
		content = null;
		full = false;
	}
}
