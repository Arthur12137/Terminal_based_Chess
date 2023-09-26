package chess;

public class Bishop extends Piece {

    public Bishop(PieceColour color) {
        super(color == PieceColour.BLACK ? "\u265D" : "\u2657", color);
    }

    public boolean isLegitMove(int x1, int y1, int x2, int y2) {
        // Ensure the movement is diagonal
        if (Math.abs(x1 - x2) != Math.abs(y1 - y2)) {
            return false;
        }

        // Determine movement direction
        int xDirection = (x2 - x1) > 0 ? 1 : -1;
        int yDirection = (y2 - y1) > 0 ? 1 : -1;

        // Check path for obstructions
        int i = x1 + xDirection;
        int j = y1 + yDirection;
        while (i != x2 && j != y2) {
            if (Board.hasPiece(i, j)) {
                return false;
            }
            i += xDirection;
            j += yDirection;
        }

        // Ensure destination square is empty or has opponent's piece
        Piece p = Board.getPiece(x2, y2);
        if (p != null && p.getColor() == this.color) {
            return false;
        }

        return true;
    }
}
