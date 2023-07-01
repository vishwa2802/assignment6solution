import java.util.*;

public class PermutationReconstruction {
    public static int[] reconstructPermutation(String s) {
        int n = s.length();
        int[] perm = new int[n + 1];
        
        // Find the indices where I or D occurs
        List<Integer> indices = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            indices.add(i);
        }
        
        // Reconstruct the permutation
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'I') {
                perm[i] = indices.remove(0);
            } else {
                perm[i] = indices.remove(indices.size() - 1);
            }
        }
        
        perm[n] = indices.get(0); // Add the last remaining index
        
        return perm;
    }
    
    public static void main(String[] args) {
        String s = "IDID";
        int[] perm = reconstructPermutation(s);
        
        System.out.print("Output: [");
        for (int i = 0; i < perm.length; i++) {
            System.out.print(perm[i]);
            if (i < perm.length - 1) {
                System.out.print(",");
            }
        }
        System.out.println("]");
    }
}
