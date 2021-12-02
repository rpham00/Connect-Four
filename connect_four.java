import java.util.Scanner;

/* Game: Connect Four
* Author: Rachel Pham
* Direction: Player is given a board. Player must connect four consecutive tiles in 
*              either vertical, horizontal, or diagonal order
*/

class ConnectFour {
    public static void main(String[] args) {
        // Initialize variables

        Scanner in = new Scanner(System.in); // Takes input from terminal
        char[][] board = new char[6][7]; // double array game board
        int turn = 1; // turn counter
        char player = 'R'; // player
        boolean winner = false; // keeps game going

        System.out.println("\nWelcome to Connect Four\n");
        System.out.println("How To Play: Player is given a board. Player"
                + " must connect four consecutive tiles in"
                + " either vertical, \n horizontal, or diagonal order\n");

        // initialize array
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                board[row][col] = ' ';
            }
        }

        // play a turn
        while (winner == false && turn <= 42) {
            boolean validPlay; // keeps game going
            int input; // stores input from terminal + convert string to int

            do {
                // display current game board
                display(board);

                System.out.print("Player " + player + ", choose a column: ");
                input = in.nextInt();

                // validate play
                validPlay = validate(input, board);

            } while (validPlay == false);

            // drop the checker
            for (int row = board.length - 1; row >= 0; row--) {
                if (board[row][input] == ' ') {
                    board[row][input] = player;
                    break;
                }
            }

            // determine if there is a winner
            winner = isWinner(player, board);

            // switch players
            if (player == 'R') {
                player = 'B';
            } else {
                player = 'R';
            }

            turn++;
        }

        // Calls method to display game board
        display(board);

        // Congratulations Message
        if (winner) {
            if (player == 'R') {
                System.out.println("Black Player Won\n");
            } else {
                System.out.println("Red Player Won\n");
            }
        } else {
            System.out.println("Both Players lost\n");
        }

    }

    // Method to display game board
    public static void display(char[][] grid) {
        System.out.println(" 0 1 2 3 4 5 6");
        System.out.println("---------------");
        for (int row = 0; row < grid.length; row++) {
            System.out.print("|");
            for (int col = 0; col < grid[0].length; col++) {
                System.out.print(grid[row][col]);
                System.out.print("|");
            }
            System.out.println();
            System.out.println("---------------");
        }
        System.out.println(" 0 1 2 3 4 5 6");
        System.out.println();
    }// End of display() method

    // Method to check if space is available
    public static boolean validate(int column, char[][] grid) {
        // valid column?
        if (column < 0 || column > grid[0].length) {
            return false;
        }

        // full column?
        if (grid[0][column] != ' ') {
            return false;
        }

        return true;
    }// end of validate() method

    // Method that checks for 4 in a row
    public static boolean isWinner(char player, char[][] grid) {

        // Check for horizontal win
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length - 3; col++) {
                if (grid[row][col] == player &&
                        grid[row][col + 1] == player &&
                        grid[row][col + 2] == player &&
                        grid[row][col + 3] == player) {
                    return true;
                }
            }
        }
        // Check for vertical win
        for (int row = 0; row < grid.length - 3; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == player &&
                        grid[row + 1][col] == player &&
                        grid[row + 2][col] == player &&
                        grid[row + 3][col] == player) {
                    return true;
                }
            }
        }
        // Check for upward diagonal win
        for (int row = 3; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length - 3; col++) {
                if (grid[row][col] == player &&
                        grid[row - 1][col + 1] == player &&
                        grid[row - 2][col + 2] == player &&
                        grid[row - 3][col + 3] == player) {
                    return true;
                }
            }
        }
        // Check for downward diagonal
        for (int row = 0; row < grid.length - 3; row++) {
            for (int col = 0; col < grid[0].length - 3; col++) {
                if (grid[row][col] == player &&
                        grid[row + 1][col + 1] == player &&
                        grid[row + 2][col + 2] == player &&
                        grid[row + 3][col + 3] == player) {
                    return true;
                }
            }
        }

        // Returns false if there is no winnerd detected
        return false;
    }// end of isWinner() method
}
