class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(new ArrayList<>(), nums, result);
        return result;
    }

    private void backtrack(List<Integer> current, int[] nums, List<List<Integer>> result) {
        if (nums.length == current.size()) {
            result.add(new ArrayList<>(current));
            return;
        }
        for (int num : nums) {
            if (current.contains(num)) continue;
            current.add(num);
            backtrack(current, nums, result);
            current.remove(current.size() - 1);
        }
    }
}