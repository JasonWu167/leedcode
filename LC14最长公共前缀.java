public class LC14最长公共前缀 {
    public String longestCommonPrefix(String[] strs) {
        String res = "";
        for (int i = 0; i < strs[0].length(); i++) {
            for (int j = 1; j < strs.length; j++) {
                //如果有一个字符串结束直接返回结果
                if (i >= strs[j].length()) {
                    return res;
                }
                //让第一个字符串和后面所有字符串对比
                //有一个字符不同直接返回结果
                if (strs[0].charAt(i) != strs[j].charAt(i)) {
                    return res;
                }
            }
            res += strs[0].charAt(i);
        }
        return res;
    }
}
