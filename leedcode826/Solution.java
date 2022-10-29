package leedcode.leedcode826;

import java.util.Deque;
import java.util.LinkedList;

public class Solution {
    /**
     * 给你一个整数数组 nums 和一个整数 k ，找出 nums 中和至少为 k 的 最短非空子数组 ，并返回该子数组的长度。
     * 如果不存在这样的 子数组 ，返回 -1 。
     * 子数组 是数组中 连续 的一部分。
     * 1 <= nums.length <= 10^5
     */

/*    public int shortestSubarray(int[] nums, int k) {
        int n = nums.length;
        int res = n;
        boolean flag =false;
        for (int i = 0; i < n ; i++) {
            int temp = 0;
            for (int j = i; j < n; j++) {
                temp+=nums[j];
                if(temp >=k){
                    res = Math.min(res,j-i+1);
                    flag=true;
                    break;
                }
            }
        }
        return flag?res:-1;
    }*/
//    public int shortestSubarray(int[] A, int k) {
//        int minLen = A.length + 1;
//        int[] preSum = new int[A.length + 1];
//        preSum[0] = 0;
//        for (int i = 0; i < A.length; i++) {
//            preSum[i + 1] = preSum[i] + A[i];
//        }
//        for (int i = 0; i < A.length; i++) {
//            for (int j = i + 1; j < A.length + 1; j++) {
//                if ((preSum[j] - preSum[i]) >= k) {
//                    if ((j - i) < minLen) {
//                        minLen = j - i;
//                    }
//                }
//            }
//        }
//        return minLen == A.length + 1 ? -1 : minLen;
//    }
    public int shortestSubarray(int[] A, int K) {
        int minLen = A.length + 1;
        int[] preSum = new int[A.length + 1];
        preSum[0] = 0;
        for (int i = 0; i < A.length; i++) {
            preSum[i + 1] = preSum[i] + A[i];
        }
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < A.length + 1; i++) {
            while (!deque.isEmpty() && preSum[i] <= preSum[deque.getLast()]) {
                // 1.
                deque.pollLast();
            }

            while (!deque.isEmpty() && preSum[i] - preSum[deque.getFirst()] >= K) {
                // 2.
                int new_len = i - deque.pollFirst();
                if (new_len < minLen) {
                    minLen = new_len;
                }
            }

            deque.addLast(i);
        }
        return minLen == A.length + 1 ? -1 : minLen;
    }
}

