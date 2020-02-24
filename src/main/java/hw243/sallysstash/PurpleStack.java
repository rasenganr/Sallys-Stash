package hw243.sallysstash;

public class PurpleStack extends Stack {
    public PurpleStack() {
        color = 'P';
        relativeRows = new int[3];
        relativeCols = new int[3];
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
