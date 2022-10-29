package leedcode.leedcode4;

/*4. 寻找两个正序数组的中位数
        给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
        算法的时间复杂度应该为 O(log (m+n)) 。
        示例 1：
        输入：nums1 = [1,3], nums2 = [2]
        输出：2.00000
        解释：合并数组 = [1,2,3] ，中位数 2
        示例 2：
        输入：nums1 = [1,2], nums2 = [3,4]
        输出：2.50000
        解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
        提示：
        nums1.length == m
        nums2.length == n
        0 <= m <= 1000
        0 <= n <= 1000
        1 <= m + n <= 2000
        -106 <= nums1[i], nums2[i] <= 106
        通过次数825,234提交次数1,985,709*/
public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double res = 0;
        int m = nums1.length;
        int n = nums2.length;
        if(m == 0 && n == 0){
            return 0;
        }
        int[] arr = new int[m + n];
        int q1 = 0;
        int q2 = 0;
        int begin =0;
        while (q1 < m && q2 < n) {
            if (nums1[q1] <= nums2[q2]) {
                arr[begin++] = nums1[q1++];
            }else{
                arr[begin++]=nums2[q2++];
            }
        }
        if(q1 ==m){
            while (q2!=n){
                arr[begin++] = nums2[q2++];
            }
        }
        if(q2 == n){
            while(q1!=m){
                arr[begin++] = nums1[q1++];
            }
        }
        int mid = (m+n)/2;
        if((m+n) %2==0){
            res = (double) (arr[mid] + arr[mid-1])/2;
        }else {
            res = arr[mid];
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums1 = {};
        int[] nums2 = {};
        System.out.println(solution.findMedianSortedArrays(nums1, nums2));
    }
}
