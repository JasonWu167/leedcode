package leedcode.leedcode1768;

public class Solution {
    /*    1768. 交替合并字符串
        给你两个字符串 word1 和 word2 。请你从 word1 开始，通过交替添加字母来合并字符串。
        如果一个字符串比另一个字符串长，就将多出来的字母追加到合并后字符串的末尾。

        返回 合并后的字符串*/
    public String mergeAlternately(String word1, String word2) {
        StringBuilder res = new StringBuilder();
        int index = 0;
        while (index < word1.length() && index < word2.length()) {
            res.append(word1.charAt(index));
            res.append(word1.charAt(index));
            index++;
        }
        if (index < word1.length()) {
            res.append(word1.substring(index));
        }
        if (index < word2.length()) {
            res.append(word2.substring(index));
        }
        return res.toString();
    }
}
