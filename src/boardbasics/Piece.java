package boardbasics;

public abstract class Piece {

	private Player owner;
	private String value;
	
	public Piece(Player owner, String value) {
		this.owner = owner;
		this.value = value;
	}
	
	public Player getOwner() {
		return owner;
	}
	
	public String getValue() {
		return value;
	}
	
	public abstract String getTextRepresentation();
}
