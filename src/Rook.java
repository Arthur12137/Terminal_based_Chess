package chess;


public class Rook extends Piece {

    public Rook(PieceColour color) {
        super(color == PieceColour.BLACK ? "\u265C" : "\u2656", color);
    }

    public boolean isLegitMove(int x1, int y1, int x2, int y2) {
        //invalid move
        if (x1 != x2 && y1 == y2 || x1 == x2 && y1 != y2) {
            if (x1 != x2) {
                if (x1 > x2) {
                    int i = -1;
                    while (Math.abs(i) < Math.abs(x1 - x2)) {
                        if (Board.hasPiece(x1 + i, y1))
                            return false;
                        i--;
                    }
                } else {
                    int i = 1;
                    while (Math.abs(i) < Math.abs(x1 - x2)) {
                        if (Board.hasPiece(x1 + i, y1))
                            return false;
                        i++;
                    }
                }
            } else {
                if (y1 > y2) {
                    int i = -1;
                    while (Math.abs(i) < Math.abs(y1 - y2)) {
                        if (Board.hasPiece(x1, y1 + i))
                            return false;
                        i--;
                    }
                } else {
                    int i = 1;
                    while (Math.abs(i) < Math.abs(y1 - y2)) {
                        if (Board.hasPiece(x1, y1 + i))
                            return false;
                        i++;
                    }
                }
            }

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
        return false;
    }

}
