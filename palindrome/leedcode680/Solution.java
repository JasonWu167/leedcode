package leedcode.palindrome.leedcode680;

public class Solution {
    /**
     * 给你一个字符串 s，最多 可以从中删除一个字符。
     * 请你判断 s 是否能成为回文字符串：如果能，返回 true ；否则，返回 false 。
     */
    public boolean validPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left <= right) {
            if (s.charAt(left) != s.charAt(right)) {
               return f1(left + 1, right, s)||
                f1(left, right - 1, s);
            }
            left++;
            right--;
        }
        return true;
    }

    private boolean f1(int left, int right, String s) {

        while (left <= right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
