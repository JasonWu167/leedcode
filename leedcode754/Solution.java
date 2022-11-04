package leedcode.leedcode754;

public class Solution {
    public int reachNumber(int target) {
        target = Math.abs(target);
        int n = 0;
        int sum = 0;
        while(true){
            n++;
            sum+=n;
            if(sum>=target&&(sum-target)%2==0){
                return n;
            }
        }
    }
}
