class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;

        int cnt = 1;
        int tmp = 0;

        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) set.add(num);

        nums = set.stream().mapToInt(Integer::intValue).toArray();

        Arrays.sort(nums);
        for (int i = 0; i < set.size() - 1; i++) {
            if (set.contains(nums[i] + 1)) {
                cnt++;
            } else {
                tmp = (tmp < cnt) ? cnt : tmp;
                cnt = 1;
            }
        }
        return Math.max(cnt, tmp);
    }
}