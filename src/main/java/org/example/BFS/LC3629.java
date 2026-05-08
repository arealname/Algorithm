package org.example.BFS;

import java.util.*;

public class LC3629 {


    private static Integer MX = 1_000_001;

    private static List<Integer>[] primeMultiples = new List[MX + 1];

    private static boolean isInit = false;

    //对于v,可以跳到 i-1和i+1
    //如果是质数，可以跳到倍数的位置

    private void init() {

        if (isInit)
            return;

        isInit = true;

        Arrays.setAll(primeMultiples, e -> new java.util.ArrayList<>());

        for (int i = 2; i <= MX; i++) {
            if (primeMultiples[i].isEmpty()) {
                for (int j = i; j <= MX; j += i) {
                    primeMultiples[j].add(i);
                }
            }
        }

    }

    public int minJumps(int[] nums) {

        init();

        Map<Integer, List<Integer>> group = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            for (int p : primeMultiples[nums[i]]) {
                group.computeIfAbsent(p, e -> new ArrayList<>()).add(i);
            }

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
                    if (!vis[j])
                        q.offer(j);
                }
                group.remove(nums[idx]);

            }

            step++;

        }

        return -1;

    }
}
