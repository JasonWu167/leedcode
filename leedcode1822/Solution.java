package leedcode.leedcode1822;

public class Solution {
    public int arraySign(int[] nums) {
        int n = 1;
        for (int num : nums) {
            n *= signFunc(num);
        }
        return n;
    }

    public int signFunc(int x) {
        return Integer.compare(x, 0);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.arraySign(new int[]{-1,-2,-3,-4,3,2,1}));
    }
}
