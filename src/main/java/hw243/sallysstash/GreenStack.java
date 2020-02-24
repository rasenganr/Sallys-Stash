package hw243.sallysstash;

public class GreenStack extends Stack {
    public GreenStack() {
        color = 'G';
        relativeRows = new int[2];
        relativeCols = new int[2];
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
