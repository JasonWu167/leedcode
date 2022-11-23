import java.util.Arrays;

public class LC16最接近的三数之和 {
    public int threeSumClosest(int[] nums, int target) {
        int res = Integer.MAX_VALUE;
        //和三数之和一样，先排序
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int cur = nums[i];
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int temp = cur + nums[left] + nums[right];
                //也是判断大了还是小了移动双指针
                if (temp < target) {
                    left++;
                } else if (temp > target) {
                    right--;
                } else {
                    //和target一样直接返回target
                    return target;
                }
                //取当前三数之和与之前的结果距离target较小的那个
                if (Math.abs(temp - target) < Math.abs(res - target)) {
                    res = temp;
                }
            }
        }
        return res;
    }
}

