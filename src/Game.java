import java.util.Scanner;

public class Game {
    private Board board;
    private Player[] players;
    private int currentPlayerIndex;
    private int winCondition;

    public Game(int boardSize, Player[] players) {
        this.board = new Board(boardSize);
        this.players = players;
        this.currentPlayerIndex = 0;
        this.winCondition = (int) Math.sqrt(boardSize);
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        boolean gameFinished = false;

        while (!gameFinished) {
            Player currentPlayer = players[currentPlayerIndex];
            System.out.println("Player " + currentPlayer.getName() + "'s turn (" + currentPlayer.getMark() + ")");
            System.out.print("Enter row and column (comma separated): ");
            String[] input = scanner.nextLine().split(",");
            if (input.length != 2) {
                System.out.println("Invalid input. Please enter row and column separated by comma.");
                continue;
            }

            try {
                int row = Integer.parseInt(input[0].trim());
                int col = Integer.parseInt(input[1].trim());

                if (board.placeMark(row, col, currentPlayer.getMark())) {
                    board.printBoard();

                    char winner = board.checkForWin(winCondition);
                    if (winner != '-') {
                        System.out.println("Player " + currentPlayer.getName() + " wins!");
                        gameFinished = true;
                    } else if (board.isFull()) {
                        System.out.println("It's a draw!");
                        gameFinished = true;
                    } else {
                        currentPlayerIndex = (currentPlayerIndex + 1) % players.length;
                    }
                } else {
                    System.out.println("Invalid move. Please try again.");
                }
            } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                System.out.println("Invalid input. Please enter valid row and column numbers.");
            }
        }

        scanner.close();
    }

    
}
