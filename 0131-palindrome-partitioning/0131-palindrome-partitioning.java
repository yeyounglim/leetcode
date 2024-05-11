class Solution {
    List<List<String>> result = new ArrayList<>();

    public List<List<String>> partition(String s) {
        backtrack(0, new ArrayList<>(), s);

        return result;
    }

    private void backtrack(int start, ArrayList<String> current, String s) {
        if (start == s.length()) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = start; i < s.length(); i++) {
            String check = s.substring(start, i + 1);
            if (isPalindrome(check)) {
                current.add(check);
                backtrack(i + 1, current, s);
                current.remove(current.size() - 1);
            }

        }
    }

    private boolean isPalindrome(String s) {
        return s.equals(new StringBuffer(s).reverse().toString());
    }
}