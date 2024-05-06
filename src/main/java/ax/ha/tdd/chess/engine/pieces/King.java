package ax.ha.tdd.chess.engine.pieces;

import ax.ha.tdd.chess.engine.Chessboard;
import ax.ha.tdd.chess.engine.Color;
import ax.ha.tdd.chess.engine.Square;

public class King extends ChessPieceBase implements ChessPiece {
    public King(Color player, Square location) {
        super(PieceType.KING, player, location);
    }

    @Override
    public boolean canMove(Chessboard chessboard, Square destination) {
        if(chessboard.getPieceAt(destination) != null && chessboard.getPieceAt(destination).getType() == PieceType.KING) {
            return false;
        }

        //threatened
        for(int r = 0; r < 8; r++) {
            for(int c = 0; c < 8; c++) {
                if(chessboard.getPieceAt(new Square(r ,c)) != null && chessboard.getPieceAt(new Square(r ,c)).getColor() != this.getColor()) {
                    if(chessboard.getPieceAt(new Square(r ,c)).canMove(chessboard, destination)) {
                        return false;
                    }
                }
            }
        }

        boolean validY = destination.getY() <= this.location.getY() + 1 && destination.getY() >= this.location.getY() - 1;
        boolean validX = destination.getX() <= this.location.getX() + 1 && destination.getX() >= this.location.getX() - 1;
        if(validX && validY && destination != this.location) {
            if(chessboard.getPieceAt(destination) != null && chessboard.getPieceAt(destination).getColor() != this.getColor()) {
                chessboard.removePieceAt(destination);
                return true;
            } else if (chessboard.getPieceAt(destination) != null && chessboard.getPieceAt(destination).getColor() == this.getColor()) {
                return false;
            }
            return true;
        }
        return false;
    }
}
