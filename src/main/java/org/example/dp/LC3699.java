package org.example.dp;

public class LC3699 {


    /**
     * 给你 三个整数 n、l 和 r。
     *
     * 长度为 n 的锯齿形数组定义如下：
     *
     * 每个元素的取值范围为 [l, r]。
     * 任意 两个 相邻的元素都不相等。
     * 任意 三个 连续的元素不能构成一个 严格递增 或 严格递减 的序列。
     * 返回满足条件的锯齿形数组的总数。
     *
     * 由于答案可能很大，请将结果对 109 + 7 取余数。
     * @param n
     * @param l
     * @param r
     * @return
     */


    /**
     *
   思路    假设第n个元素为x，第n-1个元素＜x，则第n-2个元素必须大于等于x，否则会形成严格递增的序列。
          假设第n个元素为x，第n-1个元素＞x，则第n-2个元素必须小于等于x，否则会形成严格递减的序列


     f[i][j]表示长度为i，最后一个元素为j且最后两个元素为递增的锯齿数组的数量
     g[i][j]表示长度为i，最后一个元素为j且最后两个元素为递减的锯齿数组的数量
     f[i][j] = sum(g[i-1][k])，其中k<j
     g[i][j] = sum(f[i-1][k])，其中k>j

     结果 = sum(f[n][j] + g[n][j])，其中l<=j<=r
     初始条件：
     f[1][j] = 1，l<=j<=r
     g[1][j] = 1，l<=j<=r

     */




    //锯齿数组的数量
    public int zigZagArrays(int n, int l, int r) {
        int[][] f = new int[n + 1][r + 1];
        int[][] g = new int[n + 1][r + 1];
        int mod = 1000000007;
        for (int j = l; j <= r; j++) {
            f[1][j] = 1;
            g[1][j] = 1;
        }

        for (int i = 2; i <= n; i++) {
            for (int j = l; j <= r; j++) {
                //计算f[i][j]
                for (int k = l; k < j; k++) {
                    f[i][j] = (f[i][j] + g[i - 1][k]) % mod;
                }
                //计算g[i][j]
                for (int k = j + 1; k <= r; k++) {
                    g[i][j] = (g[i][j] + f[i - 1][k]) % mod;
                }
            }
        }

        int result = 0;
        for (int j = l; j <= r; j++) {
            result = (result + f[n][j] + g[n][j]) % mod;
        }
        return result;
    }


    public static void main(String[] args) {

    }
}
