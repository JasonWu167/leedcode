package leedcode.leedcode1684;

import java.util.HashSet;

public class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        int n = allowed.length();
        int[] arr = new int[26];
        for (int i = 0; i < n; i++) {
            arr[allowed.charAt(i) - 'a']++;
        }
        int res = 0;
        for (String str : words) {
            res++;
            for (int i = 0; i < str.length(); i++) {
                if (arr[str.charAt(i) - 'a'] == 0) {
                    res--;
                    break;
                }
            }

        }
        return res;
    }
}
