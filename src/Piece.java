package chess;


//This class requires your input
public abstract class Piece {

    private String symbol;
    protected PieceColour color;

    public Piece(String symbol, PieceColour color) {
        this.symbol = symbol;
        this.color = color;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public PieceColour getColor() {
        return color;
    }

    public abstract boolean isLegitMove(int x1, int y1, int x2, int y2);
}
