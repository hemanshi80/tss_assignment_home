package MainClass;

import java.util.Scanner;

import facade.GameFacade;

public class Main {

	 public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);

	        System.out.println("Welcome to Tic Tac Toe!");
	        System.out.print("Enter Player 1 name (X): ");
	        String player1 = scanner.nextLine();

	        System.out.print("Enter Player 2 name (O): ");
	        String player2 = scanner.nextLine();

	        GameFacade game = new GameFacade(player1, player2);

	        while (true) {
	            game.playGame();

	            System.out.print("Do you want to play again? (yes/no): ");
	            String response = scanner.nextLine().trim().toLowerCase();
	            if (!response.equals("yes")) {
	                System.out.println("Thanks for playing!");
	                break;
	            }

	            game.resetGame();
	        }

	        scanner.close();
	    }
	
}
