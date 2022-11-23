import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC15三数之和 {
    public List<List<Integer>> threeSum(int[] nums) {
        //结果集
        ArrayList<List<Integer>> lists = new ArrayList<>();
        //现将数组排序，有大用
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            //当前最小值都大于0直接返回结果
            if (nums[i] > 0) {
                return lists;
            }
            //相邻值相同跳过本轮，防止结果重复
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int cur = nums[i];
            int left = i + 1;
            int right = n - 1;
            while (left < right) {
                int temp = nums[left] + nums[right] + cur;
                if (temp == 0) {
                    //三数之和等于0加入结果集
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(cur);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    lists.add(list);
                    //去重
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    left++;
                    right--;
                } else if (temp > 0) {
                    //大于0说明大了，让三数之和变小，右指针左移
                    right--;
                } else {
                    //大于0说明小了，让三数之和变大，左指针右移
                    left++;
                }
            }
        }
        return lists;
    }
}
