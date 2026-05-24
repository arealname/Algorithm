package org.example.DFS;

import java.util.ArrayDeque;
import java.util.Deque;

public class LC1340 {
    //先计算每个位置向左向右的最大位置，受到 d和 大小的限制

    int n;
    int[] left;
    int[] right;
    int[] f;

    public int maxJumps(int[] arr, int d) {

        init(arr, d);
        f = new int[n];

        int ans = 1;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, dfs(i));
        }
        return ans;
    }

    public int dfs(int i) { //从i出发可以到达的最长路径

        if (f[i] != 0)
            return f[i];
        int res = 1;
        for (int j = left[i]; j <= right[i]; j++) {
            if (j != i) {
                res = Math.max(res, dfs(j) + 1);
            }
        }
        return f[i] = res;
    }

    public void init(int[] arr, int d) {
        n = arr.length;
        left = new int[n];
        right = new int[n];

        //从左到右的单调递增栈

        Deque<Integer> st = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] < arr[i]) {
                st.pop();
            }
            left[i] = Math.max(i - d, 0);

            if (!st.isEmpty())
                left[i] = Math.max(left[i], st.peek() + 1);

            st.push(i);
        }

        //右边同理

        st.clear();

        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] < arr[i]) {
                st.pop();
            }
            right[i] = Math.min(i + d, n - 1);

            if (!st.isEmpty())
                right[i] = Math.min(right[i], st.peek() - 1);

            st.push(i);
        }
    }

    public static void main(String[] args) {
        //[6,4,14,6,8,13,9,7,10,6,12]
        int[] arr = new int[]{6, 4, 14, 6, 8, 13, 9, 7, 10, 6, 12};
        int d = 2;
        LC1340 lc1340 = new LC1340();
        int ans = lc1340.maxJumps(arr, d);
        System.out.printf("%d", ans);

    }


}
