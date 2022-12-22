import java.util.HashMap;

public class LC1两数之和 {
    public int[] twoSum1(int[] nums, int target) {
        int n = nums.length;
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        char a = ' ';
        System.out.println();
        return new int[0];
    }

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int temp = target - nums[i];
            if (hashMap.containsValue(temp)) {
                return new int[]{hashMap.get(temp), i};
            }
            hashMap.put(nums[i], i);
        }
        return new int[0];
    }
}
