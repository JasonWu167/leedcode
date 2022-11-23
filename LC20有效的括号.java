import java.util.Stack;

public class LC20有效的括号 {
    //经典考察栈的题目
    public boolean isValid(String s) {
        if (s.length() == 0) {
            return true; //特判
        }
        //创建栈
        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            //左括号入栈
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            } else {
                if (stack.isEmpty()) {
                    return false;//没有左括号有右括号直接返回false
                } else {
                    //弹出一个左括号进行匹配
                    char temp = stack.pop();
                    if (ch == ')') {
                        if (temp != '(') {
                            return false;
                        }
                    } else if (ch == ']') {
                        if (temp != '[') {
                            return false;
                        }
                    } else if (ch == '}') {
                        if (temp != '{') {
                            return false;
                        }
                    }
                }
            }
        }
        return stack.isEmpty();//最后检查是否栈空。都排查完了还剩括号就是false
    }
}
