class Solution {
    public boolean validMountainArray(int[] arr) {
        int n = arr.length;
        
        if (n < 3) {
            return false;
        }
        
        int i = 0;
        
        // Find the peak of the mountain
        while (i < n - 1 && arr[i] < arr[i + 1]) {
            i++;
        }
        
        // Check if the peak is at the start or end
        if (i == 0 || i == n - 1) {
            return false;
        }
        
        // Check the descending part of the mountain
        while (i < n - 1 && arr[i] > arr[i + 1]) {
            i++;
        }
        
        return i == n - 1;
    }
}
