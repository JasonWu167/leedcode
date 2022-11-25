import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LC30串联所有单词的子串 {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        int w = words[0].length();//一个单词的长度
        int len = w * words.length;//子串长度
        if (len > s.length()) {
            return res;//特判
        }
        HashMap<String, Integer> hashMap = new HashMap<>();
        for (String word : words) {
            if (hashMap.containsKey(word)) {
                int key = hashMap.get(word);
                hashMap.put(word, ++key);
            } else {
                hashMap.put(word, 1);
            }
        }
        HashMap<String, Integer> tempMap = new HashMap<>();
        for (int start = 0; start + len <= s.length(); start++) {
            tempMap.clear();
            int j;
            for (j = 0; j < len; j += w) {
                String temp = s.substring(start + j, start + j + w);//截取一个单词的长度
                if (hashMap.containsKey(temp)) {
                    //如果有这个单词，就让它加入到临时哈希表
                    if (tempMap.containsKey(temp)) {
                        int value = tempMap.get(temp);
                        tempMap.put(temp, ++value);
                        if (value > hashMap.get(temp)) {
                            //如果匹配的单词数比原有的多，跳出
                            break;
                        }
                    } else {
                        tempMap.put(temp, 1);
                    }
                } else {
                    //如果都没有这个单词，跳出
                    break;
                }
            }
            if (j == len) {
                //全部都有，加入结果集
                res.add(start);
            }
        }
        return res;
    }
    //超时了
/*    List<Integer> res = new ArrayList<>();
    List<String> list = new ArrayList<>();

    public List<Integer> findSubstring(String s, String[] words) {
        if (s == null || words[0].length() * words.length > s.length()) {
            return res;
        }
        StringBuffer sb = new StringBuffer();
        bfs(sb, words, 0);
        for (String str : list) {
            int index = -1;
            while (index <= s.length()) {
                index = s.indexOf(str, index);
                if (index == -1) {
                    break;
                }
                if (!res.contains(index)) {
                    res.add(index);
                }
                index += 1;
            }
        }
        return res;
    }

    public void bfs(StringBuffer s, String[] words, int index) {
        if (words.length == index) {
            list.add(s.toString());
            return;
        }
        String help;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals("")) continue;
            s.append(words[i]);
            help = words[i];
            words[i] = "";
            bfs(s, words, index + 1);
            words[i] = help;
            s.delete(index * words[i].length(), (index + 1) * words[i].length());
        }
    }*/

}
