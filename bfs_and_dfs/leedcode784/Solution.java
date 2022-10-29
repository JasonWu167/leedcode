package leedcode.bfs_and_dfs.leedcode784;

import java.util.ArrayList;
import java.util.List;
/*784. 字母大小写全排列
        给定一个字符串 s ，通过将字符串 s 中的每个字母转变大小写，我们可以获得一个新的字符串。
        返回 所有可能得到的字符串集合 。以 任意顺序 返回输出。
        示例 1：
        输入：s = "a1b2"
        输出：["a1b2", "a1B2", "A1b2", "A1B2"]
        示例 2:
        输入: s = "3z4"
        输出: ["3z4","3Z4"]*/
public class Solution {
    public List<String> letterCasePermutation(String s) {
        ArrayList<String> res = new ArrayList<>();
        char[] array = s.toCharArray();
        dfs(res, 0, array);
        return res;
    }

    private void dfs(List<String> res, int index, char[] array) {
        if (index == array.length) {
            res.add(String.valueOf(array));
            return;
        }
        dfs(res, index + 1, array);
        if (Character.isLetter(array[index])) {
            array[index] = change(array[index]);
            dfs(res, index + 1, array);
            array[index] = change(array[index]);
        }
    }

    private char change(char c) {
        //改变字母大小写
        return (c >= 'a' && c <= 'z') ? (char) (c - 32) : (char) (c + 32);
    }
}
