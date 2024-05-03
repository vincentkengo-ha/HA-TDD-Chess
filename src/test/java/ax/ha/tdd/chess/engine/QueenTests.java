package ax.ha.tdd.chess.engine;

import ax.ha.tdd.chess.engine.pieces.Queen;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class QueenTests {
    @Test
    public void testIllegalMove() {
        Chessboard chessboard = new ChessboardImpl();
        Queen queen = new Queen(Color.WHITE, new Square("a1"));
        chessboard.addPiece(queen);

        assertFalse(queen.canMove(chessboard, new Square("b3")));
    }

    @Test
    public void testLegalMove() {
        Chessboard chessboard = new ChessboardImpl();
        Queen queen = new Queen(Color.WHITE, new Square("a1"));
        chessboard.addPiece(queen);

        assertTrue(queen.canMove(chessboard, new Square("e5")));
        assertTrue(queen.canMove(chessboard, new Square("a8")));
        assertTrue(queen.canMove(chessboard, new Square("h1")));
    }

    @Test
    public void testBlocked() {
        Chessboard chessboard = new ChessboardImpl();
        Queen queen0 = new Queen(Color.WHITE, new Square("a1"));
        Queen queen1 = new Queen(Color.WHITE, new Square("a8"));
        Queen queen2 = new Queen(Color.WHITE, new Square("h1"));
        Queen queen3 = new Queen(Color.WHITE, new Square("h8"));
        chessboard.addPiece(queen0);
        chessboard.addPiece(queen1);
        chessboard.addPiece(queen2);
        chessboard.addPiece(queen3);

        assertFalse(queen0.canMove(chessboard, new Square("a8")));
        assertFalse(queen0.canMove(chessboard, new Square("h1")));
        assertFalse(queen0.canMove(chessboard, new Square("h8")));
    }

    @Test
    public void testTake() {
        Chessboard chessboard = new ChessboardImpl();
        Queen queen0 = new Queen(Color.BLACK, new Square("a1"));
        Queen queen1 = new Queen(Color.WHITE, new Square("a8"));
        Queen queen2 = new Queen(Color.WHITE, new Square("h1"));
        Queen queen3 = new Queen(Color.WHITE, new Square("h8"));
        chessboard.addPiece(queen0);
        chessboard.addPiece(queen1);
        chessboard.addPiece(queen2);
        chessboard.addPiece(queen3);

        assertTrue(queen0.canMove(chessboard, new Square("a8")));
        assertTrue(queen0.canMove(chessboard, new Square("h1")));
        assertTrue(queen0.canMove(chessboard, new Square("h8")));
    }
}
