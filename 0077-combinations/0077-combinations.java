class Solution {
    private static final ArrayList<Integer> answer = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(1, n, k, result);
        return result;
    }

    private void backtrack(int current, int n, int k, List<List<Integer>> result) {
        if (answer.size() == k) {
            result.add(new ArrayList<>(answer));
            return;
        }
        for (int i = current; i <= n; i++) {
            answer.add(i);
            backtrack(i + 1, n, k, result);
            answer.remove(answer.size() - 1);
        }
    }
}