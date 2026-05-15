package org.example.binary;

public class LC153 {

    class Solution {
        public int findMin(int[] nums) {
            int n = nums.length;

            int l = 0, r = n - 1;

            while (l < r) {

                if (nums[l] < nums[r])
                    return nums[l];

                //开始判断,在哪侧

                int mid = (l + r) >> 1;
                if (nums[mid] < nums[r])
                    r = mid;
                else
                    l = mid + 1;
            }

            return nums[r];
        }
    }
}
