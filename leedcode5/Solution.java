package leedcode.leedcode5;

/*5. 最长回文子串
        给你一个字符串 s，找到 s 中最长的回文子串。
        示例 1：
        输入：s = "babad"
        输出："bab"
        解释："aba" 同样是符合题意的答案。
        示例 2：
        输入：s = "cbbd"
        输出："bb"
        提示：
        1 <= s.length <= 1000
        s 仅由数字和英文字母组成*/
public class Solution {
    public boolean huiwen(String s){
        int n = s.length();
        int l = 0;
        int r = n - 1;
        while (l<r){
            if(s.charAt(l++)!=s.charAt(r--)){
                return false;
            }
        }
        return true;
    }
    public String longestPalindrome(String s) {
        int n = s.length();
        if (n < 2) {
            return s;
        }
        String res = String.valueOf(s.charAt(0));
        for (int i = 0; i < n; i++) {
            for(int j = i+1 ; j<n;j++){
                String temp = s.substring(i,j+1);
                if(huiwen(temp)){
                    res = temp.length()>res.length()?temp:res;
                }
            }

        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "ac";
        System.out.println(solution.longestPalindrome(s));

    }
}
