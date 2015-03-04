package problems;

/**
 *
 * @author ataylor
 */
public class Problem15 {

    long numPaths = 0;
    final long SIZE_OF_GRID;

    public Problem15(int sizeOfGrid) {
        SIZE_OF_GRID = sizeOfGrid;
    }

    public void step(int xPos, int yPos) {
        if (xPos == SIZE_OF_GRID && yPos == SIZE_OF_GRID) {
            numPaths++;
            if (numPaths % 100000 == 0) {
                System.out.printf("Paths found: %,d\n", numPaths);
            }
        }
        if (xPos < SIZE_OF_GRID) {
            step(xPos + 1, yPos);
        }
        if (yPos < SIZE_OF_GRID) {
            step(xPos, yPos + 1);
        }
    }

    public static void main(String[] args) throws Exception {
        if (args.length != 1) {
            System.err.println("Usage: java Problem15 <size_of_grid>");
            System.exit(1);
        }

        int sizeOfGrid = Integer.parseInt(args[0]);
        Problem15 p = new Problem15(sizeOfGrid);

        p.step(1, 0);
        p.step(0, 1);
        System.out.println("Number of paths: " + p.numPaths);
    }
}
