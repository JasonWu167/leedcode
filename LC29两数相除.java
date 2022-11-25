public class LC29两数相除 {

    public int divide(int dividend, int divisor) {
        long d1 = (long) Math.abs(((long) dividend));
        long d2 = (long) Math.abs(((long) divisor));
        boolean isNeg = (dividend ^ divisor) < 0;
        long l = 1, r = d1;
        long ans = 0;
        while (l <= r) {
            long mid = l + ((r - l) >> 1);
            if (multiply(mid, d2) <= d1) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        if (!isNeg && ans > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        return isNeg ? (int) (-ans) : (int) ans;
    }

    public long multiply(long a, long b) {
        long ans = 0;
        while (b > 0) {
            if ((b & 1) == 1) {
                ans += a;
            }
            a += a;
            b >>= 1;
        }
        return ans;
    }
}

