package ax.ha.tdd.chess.console;

import ax.ha.tdd.chess.engine.ChessboardImpl;
import ax.ha.tdd.chess.engine.Square;
import ax.ha.tdd.chess.engine.Player;
import ax.ha.tdd.chess.engine.pieces.ChessPieceStub;
import ax.ha.tdd.chess.engine.pieces.PieceType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ChessboardWriterTests {

    @Test
    public void print_emptyChessboard_printsOkay() {
        final String expectedChessboard= 
                " *    *    *    *    *    *    *    * \n\n" +

                " *    *    *    *    *    *    *    * \n\n" +

                " *    *    *    *    *    *    *    * \n\n" +

                " *    *    *    *    *    *    *    * \n\n" +
                                            
                " *    *    *    *    *    *    *    * \n\n" +
                                            
                " *    *    *    *    *    *    *    * \n\n" +
                                            
                " *    *    *    *    *    *    *    * \n\n" +
                                            
                " *    *    *    *    *    *    *    * \n";
        Assertions.assertEquals(expectedChessboard, new ChessboardWriter().print(new ChessboardImpl()));
    }

    @Test
    public void print_chessboardWithSinglePawn_printsOkay() {
        final String expectedChessboard=
                " *    *    *    *    *    *    *    * \n\n" +

                " *    *    *    *    *    *    *    * \n\n" +

                " *    *    *    *    *    *    *    * \n\n" +

                " *    *    *    *    *    *    *    * \n\n" +

                " *    *   B-P   *    *    *    *    * \n\n" +

                " *    *    *    *    *    *    *    * \n\n" +

                " *    *    *    *    *    *    *    * \n\n" +

                " *    *    *    *    *    *    *    * \n";
        ChessboardImpl chessboard = new ChessboardImpl();
        chessboard.addPiece(new ChessPieceStub(PieceType.PAWN, Player.BLACK, new Square(2, 4)));
        Assertions.assertEquals(expectedChessboard, new ChessboardWriter().print(chessboard));
    }

    @Test
    public void print_fullChessboard_printsOkay() {
        final String expectedChessboard=
               "B-R  B-K  B-B  B-Q  B-K  B-B  B-K  B-R\n\n" +
                                            
               "B-P  B-P  B-P  B-P  B-P  B-P  B-P  B-P\n\n" +
                                            
               " *    *    *    *    *    *    *    * \n\n" +
                                            
               " *    *    *    *    *    *    *    * \n\n" +
                                            
               " *    *    *    *    *    *    *    * \n\n" +
                                            
               " *    *    *    *    *    *    *    * \n\n" +
                                            
               "W-P  W-P  W-P  W-P  W-P  W-P  W-P  W-P\n\n" +
                                            
               "W-R  W-K  W-B  W-Q  W-K  W-B  W-K  W-R\n";
        final ChessboardImpl chessboard = ChessboardImpl.startingBoard();

        Assertions.assertEquals(expectedChessboard, new ChessboardWriter().print(chessboard));
    }
}
