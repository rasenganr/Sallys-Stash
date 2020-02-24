package hw243.sallysstash;

public class PlayerViewBoard {
    // Is player A or not
    private boolean isA;
    // Self board
    private Board self;
    // A display of the rival's board
    private Board rival;

    // Constructor
    public PlayerViewBoard(boolean isA_player, Board selfBoard) {
        isA = isA_player;
        self = selfBoard;
        rival = new Board();
    }

    // Get the self board content
    public char getSelf(int row, int col) {
        return self.getBoard(row, col);
    }

    // Get the rival board content
    public char getRival(int row, int col) {
        return rival.getBoard(row, col);
    }

    // Get the self board
    public Board getSelfBoard() {
        return self;
    }

    // Get the rival board
    public Board getRivalBoard() {
        return rival;
    }

    // Print two boards from one player's view
    public void printSelfView() {
        if (isA) {
            System.out.println("Player A's turn:");
            System.out.println("       Your tree                 ||              Player B's tree");
        }
        else {
            System.out.println("Player B's turn:");
            System.out.println("       Your tree                 ||              Player A's tree");
        }
        for (int i = 0; i < self.getRealLength(); ++i) {
            // The player's board
            for (int j = 0; j < self.getRealWidth(); ++j) {
                System.out.print(self.getRealBoard(i, j));
            }
            // Separate lines
            System.out.print("          ||          ");
            // The rival's board
            for (int j = 0; j < rival.getRealWidth(); ++j) {
                System.out.print(rival.getRealBoard(i, j));
            }
            System.out.print("\n");
        }
    }
}
