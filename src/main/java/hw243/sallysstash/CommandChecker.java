package hw243.sallysstash;

public class CommandChecker {
    // Check the validity of stack placing input
    public static void checkPlace(Stack stack, int referenceRow, int referenceCol, char direction, Board board) throws Exception {
        // Invalid direction
        if (!Character.isLetter(direction) || (Character.toUpperCase(direction) != 'V' && Character.toUpperCase(direction) != 'H')) {
            throw new Exception("Invalid direction!");
        }
        // Check if out of bounds
        for (int i = 0; i < stack.relativeRows.length; ++i) {
            int row = 0;
            int col = 0;
            // Place the stack vertically
            if (Character.toUpperCase(direction) == 'V') {
                row = referenceRow + stack.relativeCols[i];
                col = referenceCol + stack.relativeRows[i];
            }
            // Place the stack horizontally
            else {
                row = referenceRow + stack.relativeRows[i];
                col = referenceCol + stack.relativeCols[i];
            }
            // Out of bounds
            if (row < 0 || row >= board.getLength() || col < 0 || col >= board.getWidth()) {
                throw new Exception("Placing stack out of bounds!");
            }
            // Occupied square
            else if (board.getBoard(row, col) != ' ') {
                throw new Exception("Placing stack on occupied square(s)!");
            }
        }
    }

    // Check the validity of guess input
    public static void checkGuess(int row, int col, Board board) throws Exception {
        if (board.getBoard(row, col) != ' ') {
            throw new Exception("You have checked this square!");
        }
    }
}
