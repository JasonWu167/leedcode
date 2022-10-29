package leedcode.leedcode3;

import java.util.HashMap;

/*3. 无重复字符的最长子串
        给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。



        示例 1:

        输入: s = "abcabcbb"
        输出: 3
        解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
        示例 2:

        输入: s = "bbbbb"
        输出: 1
        解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
        示例 3:

        输入: s = "pwwkew"
        输出: 3
        解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
        请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。


        提示：

        0 <= s.length <= 5 * 104
        s 由英文字母、数字、符号和空格组成*/
public class Solution {
    /**
     *滑动窗口
     *
     */
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        HashMap<Character, Integer> hashMap = new HashMap<>();
        int left = 0;
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (hashMap.containsKey(s.charAt(i))) {
                //如果哈希表中包含该字符，窗口左边取left 或者 包含该字符位置的前一个，取最大值
                left = Math.max(left, hashMap.get(s.charAt(i)) + 1);
            }
            hashMap.put(s.charAt(i),i);
            //做大长度等于之前最大值和新长度之间取较大者
            res = Math.max(res,i - left +1);
        }
        return res;
    }
}
