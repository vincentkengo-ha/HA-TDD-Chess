package ax.ha.tdd.chess.engine;

import ax.ha.tdd.chess.engine.pieces.Bishop;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BishopTests {
    @Test
    public void testIllegalMove() {
        Chessboard chessboard = new ChessboardImpl();
        Bishop bishop = new Bishop(Color.WHITE, new Square("a1"));
        chessboard.addPiece(bishop);

        assertFalse(bishop.canMove(chessboard, new Square("a8")));
    }

    @Test
    public void testLegalMove() {
        Chessboard chessboard = new ChessboardImpl();
        Bishop bishop = new Bishop(Color.WHITE, new Square("a8"));
        chessboard.addPiece(bishop);

        assertTrue(bishop.canMove(chessboard, new Square("h1")));
    }

    @Test
    public void testBlockedPath() {
        Chessboard chessboard = new ChessboardImpl();
        Bishop bishop1 = new Bishop(Color.WHITE, new Square("a1"));
        Bishop bishop2 = new Bishop(Color.WHITE, new Square("d4"));
        chessboard.addPiece(bishop1);
        chessboard.addPiece(bishop2);

        assertFalse(bishop1.canMove(chessboard, new Square("h8")));
    }

    @Test
    public void testTakeMove1() {
        Chessboard chessboard = new ChessboardImpl();
        Bishop white = new Bishop(Color.WHITE, new Square("h1"));
        Bishop black = new Bishop(Color.BLACK, new Square("a8"));
        chessboard.addPiece(white);
        chessboard.addPiece(black);

        assertTrue(white.canMove(chessboard, new Square("a8")));
    }

    @Test
    public void testTakeMove2() {
        Chessboard chessboard = new ChessboardImpl();
        Bishop white = new Bishop(Color.WHITE, new Square("a1"));
        Bishop black = new Bishop(Color.BLACK, new Square("h8"));
        chessboard.addPiece(white);
        chessboard.addPiece(black);

        assertTrue(white.canMove(chessboard, new Square("h8")));
    }

    @Test
    public void testCantTakeFriend() {
        Chessboard chessboard = new ChessboardImpl();
        Bishop white1 = new Bishop(Color.WHITE, new Square("a1"));
        Bishop white2 = new Bishop(Color.WHITE, new Square("h8"));
        chessboard.addPiece(white1);
        chessboard.addPiece(white2);

        assertFalse(white1.canMove(chessboard, new Square("h8")));
    }
}
