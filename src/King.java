package chess;


public class King extends Piece {

    public King(PieceColour color) {
        super(color == PieceColour.BLACK ? "\u265A" : "\u2654", color);
    }

    public boolean isLegitMove(int x1, int y1, int x2, int y2) {
        if (Math.abs(x1 - x2) > 1 || Math.abs(y1 - y2) > 1)
            return false;
        Piece p = Board.getPiece(x2, y2);
        //white piece
        if (color == PieceColour.WHITE) {
            //can't eat white piece
            if (p != null && p.getColor() == PieceColour.WHITE)
                return false;
        } //black piece
        else {
            //can't eat black piece
            if (p != null && p.getColor() == PieceColour.BLACK)
                return false;
        }
        return true;
    }

}
