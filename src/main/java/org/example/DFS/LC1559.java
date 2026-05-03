package org.example.DFS;

public class LC1559 {
    public boolean containsCycle(char[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] != '#') {
                    if (dfs(grid, i, j, -1, -1)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }


    public boolean dfs(char[][] g, int x, int y, int fromX, int fromY) {
        if (x < 0 || x >= g.length || y < 0 || y >= g[0].length) {
            return false;
        }


        //如果到达 一个已经访问过的格子，说明存在环
        if (g[x][y] == '#') {
            return true;
        }

        //标记当前格子为访问过

        g[x][y] = '#';


        // 四个方向
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        for (int[] dir : directions) {
            int newX = x + dir[0];
            int newY = y + dir[1];

            // 跳过上一个格子
            if (newX == fromX && newY == fromY) {
                continue;
            }

            if (dfs(g, newX, newY, x, y)) {
                return true;
            }
        }

        return false;
    }

}
