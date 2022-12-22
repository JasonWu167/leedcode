public class LC31下一个排列 {
    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        //找到第一个降序的位置
        //如 12422536 下一个排列为12422356 53是降序的 这里找到5
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            //找到第一个比上面小的  3
            while (j >= 0 && nums[i] >= nums[j]) {
                j--;
            }
            //交换
            swap(nums, i, j);
        }
        reverse(nums, i + 1);
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void reverse(int[] nums, int start) {
        int left = start, right = nums.length - 1;
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }
}

