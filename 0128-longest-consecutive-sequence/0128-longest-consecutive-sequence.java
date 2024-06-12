import java.util.*;

class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();

        if (nums.length == 0) return 0;

        for (int num : nums) 
            set.add(num);

        int longest = 0;

        for (int i : set) {
            if (!set.contains(i - 1)) {
                int current = i;
                int count = 1;

                while (set.contains(current + 1)) {
                    current++;
                    count++;
                }
                longest = Math.max(longest, count);
            }
        }
        return longest;
    }
}