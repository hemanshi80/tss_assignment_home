package facade;

import java.util.Scanner;

import model.Board;
import model.MarkType;
import player.Player;

public class GameFacade {
	
	 private final Board board;
	    private final Player player1;
	    private final Player player2;
	    private Player currentPlayer;

	    public GameFacade(String player1Name, String player2Name) {
	        this.board = new Board();
	        this.player1 = new Player(player1Name, MarkType.X);
	        this.player2 = new Player(player2Name, MarkType.O);
	        this.currentPlayer = player1;
	    }

	    public void playGame() {
	        Scanner scanner = new Scanner(System.in);
	        board.displayBoard();

	        while (true) {
	            System.out.println(currentPlayer.getName() + "'s turn (" + currentPlayer.getMark() + ")");
	            System.out.print("Enter row (0-2): ");
	            int row = scanner.nextInt();
	            System.out.print("Enter col (0-2): ");
	            int col = scanner.nextInt();

	            if (!board.isCellEmpty(row, col)) {
	                System.out.println("Cell already marked. Try again.");
	                continue;
	            }

	            board.setMark(row, col, currentPlayer.getMark());
	            board.displayBoard();

	            if (board.checkWinner(currentPlayer.getMark())) {
	                System.out.println(currentPlayer.getName() + " wins!");
	                break;
	            }

	            if (board.isBoardFull()) {
	                System.out.println("It's a draw!");
	                break;
	            }

	            switchPlayer();
	        }
	    }

	    public void resetGame() {
	        board.emptyBoard();
	        currentPlayer = player1;
	        System.out.println("Game reset.");
	    }

	    private void switchPlayer() {
	        currentPlayer = (currentPlayer == player1) ? player2 : player1;
	    }

}
