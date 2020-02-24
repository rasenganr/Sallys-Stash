package hw243.sallysstash;

public class Board {
    // Game size
    private int length;
    private int width;
    // Real board size
    private int realLength;
    private int realWidth;
    // The actual board
    private char[][] board;

    // Constructor
    public Board() {
        // Game size
        length = 20;
        width = 10;
        // Real board size
        realLength = length + 2;
        realWidth = 2 * width + 3;
        board = new char[realLength][realWidth];
        // Initialize the board
        for (int i = 0; i < realLength; ++i) {
            for (int j = 0; j < realWidth; ++j) {
                // Column label
                if ((i == 0 || i == realLength - 1) && j > 0 && j < realWidth - 1 && j % 2 == 0) {
                    board[i][j] = (char)('0' + j / 2 - 1);
                }
                // Row label
                else if (i > 0 && i < realLength - 1 && (j == 0 || j == realWidth - 1)) {
                    board[i][j] = (char)('A' + i - 1);
                }
                // Separating lines
                else if (j % 2 == 1) {
                    board[i][j] = '|';
                }
                // Empty square
                else {
                    board[i][j] = ' ';
                }
            }
        }
    }

    public int getLength() {
        return length;
    }

    public int getRealLength() {
        return realLength;
    }

    public int getWidth() {
        return width;
    }

    public int getRealWidth() {
        return realWidth;
    }

    // Get the content in the block from players' view
    public char getBoard(int row, int col) throws IndexOutOfBoundsException {
        // Transform from game coordinates to real coordinates
        int boardRow = row + 1;
        int boardCol = 2 + 2 * col;
        return board[boardRow][boardCol];
    }

    // Get the content in the block of the real board
    public char getRealBoard(int realRow, int realCol) throws IndexOutOfBoundsException {
        return board[realRow][realCol];
    }

    // Set the content of a square
    public void setBoard(int row, int col, char value) throws IndexOutOfBoundsException {
        // Transform from game coordinates to real coordinates
        int boardRow = row + 1;
        int boardCol = 2 + 2 * col;
        board[boardRow][boardCol] = value;
    }

    // Print the current board
    public void printBoard() {
        for (int i = 0; i < realLength; ++i) {
            for (int j = 0; j < realWidth; ++j) {
                System.out.print(board[i][j]);
            }
            System.out.print("\n");
        }
    }
}
