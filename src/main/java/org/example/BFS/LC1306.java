package org.example.BFS;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class LC1306 {

    public boolean canReach(int[] nums, int start) {
        Queue<Integer> q = new ArrayDeque();

        int n = nums.length;
        boolean[] v = new boolean[n];
        Arrays.fill(v, false);

        q.offer(start);
        while (!q.isEmpty()) {
            int t = q.poll();
            if (nums[t] == 0)
                return true;
            v[t] = true;
            if (t + nums[t] < n && t + nums[t] >= 0 && !v[t + nums[t]])
                q.offer(t + nums[t]);
            if (t - nums[t] < n && t - nums[t] >= 0 && !v[t - nums[t]])
                q.offer(t - nums[t]);

        }
        return false;
    }
}
