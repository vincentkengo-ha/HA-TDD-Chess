package ax.ha.tdd.chess.engine;

import ax.ha.tdd.chess.console.ChessboardWriter;
import ax.ha.tdd.chess.engine.pieces.ChessPiece;
import ax.ha.tdd.chess.engine.pieces.PieceType;
import ax.ha.tdd.chess.engine.pieces.Rook;
import ax.ha.tdd.chess.engine.pieces.Pawn;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RookTests {

    @Test
    public void testRookIllegalDiagonal() {
        Chessboard chessboard = new ChessboardImpl();
        Rook rook = new Rook(Color.WHITE, new Square("a1"));
        chessboard.addPiece(rook);

        assertFalse(rook.canMove(chessboard, new Square("b2")));
    }

    @Test
    public void testRookLegalMove() {
        Chessboard chessboard = new ChessboardImpl();
        Rook rook = new Rook(Color.WHITE, new Square("a1"));
        chessboard.addPiece(rook);

        assertTrue(rook.canMove(chessboard, new Square("a8")));
    }

    @Test
    public void testRookTakeMoveYAxis() {
        Chessboard chessboard = new ChessboardImpl();
        Rook white = new Rook(Color.WHITE, new Square("a1"));
        Rook black = new Rook(Color.BLACK, new Square("a8"));
        chessboard.addPiece(white);
        chessboard.addPiece(black);

        assertTrue(white.canMove(chessboard, new Square("a8")));
    }

    @Test
    public void testRookTakeMoveXAxis() {
        Chessboard chessboard = new ChessboardImpl();
        Rook white = new Rook(Color.WHITE, new Square("a1"));
        Rook black = new Rook(Color.BLACK, new Square("h1"));
        chessboard.addPiece(white);
        chessboard.addPiece(black);

        assertTrue(white.canMove(chessboard, new Square("h1")));
    }

    @Test
    public void testRookBlocked() {
        Chessboard chessboard = new ChessboardImpl();
        Rook rook = new Rook(Color.WHITE, new Square("a1"));
        Pawn pawn = new Pawn(Color.WHITE, new Square("a2"));
        Pawn pawnB = new Pawn(Color.BLACK, new Square("g1"));
        chessboard.addPiece(rook);
        chessboard.addPiece(pawn);
        chessboard.addPiece(pawnB);

        assertFalse(rook.canMove(chessboard, new Square("a8")));
        assertFalse(rook.canMove(chessboard, new Square("h1")));
    }

    @Test
    public void testCantTakeSameColor() {
        Chessboard chessboard = new ChessboardImpl();
        Rook white1 = new Rook(Color.WHITE, new Square("a1"));
        Rook white2 = new Rook(Color.WHITE, new Square("h1"));
        chessboard.addPiece(white1);
        chessboard.addPiece(white2);

        assertFalse(white1.canMove(chessboard, new Square("h1")));
    }

}
