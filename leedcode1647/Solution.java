package leedcode.leedcode1647;

import java.util.ArrayList;

/*1647. 字符频次唯一的最小删除次数
如果字符串 s 中 不存在 两个不同字符 频次 相同的情况，就称 s 是 优质字符串 。
给你一个字符串 s，返回使 s 成为 优质字符串 需要删除的 最小 字符数。
字符串中字符的 频次 是该字符在字符串中的出现次数。例如，在字符串 "aab" 中，'a' 的频次是 2，而 'b' 的频次是 1 。
示例 1：
输入：s = "aab"
输出：0
解释：s 已经是优质字符串。
示例 2：
输入：s = "aaabbbcc"
输出：2
解释：可以删除两个 'b' , 得到优质字符串 "aaabcc" 。
另一种方式是删除一个 'b' 和一个 'c' ，得到优质字符串 "aaabbc" 。
示例 3：
输入：s = "ceabaacb"
输出：2
解释：可以删除两个 'c' 得到优质字符串 "eabaab" 。
注意，只需要关注结果字符串中仍然存在的字符。（即，频次为 0 的字符会忽略不计。）
提示：
1 <= s.length <= 105
s 仅含小写英文字母*/
public class Solution {
    public int minDeletions(String s) {
        ArrayList<Integer> list = new ArrayList<>();
        int[] con = new int[26];
        for(int i = 0 ; i < s.length() ; i++){
            con[s.charAt(i) - 'a']++;
        }
        int res = 0;
        for (int i = 0; i < 26; i++) {
            while (con[i]>0&& list.contains(con[i])){
                con[i]--;
                res++;
            }
            list.add(con[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "aabbc";
        System.out.println(solution.minDeletions(s));
    }
}
