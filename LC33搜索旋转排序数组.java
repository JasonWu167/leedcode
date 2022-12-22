public class LC33搜索旋转排序数组 {

    public int search(int[] nums, int target) {
        // 定义左右边界
        int left = 0, right = nums.length - 1;
        // 左右都为闭区间
        while (left <= right) {
            // 取中点
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                // 如果找到，返回下标
                return mid;
            } else if (nums[left] < nums[mid]) {
                // 左边连续递增
                if (target >= nums[left] && target < nums[mid]) {
                    // 如果target大于等于左边小于中间 在左边范围内
                    right = mid - 1;
                } else {
                    // 在右边范围内
                    left = mid + 1;
                }
            } else {
                // 右边连续递增
                if (target > nums[mid] && target <= nums[right]) {
                    // 如果 target 大于中间、小于等于右边，在右边范围内
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}
