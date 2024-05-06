package ax.ha.tdd.chess.engine.pieces;

import ax.ha.tdd.chess.engine.Chessboard;
import ax.ha.tdd.chess.engine.Color;
import ax.ha.tdd.chess.engine.Square;

public class Knight extends ChessPieceBase implements ChessPiece {
    public Knight(Color player, Square location) {
        super(PieceType.KNIGHT, player, location);
    }

    @Override
    public boolean canMove(Chessboard chessboard, Square destination) {
        if(chessboard.getPieceAt(destination) != null && chessboard.getPieceAt(destination).getType() == PieceType.KING) {
            return false;
        }
        if(destination.getY() == this.location.getY() + 2 || destination.getY() == this.location.getY() - 2) {
            if(destination.getY() == this.location.getX() - 1 || destination.getX() == this.location.getX() + 1) {
                if(chessboard.getPieceAt(destination) != null && chessboard.getPieceAt(destination).getColor() != this.color) {
                    chessboard.removePieceAt(destination);
                    return true;
                } else return chessboard.getPieceAt(destination) == null || chessboard.getPieceAt(destination).getColor() != this.color;
            }
        } else if (destination.getX() == this.location.getX() + 2 || destination.getX() == this.location.getX() - 2) {
            if(destination.getY() == this.location.getY() - 1 || destination.getY() == this.location.getY() + 1) {
                if(chessboard.getPieceAt(destination) != null && chessboard.getPieceAt(destination).getColor() != this.color) {
                    chessboard.removePieceAt(destination);
                    return true;
                } else return chessboard.getPieceAt(destination) == null || chessboard.getPieceAt(destination).getColor() != this.color;
            }
        }
        return false;
    }
}
