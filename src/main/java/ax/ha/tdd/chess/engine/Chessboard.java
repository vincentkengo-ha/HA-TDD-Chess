package ax.ha.tdd.chess.engine;

import ax.ha.tdd.chess.engine.pieces.ChessPiece;

public interface Chessboard extends Iterable<ChessPiece[]>{

    ChessPiece getPieceAt(final Square square);

    void addPiece(final ChessPiece chessPiece);

    //If you prefer, modify this to use a location instead.
    void removePieceAt(final Square square);
}
