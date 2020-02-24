package hw243.sallysstash;

public class RedStack extends Stack {
    public RedStack() {
        color = 'R';
        relativeRows = new int[4];
        relativeCols = new int[4];
        // Initialize relative rows
        for (int i = 0; i < relativeRows.length; ++i) {
            relativeRows[i] = 0;
        }
        // Initialize relative columns
        for (int i = 0; i < relativeCols.length; ++i) {
            relativeCols[i] = i;
        }
    }
}
