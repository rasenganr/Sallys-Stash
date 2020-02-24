package hw243.sallysstash;

import java.util.Scanner;

public class Guess {
    // Hava a guess of the rival's board
    private static boolean checkSquare(int row, int col, PlayerViewBoard selfView, PlayerViewBoard rivalView) {
        // Check rival's real board
        char target = rivalView.getSelfBoard().getBoard(row, col);
        // Incorrect guess
        if (target == ' ') {
            // Display 'X' as incorrect guess
            selfView.getRivalBoard().setBoard(row, col, 'X');
            return false;
        }
        // Correct guess
        else {
            // Display the square content of the rival board
            selfView.getRivalBoard().setBoard(row, col, target);
            // Mark the rival's square as '*'
            rivalView.getSelfBoard().setBoard(row, col, '*');
            return true;
        }
    }

    // One player makes a guess
  public static void guess(PlayerViewBoard pvb_self, PlayerViewBoard pvb_rival, Scanner sc) throws Exception {
        String guess = sc.nextLine();
        // Invalid input
        if (guess.length() != 2) {
            throw new Exception("Invalid input!");
        }
        int row = Label.rowToIndex(guess.charAt(0));
        int col = Label.colToIndex(guess.charAt(1));
        // Check if this square has been checked
        CommandChecker.checkGuess(row, col, pvb_self.getRivalBoard());
        // Player guess
        if (checkSquare(row, col, pvb_self, pvb_rival)) {
            System.out.println("You found a stack!");
        }
        else {
            System.out.println("You missed!");
        }
        pvb_self.printSelfView();
    }
}
