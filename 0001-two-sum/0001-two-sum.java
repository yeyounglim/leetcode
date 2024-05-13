class Solution {
    public int[] twoSum(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int[][] indexNums = new int[nums.length][2];

        for (int i = 0; i < nums.length; i++) {
            indexNums[i][0] = nums[i];
            indexNums[i][1] = i;
        }
        Arrays.sort(indexNums, Comparator.comparingInt(o -> o[0]));

        while (start != nums.length - 1 && end != 0) {
            int sum = indexNums[start][0] + indexNums[end][0];

            if (sum == target)
                return new int[]{indexNums[start][1], indexNums[end][1]};
            else if (sum > target) end--;
            else start++;
        }
        return null;
    }
}