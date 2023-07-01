import java.util.Arrays;

class Solution {
    public int minProductSum(int[] nums1, int[] nums2) {
        Arrays.sort(nums1); // Sort nums1 in ascending order
        Arrays.sort(nums2); // Sort nums2 in ascending order
        
        int n = nums1.length;
        int minSum = 0;
        
        for (int i = 0; i < n; i++) {
            minSum += nums1[i] * nums2[n - i - 1];
        }
        
        return minSum;
    }
}
