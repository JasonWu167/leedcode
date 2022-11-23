public class LC5最长回文子串 {
    //判断回文的方法
    public boolean huiwen(String s) {
        int n = s.length();
        int l = 0;
        int r = n - 1;
        while (l < r) {
            //从两边向中间走，有一个不同就不是回文
            if (s.charAt(l++) != s.charAt(r--)) {
                return false;
            }
        }
        return true;
    }

    public String longestPalindrome(String s) {
        int n = s.length();
        //特判
        if (n < 2) {
            return s;
        }
        //让res初始值为第一个字符
        String res = String.valueOf(s.charAt(0));
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                String temp = s.substring(i, j + 1);
                //这里我必须先判断他是否有资格作为结果（长度要大于之前的结果）
                //否则每次都判断是否回文会超时
                if (temp.length() > res.length() && huiwen(temp)) {
                    res = temp;
                }
            }

        }
        return res;
    }
}
