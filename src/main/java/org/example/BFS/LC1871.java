package org.example.BFS;

import java.util.LinkedList;
import java.util.Queue;



public class LC1871 {
    public boolean canReach(String s, int minJump, int maxJump) {
        char[] chars = s.toCharArray();
        int n = chars.length;
        boolean[] visited = new boolean[n];
        visited[0] = true;


        //使用正宗的BFS,使用一个队列来存储当前可以访问的位置
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        int maxReach = 0; //记录当前可以访问的最远位置


        /**
         *
         * 为什么需要为什么需要它？
         *
         * 假设：
         *
         * current = 10
         * minJump = 2
         * maxJump = 5
         *
         * 那么下一步能访问：
         *
         * [12, 15]
         *
         * 后来：
         *
         * current = 11
         *
         * 又会访问：
         *
         * [13, 16]
         *
         * 注意：
         *
         * 13~15 已经检查过了
         *
         */


        while (!queue.isEmpty()) {
            int current = queue.poll();
            //从当前节点的最远位置开始，尝试访问下一个节点
            for (int next = Math.max(current + minJump, maxReach + 1); next <= Math.min(current + maxJump, n - 1); next++) {
                if (chars[next] == '0' && !visited[next]) {
                    visited[next] = true;
                    queue.offer(next);
                }
            }
            //更新当前可以访问的最远位置
            maxReach = Math.max(maxReach, current + maxJump);
        }
        return visited[n - 1];
    }
}
