package hw243.sallysstash;

import java.util.HashMap;
import java.util.Scanner;

public class GamePrepare {
    // Player name
    char player;
    // Stacks to be placed
    Stack[] stacks;
    // Hash Table: Color Character - Color word
    HashMap<Character, String> mp;

    // Constructor
    public GamePrepare(char p) {
        player = p;
        stacks = new Stack[10];
        // 2 Green stacks
        stacks[0] = new GreenStack();
        stacks[1] = new GreenStack();
        // 3 Purple stacks
        stacks[2] = new PurpleStack();
        stacks[3] = new PurpleStack();
        stacks[4] = new PurpleStack();
        // 3 Red stacks
        stacks[5] = new RedStack();
        stacks[6] = new RedStack();
        stacks[7] = new RedStack();
        // 2 Blue stacks
        stacks[8] = new BlueStack();
        stacks[9] = new BlueStack();
        // Color map
        mp = new HashMap<Character, String>();
        mp.put('G', "Green");
        mp.put('P', "Purple");
        mp.put('R', "Red");
        mp.put('B', "Blue");
    }

    // Prepare for one player
  public void prepare(Board board, Scanner sc) {
        // Print the guidance
        System.out.println("Player " + player + ", you are going to place Sally's stash on the board.");
        System.out.println("Make sure the other player isn't looking!");
        System.out.println("For each stack, type the coordinate of the upper left side of the stash, followed by either H (for horizontal) or V (for vertical).");
        System.out.println("For example, M4H would place a stack horizontally starting at M4 and going to the right.");
        System.out.println("Now you have:");
        System.out.println("<> 2 Green stacks that are 1 * 2");
        System.out.println("<> 3 Purple stacks that are 1 * 3");
        System.out.println("<> 3 Red stacks that are 1 * 4");
        System.out.println("<> 2 Blue stacks that are 1 * 6");
        System.out.println("[Press Enter to continue]");
        sc.nextLine();
        System.out.println("\n----------Let's start placing your board!----------\n");

        // Print the initial board
        board.printBoard();

        // Let the player place each stack
        // If there is invalid input, print the reason and prompt the player to re-place it.
        for (int i = 0; i < stacks.length; ++i) {
            System.out.println("Player " + player + ", where do you want to place the " + mp.get(stacks[i].getColor()) + " stack?");
            // Try to place the stack
            try {
                String cmd = sc.nextLine();
                // Invalid input
                if (cmd.length() != 3) {
                    throw new Exception("Invalid input!");
                }
                StackPlacing.place(stacks[i], Label.rowToIndex(cmd.charAt(0)), Label.colToIndex(cmd.charAt(1)), cmd.charAt(2), board);
            } catch (Exception ex) {
                // Print the error message
                System.out.println(ex.getMessage());
                // Prompt the player to re-place the stack
                --i;
                continue;
            }
            board.printBoard();
        }
        // All stacks placed
        System.out.println("Player " + player + ", you have placed all the stacks. Get ready for the game!");
    }
}
