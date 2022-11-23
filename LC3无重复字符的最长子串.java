import java.util.HashMap;

public class LC3无重复字符的最长子串 {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        HashMap<Character, Integer> hashMap = new HashMap<>();
        int left = 0;
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (hashMap.containsKey(s.charAt(i))) {
                //如果之前已经遇过该字符，取left和hashmap中存取的下标加1的较大者
                left = Math.max(left, hashMap.get(s.charAt(i)) + 1);
            }
            hashMap.put(s.charAt(i), i);
            res = Math.max(res, i - left + 1);
        }
        return res;
    }
}
