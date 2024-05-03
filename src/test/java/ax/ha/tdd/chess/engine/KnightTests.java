package ax.ha.tdd.chess.engine;

import ax.ha.tdd.chess.console.ChessboardWriter;
import ax.ha.tdd.chess.engine.pieces.ChessPiece;
import ax.ha.tdd.chess.engine.pieces.PieceType;
import ax.ha.tdd.chess.engine.pieces.Knight;
import ax.ha.tdd.chess.engine.pieces.Rook;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class KnightTests {

    @Test
    public void testKnightIllegalMove() {
        Chessboard chessboard = new ChessboardImpl();
        Knight knight = new Knight(Color.WHITE, new Square("a1"));
        chessboard.addPiece(knight);

        assertFalse(knight.canMove(chessboard, new Square("h8")));
        assertFalse(knight.canMove(chessboard, new Square("a1")));
    }

    @Test
    public void testKnightMove() {
        Chessboard chessboard = new ChessboardImpl();
        Knight knight = new Knight(Color.WHITE, new Square("b1"));
        chessboard.addPiece(knight);

        assertTrue(knight.canMove(chessboard, new Square("c3")));

    }

    @Test
    public void testKnightTake() {
        Chessboard chessboard = new ChessboardImpl();
        Knight white = new Knight(Color.WHITE, new Square("b1"));
        Knight black = new Knight(Color.BLACK, new Square("c3"));
        chessboard.addPiece(white);
        chessboard.addPiece(black);

        assertTrue(white.canMove(chessboard, new Square("c3")));
    }

    @Test
    public void testKnightCantTakeFriend() {
        Chessboard chessboard = new ChessboardImpl();
        Knight white1 = new Knight(Color.WHITE, new Square("b1"));
        Knight white2 = new Knight(Color.WHITE, new Square("c3"));
        chessboard.addPiece(white1);
        chessboard.addPiece(white2);

        assertFalse(white1.canMove(chessboard, new Square("c3")));
    }

    @Test
    public void testKnightHorizontalishMove() {
        Chessboard chessboard = new ChessboardImpl();
        Knight knight = new Knight(Color.WHITE, new Square("b1"));
        chessboard.addPiece(knight);

        assertTrue(knight.canMove(chessboard, new Square("d2")));
    }

}
