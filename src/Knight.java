package chess;


public class Knight extends Piece {

    public Knight(PieceColour color) {
        super(color == PieceColour.BLACK ? "\u265E" : "\u2658", color);
    }

    public boolean isLegitMove(int x1, int y1, int x2, int y2) {
        return false;
    }

}
