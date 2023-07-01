import java.util.Arrays;

public class SpiralMatrixGenerator {
    public static int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int rowStart = 0, rowEnd = n - 1;
        int colStart = 0, colEnd = n - 1;
        int num = 1;

        while (num <= n * n) {
            // Traverse right
            for (int i = colStart; i <= colEnd; i++) {
                matrix[rowStart][i] = num++;
            }
            rowStart++;

            // Traverse down
            for (int i = rowStart; i <= rowEnd; i++) {
                matrix[i][colEnd] = num++;
            }
            colEnd--;

            // Traverse left
            for (int i = colEnd; i >= colStart; i--) {
                matrix[rowEnd][i] = num++;
            }
            rowEnd--;

            // Traverse up
            for (int i = rowEnd; i >= rowStart; i--) {
                matrix[i][colStart] = num++;
            }
            colStart++;
        }

        return matrix;
    }

    public static void main(String[] args) {
        int n = 4; // Example size
        int[][] spiralMatrix = generateMatrix(n);

        // Print the generated spiral matrix
        for (int[] row : spiralMatrix) {
            System.out.println(Arrays.toString(row));
        }
    }
}
