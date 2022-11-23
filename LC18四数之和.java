import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC18四数之和 {


    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < n; i++) {
            //相邻值相同跳过本轮，防止结果重复
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int pre = nums[i];
            for (int j = i + 1; j < n; j++) {
                //相邻值相同跳过本轮，防止结果重复
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int cur = nums[j];
                int left = j + 1;
                int right = n - 1;
                while (left < right) {
                    long temp = (long) pre + cur + nums[left] + nums[right];
                    if (temp > target) {
                        right--;
                    } else if (temp < target) {
                        left++;
                    } else {
                        List<Integer> list = new ArrayList<>();
                        list.add(pre);
                        list.add(cur);
                        list.add(nums[left]);
                        list.add(nums[right]);
                        res.add(list);
                        //去重
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        while (left < right && nums[right] == nums[right - 1]) {
                            right--;
                        }
                        left++;
                        right--;
                    }
                }
            }
        }
        return res;
    }
}
