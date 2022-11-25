public class LC28找出字符串中第一个匹配项的下标 {
//    public int strStr(String haystack, String needle) {
//        return haystack.indexOf(needle);
//    }
    //构建next数组
    public int[] createNext(String s) {
        int[] next = new int[s.length()];
        int j = 0;
        for (int i = 1; i < s.length(); i++) {
            while (j > 0 && s.charAt(i) != s.charAt(j)) {
                j = next[j - 1];
            }
            if (s.charAt(i) == s.charAt(j)) {
                j++;
            }
            next[i] = j;
        }
        return next;
    }

    public int strStr(String haystack, String needle) {
        int n = haystack.length(), m = needle.length();
        if (m == 0) {
            return 0;
        }
        int[] next = createNext(needle);
        int index = 0;
        for (int i = 0; i < n; i++) {
            while (index > 0 && haystack.charAt(i) != needle.charAt(index)) {
                index = next[index - 1];
            }
            if (haystack.charAt(i) == needle.charAt(index)) {
                index++;
            }
            if (index == m) {
                return i - m + 1;
            }
        }
        return -1;
    }
}


