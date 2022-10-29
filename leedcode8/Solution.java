package leedcode.leedcode8;


public class Solution {
    public int myAtoi(String s) {
        int cur = 0;
        int n = s.length();
        if (n == 0) {
            return 0;
        }
        while (cur < n && s.charAt(cur) == ' ') {
            cur++;
        }
        int temp = 1;
        if (cur < n && (s.charAt(cur) == '-' || s.charAt(cur) == '+')) {
            if (s.charAt(cur) == '-') {
                temp = -1;
                cur++;
            } else {
                cur++;
            }

        }
        int res = 0;
        int last = 0;
        while (cur < n) {
            int num = s.charAt(cur) - '0';
            if (num < 0 || num > 9) {
                break;
            }
            last = res;
            res = res * 10 + num;
            if (last != res / 10) {  ////如果不相等就是溢出了
                return (temp == (-1)) ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            cur++;
        }
        return temp * res;
    }

    public static void main(String[] args) {
        String s = "2147483648";
        Solution solution = new Solution();
        System.out.println(solution.myAtoi(s));
    }
}
