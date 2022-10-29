package leedcode.double_points.leedcode15;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Solution {
/*
    给你一个整数数组 nums ，
    判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，
    同时还满足 nums[i] + nums[j] + nums[k] == 0 。
    请你返回所有和为 0 且不重复的三元组。
    注意：答案中不可以包含重复的三元组。
*/

    public List<List<Integer>> threeSum(int[] nums) {
        ArrayList<List<Integer>> lists = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                //如果当前值已经大于0了，后面没有负数，三数之和不会等于0，直接返回结果
                return lists;

            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                //如果当前值和前一个相同，防止重复，跳过
                continue;
            }
            int cur = nums[i];
            int left = i + 1;
            int right = n - 1;
            while (left < right) {
                int temp = nums[left] + nums[right] + cur;
                if (temp == 0) {
                    //如果三数之和等于0，加入结果集
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(cur);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    lists.add(list);
                    //以下两个循环是为了防止重复
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    left++;
                    right--;
                } else if (temp > 0) {
                    //如果三数之和大于0，尝试将三数之和减小
                    right--;
                } else {
                    //如果三数之和大于0，尝试将三数之和加大
                    left++;
                }
            }
        }
        return lists;
    }
}
