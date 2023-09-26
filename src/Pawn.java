package chess;


public class Pawn extends Piece {

    public Pawn(PieceColour color) {
        super(color == PieceColour.BLACK ? "\u265F" : "\u2659", color);
    }

    public boolean isLegitMove(int x1, int y1, int x2, int y2) {
        Piece p = Board.getPiece(x2, y2);
        if (y1 != y2 && p == null)
            return false;
        if (y1 == y2 && p != null)
            return false;
        //white piece
        if (color == PieceColour.WHITE) {
            //can't eat white piece
            if (p != null && p.getColor() == PieceColour.WHITE)
                return false;
            //valid moves
            if (x1 == 6 && x1 - x2 == 2 && y1 == y2)
                return true;
            if (x1 - x2 == 1 && Math.abs(y1 - y2) <= 1)
                return true;
        } //black piece
        else {
            //can't eat black piece
            if (p != null && p.getColor() == PieceColour.BLACK)
                return false;
            //valid moves
            if (x1 == 1 && x2 - x1 == 2 && y1 == y2)
                return true;
            if (x2 - x1 == 1 && Math.abs(y1 - y2) <= 1)
                return true;
        }
        //invalid move
        return false;
    }

}
