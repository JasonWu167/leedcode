public class LC7整数反转 {
    public int reverse(int x) {
        long res = 0;
        while (x != 0) {
            int temp = x % 10;
            res = res * 10 + temp;
            if (res < Integer.MIN_VALUE || res > Integer.MAX_VALUE) {
                return 0;
            }
            x /= 10;
        }
        return (int) res;
    }
}
