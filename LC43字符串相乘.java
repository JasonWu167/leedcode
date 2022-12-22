public class LC43字符串相乘 {
    // 加法
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        int n = num1.length();//乘数
        int m = num2.length();//被乘数
        String res = "0";
        for (int i = n - 1; i >= 0; i--) {
            StringBuilder sb = new StringBuilder();
            for (int j = n - 1; j > i; j--) {
                // 补0
                sb.append("0");
            }
            int a = num1.charAt(i) - '0';//取乘数的每一个数字
            int add = 0;//进位
            // 做乘法，此时的数是反的
            for (int j = m - 1; j >= 0; j--) {
                int b = num2.charAt(j) - '0';
                int tempSum = a * b + add;
                sb.append(tempSum % 10);
                add = tempSum / 10;
            }
            if (add != 0) {
                sb.append(add);
            }
            // 做加法
            res = addString(res, sb.reverse().toString());

        }
        return res;
    }

    private String addString(String sum, String num) {
        int n = sum.length() - 1, m = num.length() - 1;
        StringBuilder sb = new StringBuilder();
        int add = 0;
        while (n >= 0 || m >= 0 || add > 0) {
            int a = n >= 0 ? sum.charAt(n) - '0' : 0;
            int b = m >= 0 ? num.charAt(m) - '0' : 0;
            int tempSum = a + b + add;
            sb.append(tempSum % 10);
            add = tempSum / 10;
            n--;
            m--;
        }
        return sb.reverse().toString();
    }

    // 乘法
    public String multiply1(String num1, String num2) {
        int n = num1.length(), m = num2.length();
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        int[] arr = new int[n + m];
        for (int i = n - 1; i >= 0; i--) {
            int a = num1.charAt(i) - '0';
            for (int j = m - 1; j >= 0; j--) {
                int b = num2.charAt(j) - '0';
                int tempSum = a * b + arr[i + j + 1];
                arr[i + j + 1] = tempSum % 10;
                arr[i + j] += tempSum / 10;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            if (i == 0 && arr[i] == 0) continue;
            sb.append(arr[i]);
        }
        return sb.toString();
    }
}
