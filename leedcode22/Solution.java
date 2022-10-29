package leedcode.leedcode22;

import java.util.ArrayList;
import java.util.List;

/*22. 括号生成
        数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
        示例 1：
        输入：n = 3
        输出：["((()))","(()())","(())()","()(())","()()()"]
        示例 2：
        输入：n = 1
        输出：["()"]
        提示：
        1 <= n <= 8*/
public class Solution {
    public List<String> generateParenthesis(int n) {

        ArrayList<String> res = new ArrayList<>();
        if (n == 0) {
            return res;
        }
        dfs("", 0, 0, res, n);
        return res;

    }

    public void dfs(String s, int left, int right, List<String> res, int n) {
        if (left == n && right == n) {
            res.add(s);
            return;
        }
        if (left < right) {
            return;
        }
        if (left < n) {
            dfs(s + "(", left + 1, right, res, n);
        }
        if (right < n) {
            dfs(s + ")", left, right + 1, res, n);
        }
    }
}
