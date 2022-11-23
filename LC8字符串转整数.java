public class LC8字符串转整数 {
    public int myAtoi(String s) {
        int cur = 0;//字符串索引
        int n = s.length();
        //特判
        if (n == 0) {
            return 0;
        }
        //去除前导空格
        while (cur < n && s.charAt(cur) == ' ') {
            cur++;
        }
        int temp = 1;
        //去除+-并判断正负
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
            int num = s.charAt(cur) - '0';//获取当前字符的int值
            //如果不是数字则退出
            if (num < 0 || num > 9) {
                break;
            }
            last = res;
            res = res * 10 + num;
            //如果不相等就是溢出了，这道题对于我重点在这
            if (last != res / 10) {
                return (temp == (-1)) ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            cur++;
        }
        return temp * res;
    }
}
