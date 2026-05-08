package org.example.BFS;

import java.util.*;

public class LC1345 {
    //对于v,可以跳到 i-1和i+1
    //另外可以跳到相同数的位置

    public int minJumps(int[] nums) {

        Map<Integer, List<Integer>> group = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            group.computeIfAbsent(nums[i], e -> new ArrayList<>()).add(i);
        }

        //BFS

        Queue<Integer> q = new LinkedList<>();

        q.offer(0);

        boolean[] vis = new boolean[nums.length];

        int step = 0;

        while (!q.isEmpty()) {

            int sz = q.size();

            for (int i = 0; i < sz; i++) {

                int idx = q.poll();

                if (idx == nums.length - 1)
                    return step;

                if (vis[idx])
                    continue;

                vis[idx] = true;

                if (idx - 1 >= 0 && !vis[idx - 1])
                    q.offer(idx - 1);

                if (idx + 1 < nums.length && !vis[idx + 1])
                    q.offer(idx + 1);

                List<Integer> l = group.computeIfAbsent(nums[idx], e -> new ArrayList<>());
                for (int j : l) {
                    if (!vis[j] && j != idx)
                        q.offer(j);
                }
                group.remove(nums[idx]);

            }

            step++;

        }

        return -1;

    }
}
