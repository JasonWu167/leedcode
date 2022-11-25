public class LC26删除有序数组中的重复项 {
    public int removeDuplicates(int[] nums) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[ans] != nums[i]) {
                nums[ans + 1] = nums[i];
                ans++;
            }
        }
        return ans + 1;
    }
}
