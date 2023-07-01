import java.util.HashMap;
import java.util.Map;

public class SparseMatrixMultiplication {
    public static int[][] multiply(int[][] mat1, int[][] mat2) {
        int m = mat1.length;
        int k = mat1[0].length;
        int n = mat2[0].length;

        int[][] result = new int[m][n];

        // Convert mat2 into a map for efficient column access
        Map<Integer, Map<Integer, Integer>> map2 = new HashMap<>();
        for (int j = 0; j < k; j++) {
            for (int i = 0; i < n; i++) {
                if (mat2[j][i] != 0) {
                    if (!map2.containsKey(j)) {
                        map2.put(j, new HashMap<>());
                    }
                    map2.get(j).put(i, mat2[j][i]);
                }
            }
        }

        // Perform matrix multiplication
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < k; j++) {
                if (mat1[i][j] != 0) {
                    if (map2.containsKey(j)) {
                        for (int col : map2.get(j).keySet()) {
                            result[i][col] += mat1[i][j] * map2.get(j).get(col);
                        }
                    }
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] mat1 = {
            {1, 0, 0},
            {-1, 0, 3}
        };
        int[][] mat2 = {
            {7, 0, 0},
            {0, 0, 0},
            {0, 0, 1}
        };

        int[][] result = multiply(mat1, mat2);

        // Print the resulting matrix
        for (int[] row : result) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}
