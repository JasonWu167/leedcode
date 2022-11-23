public class LC11盛最多水的容器 {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int res = 0;
        while (left < right) {
            //底总是减一，那就让高保持大
            res = height[left] > height[right] ?
                    Math.max(res, (right - left) * height[right--]) :
                    Math.max(res, (right - left) * height[left++]);
        }
        return res;
    }
}
