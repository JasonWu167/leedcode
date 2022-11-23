public class LC4寻找两个正序数组的中位数 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double res = 0;//结果
        int m = nums1.length;
        int n = nums2.length;
        //特判
        if (m == 0 && n == 0) {
            return 0;
        }
        //合并好的数组
        int[] arr = new int[m + n];
        int q1 = 0;//sum1的索引
        int q2 = 0;//sum2的索引
        int begin = 0;//新数组的索引
        while (q1 < m && q2 < n) {
            //如两数相加，能合并到哪先合
            if (nums1[q1] <= nums2[q2]) {
                arr[begin++] = nums1[q1++];
            } else {
                arr[begin++] = nums2[q2++];
            }
        }
        //看看是谁已经走完了，num1走完则将num2直接加后面
        if (q1 == m) {
            while (q2 != n) {
                arr[begin++] = nums2[q2++];
            }
        }
        if (q2 == n) {
            while (q1 != m) {
                arr[begin++] = nums1[q1++];
            }
        }
        //求中位数
        int mid = (m + n) / 2;
        if ((m + n) % 2 == 0) {
            res = (double) (arr[mid] + arr[mid - 1]) / 2;
        } else {
            res = arr[mid];
        }
        return res;
    }
}
