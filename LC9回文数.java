public class LC9回文数 {
    public boolean isPalindrome(int x) {
        //负数肯定不是回文数
        if (x < 0) {
            return false;
        }
        String temp = Integer.toString(x);
        int left = 0;
        int right = temp.length() - 1;
        while (left < right) {
            if (temp.charAt(left++) != temp.charAt(right--)) {
                return false;
            }
        }
        return true;
    }
}
