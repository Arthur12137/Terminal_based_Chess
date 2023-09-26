package chess;


public class Queen extends Piece {

    public Queen(PieceColour color) {
        super(color == PieceColour.BLACK ? "\u265B" : "\u2655", color);
    }

    public boolean isLegitMove(int x1, int y1, int x2, int y2) {
        if (x1 == x2 || y1 == y2) {
            if (y1 == y2) {
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
            } else if (x1 == x2) {
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
        } else {
            if (Math.abs(x1 - x2) != Math.abs(y1 - y2))
                return false;
            if (x1 > x2) {
                if (y1 > y2) {
                    int i = -1, j = -1;
                    while (Math.abs(i) < Math.abs(x1 - x2)) {
                        if (Board.hasPiece(x1 + i, y1 + j))
                            return false;
                        i--;
                        j--;
                    }
                } else {
                    int i = -1, j = 1;
                    while (Math.abs(i) < Math.abs(x1 - x2)) {
                        if (Board.hasPiece(x1 + i, y1 + j))
                            return false;
                        i--;
                        j++;
                    }
                }
            } else {
                if (y1 > y2) {
                    int i = 1, j = -1;
                    while (Math.abs(i) < Math.abs(x1 - x2)) {
                        if (Board.hasPiece(x1 + i, y1 + j))
                            return false;
                        i++;
                        j--;
                    }
                } else {
                    int i = 1, j = 1;
                    while (Math.abs(i) < Math.abs(x1 - x2)) {
                        if (Board.hasPiece(x1 + i, y1 + j))
                            return false;
                        i++;
                        j++;
                    }
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

}
