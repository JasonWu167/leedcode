
public class LC6字形变换 {
    /**
     * 思路：这是一个反转过程
     * 例如ABCDEFG 3行
     * 0A 1B 2C 开始反转
     * 1D 0E 反转
     * 1F 2G
     * 那么整理 0 1 2对应的字符就是答案
     */
    public String convert(String s, int numRows) {
        //特判
        if (numRows == 1) {
            return s;
        }
        //辅助数组
        String[] arr = new String[numRows];
        //初始化
        for (int i = 0; i < arr.length; i++) {
            arr[i]="";
        }
        int index = 0;//对应思路中的012
        int flag = -1;//控制反转
        for (int i = 0; i < s.length(); i++) {
            //如果index为两端，反转
            if (index == 0 || index == numRows - 1) {
                flag = -flag;
            }
            arr[index] += s.charAt(i);
            index += flag;
        }
        String res = "";
        //拼接
        for (String str : arr) {
            res += str;
        }
        return res;
    }
}
