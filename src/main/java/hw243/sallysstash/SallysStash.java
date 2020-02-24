package hw243.sallysstash;

import java.util.Scanner;

public class SallysStash {
  private Board bd1;
  private Board bd2;
  private PlayerViewBoard pvb1;
  private PlayerViewBoard pvb2;
  Scanner sc;
  
  // Constructor
  public SallysStash(Scanner _sc) {
    bd1 = new Board();
    bd2 = new Board();
    pvb1 = new PlayerViewBoard(true, bd1);
    pvb2 = new PlayerViewBoard(false, bd2);
    sc = _sc;
  }
  
  // Play the game
  public void play() {
     // Place stacks
    prepare();
    System.out.println("[Press Enter to start]");
    sc.nextLine();
    // Play the game
    startGame();
  }
  
  // Print the congratulation message
  private void printWinner(char winner) {
    System.out.println("\n\n\n");
    System.out.println("-------------------------------");
    System.out.println("| --------------------------- |");
    System.out.println("| | Player " + winner + " wins the game! | |");
    System.out.println("| --------------------------- |");
    System.out.println("-------------------------------");
  }
  
  // Prepare for the game
  private void prepare() {
    // Preparation step for player A
    GamePrepare gp1 = new GamePrepare('A');
    gp1.prepare(bd1, sc);
    System.out.println("\n\n\n\n\n\n\n\n\n\n");
    // Preparation step for player B
    GamePrepare gp2 = new GamePrepare('B');
    gp2.prepare(bd2, sc);
    System.out.println("\n\n\n\n\n\n\n\n\n\n");
    System.out.println("Preparation finished!");
  }
  
  // Start the game
  private void startGame() {
    int i = 0;
    char winner = 'N';
    // Keep playing the game
    while (true) {
      PlayerViewBoard pvb_self;
      PlayerViewBoard pvb_rival;
      char player;
      // Player A's turn
      if (i == 0) {
        pvb_self = pvb1;
        pvb_rival = pvb2;
        player = 'A';
      }
      // Player B's turn
      else {
        pvb_self = pvb2;
        pvb_rival = pvb1;
        player = 'B';
      }
      // Print current player's view
      pvb_self.printSelfView();
      // Prompt the player to guess
      System.out.println("\nPlayer " + player + ", have a guess!");
      try {
        Guess.guess(pvb_self, pvb_rival, sc);
      } catch (Exception ex) {
        System.out.println(ex.getMessage());
        continue;
      }
      // Check if anyone wins the game
      winner = WinnerChecker.checkWinner(pvb_rival.getSelfBoard(), player);
      // There is a winner
      // Game over and print the congratulation message
      if (winner != 'N') {
        printWinner(winner);
        break;
      }
      // No winner
      // Exchange to the other player
      else {
        System.out.println("\n\n\n\n\n\n\n\n\n\n");
        i = (i + 1) % 2;
      }
    }
  }
}
