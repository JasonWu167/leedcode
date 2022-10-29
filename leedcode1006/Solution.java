package leedcode.leedcode1006;

public class Solution {
    public int clumsy(int n) {
        int res = 0;
        if (n >= 4) {
            res += n * (n - 1) / (n - 2);
            res += (n - 3);
            n -= 4;
        } else if (n == 3) {
            res += n * (n - 1) / (n - 2);
            n -= 3;
        } else if (n == 2) {
            res += n * (n - 1);
            n -= 2;
        } else {
            res += n;
            n -= 1;
        }

        while (n > 0) {
            if (n >= 4) {
                res -= n * (n - 1) / (n - 2);
                res += (n - 3);
                n -= 4;
            } else if (n == 3) {
                res -= n * (n - 1) / (n - 2);
                n -= 3;
            } else if (n == 2) {
                res -= n * (n - 1);
                n -= 2;
            } else {
                res -= n;
                n -= 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.clumsy(10);
    }
}
