package ax.ha.tdd.chess.engine;

import ax.ha.tdd.chess.console.ChessboardWriter;
import ax.ha.tdd.chess.engine.pieces.ChessPiece;
import ax.ha.tdd.chess.engine.pieces.Pawn;
import ax.ha.tdd.chess.engine.pieces.PieceType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PawnTests {

    //If you use exceptions for your illegal moves, change this test to expect an exception instead.
    @Test
    public void testMoveMoreThanTwoSquaresAtStartShouldBeIllegal(){
        //Arrange
        Game game = new GameImpl();

        //Act
        game.move("e2-e5"); //if you use real chess notation in your implementation, use simply "e5"

        //Assert
        assertEquals(Color.WHITE, game.getPlayerToMove());
        ChessPiece piece = game.getBoard().getPieceAt(new Square("e2"));
        assertEquals(Color.WHITE, piece.getColor());
        assertEquals(PieceType.PAWN, piece.getType());


        //For debugging, you can print the board to console, or if you want
        //to implement a command line interface for the game
        System.out.println(new ChessboardWriter().print(game.getBoard()));

    }

    @Test
    public void testWhitePawnForwardOneStepUnblocked(){
        //Here's a lower level test, we just check that the internal logic of the pawn is correct.
        //We should be allowed to move one step forward to an empty square
        Chessboard chessboard = new ChessboardImpl();
        Pawn e2 = new Pawn(Color.WHITE, new Square("e2"));
        assertTrue(e2.canMove(chessboard, new Square("e3")));
    }
}
