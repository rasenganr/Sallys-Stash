package hw243.sallysstash;

public class Label {
    // Translate a label for row into index
    public static int rowToIndex(char rowChar) throws Exception {
        return Character.toUpperCase(rowChar) - 'A';
    }

    // Translate a label for column into index
    public static int colToIndex(char colChar) throws Exception {
        // Invalid index
        if (!(colChar >= '0' && colChar <= '9')) {
            throw new Exception("Invalid column label!");
        }
        return colChar - '0';
    }
}
