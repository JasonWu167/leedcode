public class LC38外观数列 {
    public String countAndSay(int n) {
        return rr("1", n);
    }

    private String rr(String s, int num) {
        if (num == 1) {
            return s;
        }
        int n = s.length();
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (int i = 0; i < n; i++) {
            count++;
            if ((i + 1 < n && s.charAt(i) != s.charAt(i + 1)) || i == n - 1) {
                sb.append(count);
                sb.append(s.charAt(i));
                count = 0;
            }
        }
        return rr(sb.toString(), num - 1);
    }

}
