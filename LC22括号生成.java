import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LC22括号生成 {
    class Node {
        private String val;
        private int left;
        private int right;

        public Node(String val, int left, int right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public List<String> generateParenthesis(int n) {
        ArrayList<String> res = new ArrayList<>();
        if (n == 0) {
            return res;//特判
        }
        //准备队列，bfs常用方法
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node("", 0, 0));

        while (!queue.isEmpty()) {
            Node curNode = queue.poll();
            //终止条件：左括号和右括号等于括号数
            if (curNode.left == n && curNode.right == n) {
                res.add(curNode.val);
            }
            if(curNode.left < curNode.right){
                continue;//左括号小于右括号
            }
            //添加左括号
            if (curNode.left <n ) {
                queue.offer(new Node(curNode.val + "(", curNode.left + 1, curNode.right));
            }
            //添加右括号
            if (curNode.right <n ) {
                queue.offer(new Node(curNode.val + ")", curNode.left, curNode.right + 1));
            }
        }
        return res;
    }

//    public void dfs(String s, int left, int right, List<String> res, int n) {
//        //终止条件：左括号和右括号等于括号数
//        if (left == n && right == n) {
//            res.add(s);
//            return;
//        }
//        if (left < right) {
//            return;//左括号小于右括号，剪枝
//        }
//        if (left < n) {
//            //添加左括号
//            dfs(s + "(", left + 1, right, res, n);
//        }
//        if (right < n) {
//            //添加右括号
//            dfs(s + ")", left, right + 1, res, n);
//        }
//    }
}
