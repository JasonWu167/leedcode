package leedcode;


import leedcode.leedcode1684.Solution;

public class TestDemo {


    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] arr = {
                {1,2,5},
                {2,1,7},{3,1,9}
        };
        int ab = solution.countConsistentStrings("ab",
                new String[]{"ad", "bd", "aaab", "baa", "badab"});
        System.out.println(ab);

    }
}

