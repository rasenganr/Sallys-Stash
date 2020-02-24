package hw243.sallysstash;

public class WinnerChecker {
    // Check if a player wins
    public static char checkWinner(Board board, char player) {
        // Check if there is no stack left
        for (int i = 0; i < board.getLength(); ++i) {
            for (int j = 0; j < board.getWidth(); ++j) {
                if (board.getBoard(i, j) == 'G' || board.getBoard(i, j) == 'P' || board.getBoard(i, j) == 'R' || board.getBoard(i, j) == 'B') {
                    return 'N';
                }
            }
        }
        // If there is no stack left, the other player wins.
        return player;
    }
}
