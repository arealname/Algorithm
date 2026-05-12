package org.example.greedy;

import java.util.Arrays;

public class LC1665 {
    public int minimumEffort(int[][] tasks) {
        Arrays.sort(tasks, (a, b) -> (b[1] - b[0]) - (a[1] - a[0]));
        int ans = 0;

        int left = 0; //初始能量

        for (int[] task : tasks) {
            if (task[1] <= left) { //直接过
                left -= task[0];
            } else {
                ans += task[1] - left;
                left = task[1] - task[0];
            }
        }
        return ans;
    }
}
