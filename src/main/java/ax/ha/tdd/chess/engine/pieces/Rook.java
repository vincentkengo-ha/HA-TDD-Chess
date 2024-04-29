package ax.ha.tdd.chess.engine.pieces;

import ax.ha.tdd.chess.engine.Chessboard;
import ax.ha.tdd.chess.engine.Color;
import ax.ha.tdd.chess.engine.Square;

public class Rook extends ChessPieceBase implements ChessPiece {

    public Rook(Color player, Square location) {
        super(PieceType.ROOK, player, location);
    }

    @Override
    public boolean canMove(Chessboard chessboard, Square destination) {
        //check for take move first
        // normal move
        //might have to check for blocks
        if(this.location.getX() == destination.getX()) {
            if(this.location.getY() > destination.getY()) {
                for(int i = this.location.getY() - 1; i > destination.getY(); i--) {
                    if(chessboard.getPieceAt(new Square(this.location.getX(), i)) != null) {
                        return false;
                    }
                }
            } else {
                for (int i = this.location.getY() + 1; i < destination.getY(); i++) {
                    if(chessboard.getPieceAt(new Square(this.location.getX(), i)) != null) {
                        return false;
                    }
                }
            }
            if(chessboard.getPieceAt(destination) != null && chessboard.getPieceAt(destination).getColor() != this.color) {
                chessboard.removePieceAt(destination);
            } else return chessboard.getPieceAt(destination) == null || chessboard.getPieceAt(destination).getColor() != this.color;
            return true;
        } else if (this.location.getY() == destination.getY()) {
            if(this.location.getX() > destination.getX()) {
                for(int i = this.location.getX() - 1; i > destination.getX(); i--) {
                    if(chessboard.getPieceAt(new Square(i, this.location.getY())) != null) {
                        return false;
                    }
                }
            } else {
                for (int i = this.location.getX() + 1; i < destination.getX(); i++) {
                    if(chessboard.getPieceAt(new Square(i, this.location.getY())) != null) {
                        return false;
                    }
                }
            }
            if(chessboard.getPieceAt(destination) != null && chessboard.getPieceAt(destination).getColor() != this.color) {
                chessboard.removePieceAt(destination);
            } else return chessboard.getPieceAt(destination) == null || chessboard.getPieceAt(destination).getColor() != this.color;
            return true;
        }

        //take move

        return false;
    }
}
