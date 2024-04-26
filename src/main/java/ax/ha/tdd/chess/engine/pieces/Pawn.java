package ax.ha.tdd.chess.engine.pieces;

import ax.ha.tdd.chess.engine.Chessboard;
import ax.ha.tdd.chess.engine.Square;
import ax.ha.tdd.chess.engine.Color;

import java.util.Objects;

public class Pawn extends ChessPieceBase implements ChessPiece{

    public Pawn(Color player, Square location) {
        super(PieceType.PAWN, player, location);
    }

    @Override
    public boolean canMove(Chessboard chessboard, Square destination) {
        //TODO here goes move logic for pawns

        //first move
        System.out.println(this.location.getY() + " " + destination.getY());
        System.out.println(this.location.getX() + " " + destination.getX());
        if(this.color == Color.WHITE) {
            if(this.location.getY() == 6) {
                if(this.location.getX() == destination.getX() && this.location.getY() - destination.getY() == 2){
                    return chessboard.getPieceAt(new Square(this.location.getX(), this.location.getY() - 1)) == null && chessboard.getPieceAt(new Square(this.location.getX(), this.location.getY() - 2)) == null;
                }
            }
        } else if (this.color == Color.BLACK) {
            if(this.location.getY() == 1){
                if(this.location.getX() == destination.getX() && this.location.getY() - destination.getY() == -2){
                    return chessboard.getPieceAt(new Square(this.location.getX(), this.location.getY() + 1)) == null && chessboard.getPieceAt(new Square(this.location.getX(), this.location.getY() + 2)) == null;
                }
            }
        }

        //normal move
        if(this.color == Color.WHITE) {
            if(this.location.getY() > destination.getY() && this.location.getX() == destination.getX()) {
                return chessboard.getPieceAt(new Square(this.location.getX(), this.location.getY() + 1) ) == null;
            }
        }
        if(this.color == Color.BLACK) {
            if(this.location.getY() < destination.getY() && this.location.getX() == destination.getX()) {
                return chessboard.getPieceAt(new Square(this.location.getX(), this.location.getY() - 1) ) == null;
            }
        }
        
        //take move
        if(this.color == Color.WHITE) {
            if(destination.getY() == this.location.getY() - 1 && (destination.getX() == this.location.getX() + 1 || destination.getX() == this.location.getX() - 1)) {
                if(chessboard.getPieceAt(new Square(destination.getX(), destination.getY())).getColor() == Color.BLACK) {
                    chessboard.removePieceAt(new Square(destination.getX(), destination.getY()));
                    return true;
                }
            }
        }
        if(this.color == Color.BLACK) {
            if(destination.getY() == this.location.getY() + 1 && (destination.getX() == this.location.getX() + 1 || destination.getX() == this.location.getX() - 1)) {
                if(chessboard.getPieceAt(new Square(destination.getX(), destination.getY())).getColor() == Color.WHITE) {
                    chessboard.removePieceAt(new Square(destination.getX(), destination.getY()));
                    return true;
                }
            }
        }

        //en passant if not lazy

        return false;
    }
}
