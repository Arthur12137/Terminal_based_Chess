package chess;

public class Board {

    private static final int BOARD_SIZE = 8;
    private static Square[][] board = new Square[BOARD_SIZE][BOARD_SIZE];

    public static void initialiseBoard() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                board[i][j] = new Square();
            }
        }
    }

    public static void initialisePieces() {
        setupPawns();
        setupMajorPieces();
    }

    private static void setupPawns() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            board[1][i].setPiece(new Pawn(PieceColour.BLACK));
            board[6][i].setPiece(new Pawn(PieceColour.WHITE));
        }
    }

    private static void setupMajorPieces() {
        PieceColour[] colors = {PieceColour.BLACK, PieceColour.WHITE};
        int[] rows = {0, 7};
        for (int idx = 0; idx < 2; idx++) {
            board[rows[idx]][0].setPiece(new Rook(colors[idx]));
            board[rows[idx]][1].setPiece(new Knight(colors[idx]));
            board[rows[idx]][2].setPiece(new Bishop(colors[idx]));
            board[rows[idx]][3].setPiece(new Queen(colors[idx]));
            board[rows[idx]][4].setPiece(new King(colors[idx]));
            board[rows[idx]][5].setPiece(new Bishop(colors[idx]));
            board[rows[idx]][6].setPiece(new Knight(colors[idx]));
            board[rows[idx]][7].setPiece(new Rook(colors[idx]));
        }
    }

    public static void printBoard() {
        System.out.print("\n  a b c d e f g h \n");
        System.out.print("  -----------------\n");
        for (int i = 0; i < BOARD_SIZE; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < BOARD_SIZE; j++) {
                System.out.print(Board.hasPiece(i, j) ? Board.getPiece(i, j).getSymbol() : " ");
                System.out.print(j < BOARD_SIZE - 1 ? "|" : "  " + (i + 1));
            }
            System.out.println();
        }
        System.out.print("  -----------------\n  a b c d e f g h \n");
    }

    public static boolean movePiece(int x1, int y1, int x2, int y2, Piece p) {
        if (p.isLegitMove(x1, y1, x2, y2)) {
            if (board[x2][y2].hasPiece() && board[x2][y2].getPiece() instanceof King) {
                board[x2][y2].setPiece(board[x1][y1].getPiece());
                board[x1][y1].removePiece();
                return true;
            }
            board[x2][y2].setPiece(board[x1][y1].getPiece());
            board[x1][y1].removePiece();
        }
        return false;
    }

    public static void setPiece(int x, int y, Piece p) {
        board[x][y].setPiece(p);
    }

    public static Piece getPiece(int x, int y) {
        return board[x][y].getPiece();
    }

    public static boolean hasPiece(int x, int y) {
        return board[x][y].hasPiece();
    }
}
