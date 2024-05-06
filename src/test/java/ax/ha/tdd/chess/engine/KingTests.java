package ax.ha.tdd.chess.engine;

import ax.ha.tdd.chess.engine.pieces.King;
import ax.ha.tdd.chess.engine.pieces.Pawn;
import ax.ha.tdd.chess.engine.pieces.Queen;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class KingTests {
    @Test
    public void testIllegalMove() {
        Chessboard chessboard = new ChessboardImpl();
        King king = new King(Color.WHITE, new Square("d4"));
        chessboard.addPiece(king);

        assertFalse(king.canMove(chessboard, new Square("b4")));
        assertFalse(king.canMove(chessboard, new Square("d4")));
    }

    @Test
    public void testLegalMoves() {
        Chessboard chessboard = new ChessboardImpl();
        King king = new King(Color.WHITE, new Square("d4"));
        chessboard.addPiece(king);

        assertTrue(king.canMove(chessboard, new Square("d5")));
        assertTrue(king.canMove(chessboard, new Square("e3")));
    }

    @Test
    public void testBlocked() {
        Chessboard chessboard = new ChessboardImpl();
        King king0 = new King(Color.WHITE, new Square("d4"));
        King king1 = new King(Color.WHITE, new Square("d5"));
        King king2 = new King(Color.WHITE, new Square("e3"));
        chessboard.addPiece(king0);
        chessboard.addPiece(king1);
        chessboard.addPiece(king2);

        assertFalse(king0.canMove(chessboard, new Square("d5")));
        assertFalse(king0.canMove(chessboard, new Square("e3")));
    }

    @Test
    public void testTake() {
        Chessboard chessboard = new ChessboardImpl();
        King king0 = new King(Color.BLACK, new Square("d4"));
        Pawn pawn = new Pawn(Color.WHITE, new Square("d5"));
        Pawn pawn2 = new Pawn(Color.WHITE, new Square("e3"));
        chessboard.addPiece(king0);
        chessboard.addPiece(pawn);
        chessboard.addPiece(pawn2);

        assertTrue(king0.canMove(chessboard, new Square("d5")));
        assertTrue(king0.canMove(chessboard, new Square("e3")));
    }

    @Test
    public void testCantGoToThreatenedSquare() {
        Chessboard chessboard = new ChessboardImpl();
        King king = new King(Color.WHITE, new Square("a1"));
        Queen queen = new Queen(Color.BLACK, new Square("h1"));
        chessboard.addPiece(king);
        chessboard.addPiece(queen);

        assertFalse(king.canMove(chessboard, new Square("b1")));
    }
}
