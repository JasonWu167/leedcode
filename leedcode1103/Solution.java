package leedcode.leedcode1103;

public class Solution {
    public int[] distributeCandies(int candies, int num_people) {
        int[] res = new int[num_people];
        int index = 0;
        int i = 0;
        while (candies > 0) {
            i++;
            i = i <= candies ? i : candies;
            res[index] += i;
            index = index + 1 == num_people ? 0 : index + 1;
            candies -= i;
        }
        return res;
    }
}
