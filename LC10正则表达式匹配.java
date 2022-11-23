public class LC10正则表达式匹配 {
    public boolean isMatch(String s, String p) {
        //特判
        if (s == null || p == null) {
            return false;
        }
        int n = s.length();
        int m = p.length();
        char[] s1 = s.toCharArray();
        char[] p1 = p.toCharArray();
        //此数组表示s前i个字符能否与p前j个字符匹配
        boolean[][] dp = new boolean[n + 1][m + 1];
        //初始值，空值匹配空值为true
        dp[0][0] = true;
        //初始化第一列，此时s的位置是0
        for (int j = 1; j < m + 1; j++) {
            //情况1：如果p的j-1个位置是’*‘，则j的状态等于j-2的状态
            //如：s='',p='a*'
            if (p1[j - 1] == '*')
                dp[0][j] = dp[0][j - 2];
        }
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                //情况2：如果s和p当前位置相等或者p为'.' dp[i][j]=dp[i-1][j-1]
                //如s=“xxxa”,p=xxx."或s="xxxa",p="xxxa"
                if (s1[i - 1] == p1[j - 1] || p1[j - 1] == '.')
                    dp[i][j] = dp[i - 1][j - 1];
                else if (p1[j - 1] == '*') {//如果p当前位置为'*'
                    //情况3：如果s当前位置和p前一个位置一样
                    //dp[i][j-2]:p向前看了2个位置，相当于*重复了0次 如 s=“xxa” p="xxaa*"
                    //dp[i][j-1]:p向前看了1个位置，相当于*重复了1次 如 s=“xxa” p="xxa*"
                    //dp[i-1][j]:s向前看了1个位置，相当于*重复了n次 如 s=“xaa” p="xxa*"
                    if (s1[i - 1] == p1[j - 2] || p1[j - 2] == '.') {
                        dp[i][j] = dp[i][j - 2] || dp[i][j - 1] || dp[i - 1][j];
                    } else {
                        //情况4：s与p前两个位置不匹配 相当于*重复了0次 如 s=“xxa” p="xxb*"
                        dp[i][j] = dp[i][j - 2];
                    }

                }
            }

        }
        return dp[n][m];
    }
}
