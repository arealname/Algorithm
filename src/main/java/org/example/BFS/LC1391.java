package org.example.BFS;

public class LC1391 {

    public boolean hasValidPath(int[][] grid) {

        //BFS
        int m = grid.length, n = grid[0].length;
        boolean[][] visited = new boolean[m][n];

        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        java.util.Queue<int[]> queue = new java.util.LinkedList<>();
        queue.offer(new int[]{0, 0});
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int x = cell[0], y = cell[1];

            // System.out.println(x+","+y);
            if (x == m - 1 && y == n - 1) {
                return true;
            }
            int type = grid[x][y];
            for (int[] dir : directions) {
                int nx = x + dir[0], ny = y + dir[1];
                if (nx >= 0 && nx < m && ny >= 0 && ny < n && !visited[nx][ny]) {
                    if (isConnected(type, grid[nx][ny], dir)) {
                        visited[nx][ny] = true;
                        queue.offer(new int[]{nx, ny});
                    }
                }
            }
        }
        return false;

    }

    public boolean isConnected(int type1, int type2, int[] dir) {
        //根据type1和dir判断是否可以连接到type2
        if (type1 == 1) {
            return (dir[0] == 0 && dir[1] == 1 && (type2 == 1 || type2 == 3 || type2 == 5)) ||
                    (dir[0] == 0 && dir[1] == -1 && (type2 == 1 || type2 == 4 || type2 == 6));
        } else if (type1 == 2) {
            return (dir[0] == -1 && dir[1] == 0 && (type2 == 2 || type2 == 3 || type2 == 4)) ||
                    (dir[0] == 1 && dir[1] == 0 && (type2 == 2 || type2 == 5 || type2 == 6));
        } else if (type1 == 3) {
            return (dir[0] == 0 && dir[1] == -1 && (type2 == 1 || type2 == 4 || type2 == 6)) ||
                    (dir[0] == 1 && dir[1] == 0 && (type2 == 2 || type2 == 5 || type2 == 6));
        } else if (type1 == 4) {
            return (dir[0] == 0 && dir[1] == 1 && (type2 == 1 || type2 == 3 || type2 == 5)) ||
                    (dir[0] == 1 && dir[1] == 0 && (type2 == 2 || type2 == 5 || type2 == 6));
        } else if (type1 == 5) {
            return (dir[0] == -1 && dir[1] == 0 && (type2 == 2 || type2 == 4 || type2 == 3)) ||
                    (dir[0] == 0 && dir[1] == -1 && (type2 == 1 || type2 == 6 || type2 == 4));
        } else { // type1 = 6
            return (dir[0] == -1 && dir[1] == 0 && (type2 == 2 || type2 == 4 || type2 == 3)) ||
                    (dir[0] == 0 && dir[1] == 1 && (type2 == 1 || type2 == 3 || type2 == 5));

        }
    }


}
