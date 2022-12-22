import java.util.Stack;

public class LC32最长有效括号 {
    public static int longestValidParentheses(String s) {
        if (s == null || s.length() < 2) {
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int n = s.length();
        int res = 0;
        int temp = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    temp = i - stack.peek();
                    res = Math.max(res, temp);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(longestValidParentheses("(()()((()(())()(()))(()()()(((()))(()()"));
    }
}
