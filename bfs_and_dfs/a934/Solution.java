package leedcode.bfs_and_dfs.a934;

import java.util.ArrayDeque;
import java.util.Queue;

public class Solution {

    public int shortestBridge(int[][] grid) {
        int n = grid.length;
        int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};//左右上下

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    Queue<int[]> queue = new ArrayDeque<int[]>();
                    dfs(i, j, grid, queue);//找到第一座岛，并将第一座岛的位置坐标放入队列
                    int step = 0;
                    while (!queue.isEmpty()) {
                        int sz = queue.size();
                        for (int k = 0; k < sz; k++) {
                            int[] cell = queue.poll();//弹出
                            int x = cell[0], y = cell[1];
                            for (int d = 0; d < 4; d++) {
                                int nx = x + dirs[d][0];
                                int ny = y + dirs[d][1];
                                if (nx >= 0 && ny >= 0 && nx < n && ny < n) {//不越界
                                    if (grid[nx][ny] == 0) {
                                        queue.offer(new int[]{nx, ny});
                                        grid[nx][ny] = -1;
                                    } else if (grid[nx][ny] == 1) {
                                        return step;
                                    }
                                }
                            }
                        }
                        step++;
                    }
                }
            }
        }
        return 0;
    }

    public void dfs(int x, int y, int[][] grid, Queue<int[]> queue) {
        if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length || grid[x][y] != 1) {
            return;//如果x.y越界或者坐标值不等于1，返回
        }
        queue.offer(new int[]{x, y});//如果x.y不越界且坐标值等于1，把当前坐标加入队列
        grid[x][y] = -1;//将走过的坐标值记为-1
        dfs(x - 1, y, grid, queue);//向左递归
        dfs(x + 1, y, grid, queue);//右
        dfs(x, y - 1, grid, queue);//上
        dfs(x, y + 1, grid, queue);//下
    }
}



