package org.example.UnionFind‌;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LC2812 {


    int[][] dis;

    public int maximumSafenessFactor(List<List<Integer>> grid) {
        /**
         * d越大，越难到达终点,越小则越容易，因此二分
         *
         * 当d=d0时，判断是否能到达终点
         *
         * 1.从终点出发，广度优先搜索，搜索到的点的安全系数都大于等于d0
         * 2.如果能到达终点，说明d0是可行的，尝试更大的d
         */

        //预先处理每个点到最近的1的曼哈顿距离
        int m = grid.size();
        int n = grid.get(0).size();

        dis = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dis[i][j] = m + n - 2;
            }
        }

        // 多源BFS，计算每个点到最近的1的曼哈顿距离
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid.get(i).get(j) == 1) {
                    dis[i][j] = 0;
                    q.offer(new int[]{i, j});
                }
            }
        }
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];

            int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
            for (int[] dir : directions) {
                int newX = x + dir[0];
                int newY = y + dir[1];

                if (newX >= 0 && newX < m && newY >= 0 && newY < n) {
                    if (dis[newX][newY] > dis[x][y] + 1) {
                        dis[newX][newY] = dis[x][y] + 1;
                        q.offer(new int[]{newX, newY});
                    }
                }
            }
        }

        // Binary search for the maximum safeness factor
        int left = 0, right = m + n - 2; // The maximum possible safeness

        while (left+1 < right) {
            int mid = left + (right - left) / 2;
            if (canReach(mid, grid)) {
                left = mid; // mid is feasible, try for a larger d
            } else {
                right = mid; // mid is not feasible, try for a smaller d
            }

        }
        return left;

    }

    public boolean canReach(int d, List<List<Integer>> grid) {
        // Implement the logic to check if we can reach the end with safeness factor d

        Queue<int[]> q = new LinkedList<>();
        int m = grid.size();
        int n = grid.get(0).size();
        if (dis[0][0] < d)
            return false;

        q.offer(new int[]{0, 0});
        boolean[][] visited = new boolean[m][n];
        visited[0][0] = true;

        // BFS
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];

            if (x == m - 1 && y == n - 1) {
                return true;
            }

            // Explore neighbors
            int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
            for (int[] dir : directions) {
                int newX = x + dir[0];
                int newY = y + dir[1];

                //距离最近的1的曼哈顿距离大于等于d

                if (newX >= 0 && newX < m && newY >= 0 && newY < n && !visited[newX][newY] && dis[newX][newY] >= d) {
                    visited[newX][newY] = true;
                    q.offer(new int[]{newX, newY});
                }

            }
        }

        return false; // Placeholder
    }

}
