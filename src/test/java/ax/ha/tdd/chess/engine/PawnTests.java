package ax.ha.tdd.chess.engine;

import ax.ha.tdd.chess.console.ChessboardWriter;
import ax.ha.tdd.chess.engine.pieces.ChessPiece;
import ax.ha.tdd.chess.engine.pieces.Pawn;
import ax.ha.tdd.chess.engine.pieces.PieceType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PawnTests {

    @Test
    public void testMovePawnBackwardsShouldBeIllegal() {
        //Arrange
        Chessboard chessboard = new ChessboardImpl();
        Pawn pawn = new Pawn(Color.WHITE, new Square("e2"));
        chessboard.addPiece(pawn);

        //Assert
        assertFalse(pawn.canMove(chessboard, new Square("e1")));
        assertFalse(pawn.canMove(chessboard, new Square("e2")));

        //For debugging, you can print the board to console, or if you want
        //to implement a command line interface for the game
        System.out.println(new ChessboardWriter().print(chessboard));
    }

    @Test
    public void testFirstMove() {
        //Pawn should be able to move 2 steps forward on its first move
        Chessboard chessboard = new ChessboardImpl();
        Pawn pawn = new Pawn(Color.WHITE, new Square("e2"));
        chessboard.addPiece(pawn);

        //Assert
        assertTrue(pawn.canMove(chessboard, new Square("e4")));
    }

    @Test
    public void testObstructedFirstMove() {
        Chessboard chessboard = new ChessboardImpl();
        Pawn white = new Pawn(Color.WHITE, new Square("e2"));
        Pawn black = new Pawn(Color.BLACK, new Square("e4"));
        chessboard.addPiece(white);
        chessboard.addPiece(black);

        assertFalse(white.canMove(chessboard, new Square("e4")));
    }

    @Test
    public void testNormalMove() {
        Chessboard chessboard = new ChessboardImpl();
        Pawn pawn = new Pawn(Color.WHITE, new Square("e3"));
        chessboard.addPiece(pawn);

        assertTrue(pawn.canMove(chessboard, new Square("e4")));
    }

    @Test
    public void testWhiteTakeBlack() {
        Chessboard chessboard = new ChessboardImpl();
        Pawn white = new Pawn(Color.WHITE, new Square("e4"));
        Pawn black = new Pawn(Color.BLACK, new Square("d5"));
        chessboard.addPiece(white);
        chessboard.addPiece(black);

        System.out.println("Before take move");
        System.out.println(new ChessboardWriter().print(chessboard));

        //Assert
        assertTrue(white.canMove(chessboard, new Square("d5")));

        System.out.println("After take move");
        System.out.println(new ChessboardWriter().print(chessboard));
        //Piece not actually moving why?
    }

}
