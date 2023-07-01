import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public int[] findOriginalArray(int[] changed) {
        if (changed.length % 2 != 0) {
            return new int[0]; // If the length is odd, it cannot be a doubled array
        }
        
        Map<Integer, Integer> countMap = new HashMap<>();
        List<Integer> originalList = new ArrayList<>();
        
        for (int num : changed) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }
        
        for (int num : changed) {
            if (countMap.getOrDefault(num, 0) == 0) {
                continue;
            }
            
            int doubleNum = num * 2;
            
            if (countMap.getOrDefault(doubleNum, 0) == 0) {
                return new int[0]; // If the double value is not present, it is not a doubled array
            }
            
            originalList.add(num);
            
            countMap.put(num, countMap.get(num) - 1);
            countMap.put(doubleNum, countMap.get(doubleNum) - 1);
        }
        
        int[] original = new int[originalList.size()];
        
        for (int i = 0; i < originalList.size(); i++) {
            original[i] = originalList.get(i);
        }
        
        return original;
    }
}
