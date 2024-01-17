import java.util.Stack;
class Solution {
    public boolean isValid(String s) {
        Stack<String> stack = new Stack<>();
        char[] c = s.toCharArray();

        for (char c1 : c) {
            if (c1 == '[') {
                stack.push("]");
            } else if (c1 == '{') {
                stack.push("}");
            } else if (c1 == '(') {
                stack.push(")");
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
            }

            if (c1 == ']') {
                if (stack.peek() == "]")
                    stack.pop();
                else return false;

            } else if (c1 == '}') {
                if (stack.peek() == "}")
                    stack.pop();
                else return false;
            } else if (c1 == ')') {
                if (stack.peek() == ")")
                    stack.pop();
                else return false;
            }
        }
        if (stack.isEmpty()) {
            return true;
        }
        return false;
    }
    
}