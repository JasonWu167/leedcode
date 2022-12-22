import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC39组合总和 {
    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        ArrayList<Integer> list = new ArrayList<>();
        bfs(candidates, target, 0, list,0);
        return res;
    }

    private void bfs(int[] candidates, int target, int sum, List<Integer> list,int index) {

        if (sum == target) {
            ArrayList<Integer> list1 = new ArrayList<>(list);
            res.add(list1);
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            if (sum+candidates[i] > target) {
                return;
            }
            list.add(candidates[i]);
            bfs(candidates, target,sum+candidates[i],list,i);
            list.remove((Object)candidates[i]);
        }
    }

    public static void main(String[] args) {
        LC39组合总和 main = new LC39组合总和();
        System.out.println(main.combinationSum(new int[]{}, 1));
    }
}
