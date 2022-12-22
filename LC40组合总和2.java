import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC40组合总和2 {
    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<Integer> list = new ArrayList<>();
        dfs(candidates, target, list, 0, 0);
        return res;
    }

    private void dfs(int[] candidates, int target, List<Integer> list, int num, int index) {
        if (num == target) {
            res.add(new ArrayList(list));
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            if (num + candidates[i] > target) {
                return;//剪枝
            }
            // 防止重复，也是剪枝
            if (i > index && candidates[i] == candidates[i - 1]) continue;
            list.add(candidates[i]);
            dfs(candidates, target, list, num + candidates[i], i + 1);//递归
            list.remove((Object) candidates[i]);//回溯
        }
    }

    public static void main(String[] args) {
        LC40组合总和2 main = new LC40组合总和2();
        System.out.println(main.combinationSum2(new int[]{2, 5, 2, 1, 2}, 5));
    }
}
