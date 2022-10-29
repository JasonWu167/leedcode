package leedcode.stack.leedcode907;

import java.util.Stack;

public class Solution {
    /*    给定一个整数数组 arr，找到 min(b) 的总和，其中 b 的范围为 arr 的每个（连续）子数组。
        由于答案可能很大，因此 返回答案模 10^9 + 7 。
        1 <= arr.length <= 3 * 104
        1 <= arr[i] <= 3 * 104*/
    static final int MOD = 1000000007;
    public int sumSubarrayMins(int[] arr) {
        if (arr == null) {
            return 0;
        }
        int n = arr.length;
        int[] temp = new int[n+2];
        temp[0] =-1;
        temp[n+1] = -1;
        //从小到大的单调栈
        Stack<Integer> stack = new Stack<>();
        System.arraycopy(arr, 0, temp, 1, n + 1 - 1);
        long res = 0;
        for (int i = 0; i <n+2; i++) {
            while (!stack.isEmpty() && temp[stack.peek()] > temp[i]) {
                int cur = stack.pop();
                res = (res + (long)(cur - stack.peek()) * (i - cur) * temp[cur]) % MOD;
            }
            stack.push(i);
        }
        return  (int) res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.sumSubarrayMins(new int[]{3,1,2,4});
    }
}
