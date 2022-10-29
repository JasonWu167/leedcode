package leedcode.dp.a1567;


public class Solution {
//    给你一个整数数组 nums ，请你求出乘积为正数的最长子数组的长度。
//
//    一个数组的子数组是由原数组中零个或者更多个连续数字组成的数组。
//
//    请你返回乘积为正数的最长子数组长度。

    public int getMaxLen(int[] nums) {
        int len = nums.length;
        int[] max = new int[len];
        int[] min = new int[len];

        max[0] = nums[0] > 0 ? 1 : 0;
        min[0] = nums[0] < 0 ? 1 : 0;
        int ans = max[0];

        for (int i = 1; i < len; i++) {
            int n = nums[i];

            if(n > 0){
                max[i] = max[i-1]+1;
                min[i] = min[i-1] == 0 ? 0 : min[i-1]+1;
            }else if(n < 0){
                max[i] = min[i-1] == 0 ? 0 : min[i-1]+1;
                min[i] = max[i-1]+1;
            }else {
                max[i] = min[i] = 0;
            }
            ans = Math.max(ans,max[i]);
        }

        return ans;
    }
}
