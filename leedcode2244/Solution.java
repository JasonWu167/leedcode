package leedcode.leedcode2244;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int minimumRounds(int[] tasks) {
        int n = tasks.length;
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int task : tasks) {
            if (!hashMap.containsKey(task)) {
                hashMap.put(task, 1);
            } else {
                int v = hashMap.get(task);
                hashMap.put(task, v + 1);
            }
        }
        int res = 0;
        for (Map.Entry<Integer, Integer> entry : hashMap.entrySet()) {
            int i = entry.getValue() / 3;
            int j = entry.getValue() % 3;
            if (i == 0 && j == 1) {
                return -1;
            }
            res += i;
            if (j != 0) {
                res += 1;
            }
        }
        return res;
    }
}
