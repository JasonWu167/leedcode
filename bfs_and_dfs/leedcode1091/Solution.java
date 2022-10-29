package leedcode.bfs_and_dfs.leedcode1091;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int[][] dir = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}, {-1, -1}, {-1, 1}, {1, 1}, {1, -1}};
        int n = grid.length;
        if (grid[0][0] != 0 || grid[n - 1][n - 1] != 0){
            return -1;
        }
        if (n == 1) {
            return 1;
        }
        boolean[][] vis = new boolean[n][n];
        Queue<int[]> queue = new LinkedList<>();
        int distance = 1;
        queue.offer(new int[]{0, 0});
        vis[0][0] = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int c = 0; c < size; ++c) {
                int[] poll = queue.poll();
                int i = poll[0];
                int j = poll[1];
                for (int k = 0; k < 8; ++k) {
                    int ni = i + dir[k][0];
                    int nj = j + dir[k][1];
                    if (ni >= 0 && ni < n && nj >= 0 && nj < n && grid[ni][nj] == 0 && !vis[ni][nj]) {
                        if (ni == n - 1 && nj == n - 1) {
                            return distance + 1;
                        }
                        queue.offer(new int[]{ni, nj});
                        vis[ni][nj] = true;
                    }
                }
            }
            distance += 1;
        }
        return -1;
    }
}
