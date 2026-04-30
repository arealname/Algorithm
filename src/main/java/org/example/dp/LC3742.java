package org.example.dp;

import java.util.Arrays;

public class LC3742 {

        public int maxPathScore(int[][] grid, int k) {
            int m = grid.length, n = grid[0].length;
            int NEG = Integer.MIN_VALUE / 2; // 防止溢出

            int[][][] dp = new int[m][n][k + 1];

            // 初始化
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    Arrays.fill(dp[i][j], NEG);
                }
            }

            // 起点
            for (int p = 0; p <= k; p++) {
                dp[0][0][p] = grid[0][0];
            }

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {

                    if (i == 0 && j == 0) continue;

                    for (int p = 0; p <= k; p++) {

                        int val = grid[i][j];

                        // 从上方转移
                        if (i > 0) {
                            if (val == 0) {
                                dp[i][j][p] = Math.max(dp[i][j][p], dp[i - 1][j][p]);
                            } else if (p > 0) {
                                dp[i][j][p] = Math.max(dp[i][j][p], dp[i - 1][j][p - 1] + val);
                            }
                        }

                        // 从左方转移
                        if (j > 0) {
                            if (val == 0) {
                                dp[i][j][p] = Math.max(dp[i][j][p], dp[i][j - 1][p]);
                            } else if (p > 0) {
                                dp[i][j][p] = Math.max(dp[i][j][p], dp[i][j - 1][p - 1] + val);
                            }
                        }
                    }
                }
            }

            int ans = NEG;
            for (int p = 0; p <= k; p++) {
                ans = Math.max(ans, dp[m - 1][n - 1][p]);
            }

            return ans < 0 ? -1 : ans;
        }

}
