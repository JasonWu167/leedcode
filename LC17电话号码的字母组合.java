import java.util.ArrayList;
import java.util.List;

public class LC17电话号码的字母组合 {
    //最终返回的结果，作为成员变量使得每个函数都可以访问到
    ArrayList<String> list = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        //对应2-9的按键，0,1没有值
        String[] str = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        //存储数字代表的字符串
        String[] data = new String[digits.length()];
        //初始化
        for (int i = 0; i < digits.length(); i++) {
            data[i] = str[digits.charAt(i) - '0'];
        }
        StringBuilder sb = new StringBuilder();
        getRes(data, sb, 0);
        return list;
    }

    //回溯函数：传入存储数字代表的字符串，StringBuilder，索引
    public void getRes(String[] data, StringBuilder sb, int index) {
        //终止条件
        if (index == data.length) {
            list.add(sb.toString());
            return;
        }
        for (int i = 0; i < data[index].length(); i++) {
            //获取每一个字符，加入StringBuilder
            char c = data[index].charAt(i);
            sb.append(c);//处理
            getRes(data, sb, index + 1);//递归
            sb.deleteCharAt(sb.length() - 1);//回溯
        }
    }

}
