package org.example.dp;

public class LC2770 {
    public int maximumJumps(int[] nums, int target) {
        int n = nums.length;

        int[] f = new int[n];
        for (int i = 0; i < n; i++) {
            f[i] = -1;
        }
        f[0] = 0;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (f[j] != -1 && Math.abs(nums[i] - nums[j]) <= target) {
                    f[i] = Math.max(f[i], f[j] + 1);
                }
            }
        }
        return f[n - 1];
    }
}
