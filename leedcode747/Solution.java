package leedcode.leedcode747;

import java.util.Arrays;

public class Solution {
    public int dominantIndex(int[] nums) {
        int n = nums.length-1;
        int[] temp = Arrays.copyOf(nums,nums.length);
        Arrays.sort(nums);
        int max = nums[n];
        int index = -1;
        for(int i = 0;i<n+1;i++){
            if(temp[i] == max){
                index = i;
                break;
            }
        }
        n--;
        while(n>=0){
            if(nums[n]*2>max){
                return -1;
            }
            n--;
        }
        return index;
    }

}
