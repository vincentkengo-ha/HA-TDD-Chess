package ax.ha.tdd.chess.engine.pieces;

import ax.ha.tdd.chess.engine.Chessboard;
import ax.ha.tdd.chess.engine.Color;
import ax.ha.tdd.chess.engine.Square;

import java.util.Objects;

public class Bishop extends ChessPieceBase implements ChessPiece{
    public Bishop(Color player, Square location) {
        super(PieceType.BISHOP, player, location);
    }

    @Override
    public boolean canMove(Chessboard chessboard, Square destination) {
        if(chessboard.getPieceAt(destination) != null && chessboard.getPieceAt(destination).getType() == PieceType.KING) {
            return false;
        }
        if(Math.abs(this.location.getX() - destination.getX()) != Math.abs(this.location.getY() - destination.getY()) || Objects.equals(this.location.toAlgebraic(), destination.toAlgebraic())) {
            return false;
        }

        int xDir;
        int yDir;
        if(destination.getX() > this.location.getX()) {
            xDir = 1;
        } else {
            xDir = -1;
        }
        if(destination.getY() > this.location.getY()) {
            yDir = 1;
        } else {
            yDir = -1;
        }

        int currentX = this.location.getX() + xDir;
        int currentY = this.location.getY();
        while(currentY != destination.getY() - yDir) {
            currentY += yDir;
            if(chessboard.getPieceAt(new Square(currentX, currentY)) != null) {
                return false;
            }
            currentX += xDir;
        }
        if(chessboard.getPieceAt(destination) != null && chessboard.getPieceAt(destination).getColor() != this.color){
            chessboard.removePieceAt(destination);
        } else if (chessboard.getPieceAt(destination) != null && chessboard.getPieceAt(destination).getColor() == this.color){
            return false;
        }
        return true;
    }
}
