import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConnectFour {
    int boardWidth = 7;
    int boardHeight = 7;
    int totalMovesPlayed;
    int player1Turn = 1;
    int player2Turn = 0;
    int[][] board;

    public ConnectFour(int boardWidth, int boardHeight) {
        board = new int[boardHeight][boardWidth];
        totalMovesPlayed = 0;
    }

    public void reset() {
        totalMovesPlayed = 0;
        for (int q = 0; q < boardWidth; q++) {
            for (int w = 0; w < boardHeight; w++) {
                board[q][w] = 0;
            }
        }
    }

    // run Connect 4 in the GUI
    public void runBoard(int column) {
        // Player 1
        if (player1Turn == 1) {
            System.out.println("\n\nPlayer 1 play:");
            if (isPlayable(column)) {
                player1Turn = 0;
                player2Turn = 1;
                if (playMove(column, 1)) {
                    printBoard();
                    System.out.println("\n\nPlayer 1 wins!!!");
                    player1Turn = 3;
                    player2Turn = 0;
                }
            } else {
                System.out.println("Column " + column + " is already full!!");
            }
            printBoard();
        }

        // Player 2
        else if (player2Turn == 1) {
            System.out.println("\n\nPlayer 2 play:");
            player1Turn = 1;
            player2Turn = 0;
            if (isPlayable(column)) {
                if (playMove(column, 2)) {
                    printBoard();
                    System.out.println("\n\nPlayer 2  wins!!!");
                    player1Turn = 0;
                    player2Turn = 3;
                }
            } else {
                System.out.println("Column " + column + " is already full!!");
            }
            printBoard();
        }

        if (isFull()) {
            player1Turn = 4;
            player2Turn = 4;
            System.out.print("Game drawn. Both of you suck at this!!! ");
        }
    }

    public void printBoard() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 0) {
                    System.out.print("_  ");
                } else {
                    System.out.print(board[i][j] + "  ");
                }
                System.out.println();
            }
        }

        for (int i = 0; i < boardWidth; i++) {
            System.out.print("*  ");
        }
        System.out.println();

        for (int i = 0; i < boardWidth; i++) {
            System.out.print(i + "  ");
        }
        System.out.println();
    }

}