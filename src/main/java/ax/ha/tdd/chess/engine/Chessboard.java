package ax.ha.tdd.chess.engine;

import ax.ha.tdd.chess.engine.pieces.ChessPiece;

public interface Chessboard extends Iterable<ChessPiece[]>{

    ChessPiece getPieceAt(Square square);
}
