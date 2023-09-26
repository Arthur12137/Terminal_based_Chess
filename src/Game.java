package chess;

import java.util.Scanner;

public class Game {

    private static boolean gameEnd = false;

    /**
     * Method to facilitate the gameplay.
     */
    public static void play() {
        Scanner in = new Scanner(System.in);
        CheckInput ci = new CheckInput();
        PieceColour currentColor = PieceColour.WHITE;

        while (!gameEnd) {
            // Display the board and indicate whose move it is
            Board.printBoard();
            System.out.println("\n--------- " 
                + (currentColor == PieceColour.WHITE ? "Whites move" : "Blacks move") + " ---------");

            // Collect and validate the origin coordinate
            System.out.println("Enter origin:");
            String origin = in.next();
            if (!ci.checkCoordinateValidity(origin)) {
                System.out.println("Invalid move");
                continue;
            }

            // Collect and validate the destination coordinate
            System.out.println("Enter destination:");
            String destination = in.next();
            if (!ci.checkCoordinateValidity(destination)) {
                System.out.println("Invalid move");
                continue;
            }

            // Convert input strings to board coordinates
            int x1 = origin.charAt(0) - '1';
            int y1 = origin.charAt(1) - 'a';
            int x2 = destination.charAt(0) - '1';
            int y2 = destination.charAt(1) - 'a';

            // Check if move is valid for the selected piece
            Piece p = Board.getPiece(x1, y1);
            if (p == null || !p.isLegitMove(x1, y1, x2, y2) || p.getColor() != currentColor) {
                System.out.println("Invalid move");
                continue;
            }

            // Attempt to move the piece and check for game end condition
            if (Board.movePiece(x1, y1, x2, y2, p)) {
                gameEnd = true;
            }

            // Toggle the current player's color
            currentColor = (currentColor == PieceColour.BLACK) ? PieceColour.WHITE : PieceColour.BLACK;
        }
    }

    /**
     * Main method to start the game.
     */
    public static void main(String args[]) {
        Board.initialiseBoard();
        Board.initialisePieces();
        Game.play();
    }
}
