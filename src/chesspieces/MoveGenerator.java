package chesspieces;

import java.util.List;

import boardbasics.Board;
import boardbasics.Coord;
import boardbasics.Player;
import boardbasics.Square;
import chess.ChessBoard;
import chess.ChessSquare;

public interface MoveGenerator {

	public List<ChessSquare> getMoves(ChessBoard board, Coord pos, Player owner);
}
