class Solution {
    private static final ArrayList<Integer> answer = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(0, nums, result);
        return result;
    }

    private void backtrack(int current, int[] nums, List<List<Integer>> result) {
        if (answer.size() > current) {
            result.add(new ArrayList<>(answer));
            return;
        }

        result.add(new ArrayList<>(answer));

        for (int i = current; i < nums.length; i++) {
            answer.add(nums[i]);
            backtrack(i + 1, nums, result);
            answer.remove(answer.size() - 1);
        }
    }
}
