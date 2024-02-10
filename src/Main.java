import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Tic Tac Toe!");
        System.out.print("Enter the size of the board (3 for 3x3, 5 for 5x5, 9 for 9x9): ");
        int boardSize = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        Player player1 = new Player("X", 'X');
        Player player2 = new Player("O", 'O');
        Player[] players = {player1, player2};

        Game game = new Game(boardSize, players);
        game.start();

        scanner.close();
    }

}
