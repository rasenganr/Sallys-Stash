package hw243.sallysstash;

public class BlueStack extends Stack {
    public BlueStack() {
        color = 'B';
        relativeRows = new int[6];
        relativeCols = new int[6];
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
