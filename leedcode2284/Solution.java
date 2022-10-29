package leedcode.leedcode2284;

import java.util.HashMap;

public class Solution {
    public String largestWordCount(String[] messages, String[] senders) {
        int n = senders.length;
        if (n == 1) {
            return senders[0];
        }
        HashMap<String, Integer> hashMap = new HashMap<>();
        int max = 0;
        for (int i = 0; i < n; i++) {
            int length = messages[i].split(" ").length;
            if (!hashMap.containsKey(senders[i])) {
                hashMap.put(senders[i], length);
            } else {
                hashMap.put(senders[i], hashMap.get(senders[i]) + length);
            }
            max = Math.max(max, hashMap.get(senders[i]));
        }
        String res = "";
        for (String name : hashMap.keySet()) {
            if (hashMap.get(name) == max) {
                if (name.compareTo(res)>0) {
                    res = name;
                }
            }
        }
        return res;
    }
}
