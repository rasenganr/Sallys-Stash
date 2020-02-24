package hw243.sallysstash;

public class StackPlacing {
    // Place a stack on the board
    public static void place(Stack stack, int referenceRow, int referenceCol, char direction, Board board) throws Exception {
        // Check the validity of will-be-filled squares
        CommandChecker.checkPlace(stack, referenceRow, referenceCol, direction, board);
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
            // Place the one square of the stack
            board.setBoard(row, col, stack.getColor());
        }
    }

}
