package org.example.greedy;

import java.util.Arrays;

public class LC945 {
    public int minIncrementForUnique(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int pre = nums[0];
        int ans = 0;
        for (int i = 1; i < n; i++) {
            if (nums[i] <= pre) {
                ans += pre + 1 - nums[i];
                pre++;
            } else
                pre = nums[i];
        }
        return ans;
    }
}
