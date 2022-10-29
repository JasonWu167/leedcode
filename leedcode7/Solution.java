package leedcode.leedcode7;

//7. 整数反转
//        给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
//        如果反转后整数超过 32 位的有符号整数的范围 [−231,  231 − 1] ，就返回 0。
//        假设环境不允许存储 64 位整数（有符号或无符号）。
//        示例 1：
//        输入：x = 123
//        输出：321
//        示例 2：
//        输入：x = -123
//        输出：-321
//        示例 3：
//        输入：x = 120
//        输出：21
//        示例 4：
//        输入：x = 0
//        输出：0
//        提示：
//        -231 <= x <= 231 - 1
public class Solution {
    public int reverse(int x) {
        long res = 0;
        while (x != 0) {
            int temp = x % 10;
            res = res * 10 + temp;
            if (res < Integer.MIN_VALUE || res > Integer.MAX_VALUE) {
                return 0;
            }
            x /= 10;
        }
        return (int) res;
    }

    public static void main(String[] args) {
        int x= -123;
        Solution solution = new Solution();
        System.out.println(solution.reverse(x));
    }
}
