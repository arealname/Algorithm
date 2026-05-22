package org.example.binary;

public class LC33 {


    public int search(int[] nums, int target) {
        //只折叠一次，那么必定有一侧是有序的

        int n = nums.length;
        int l = 0, r = n - 1;

        while (l <= r) {
            int mid = (l + r) >> 1;
            if (nums[mid] == target)
                return mid;

            if (nums[l] <= nums[mid]) { //左侧有序
                if (nums[l] <= target && target < nums[mid]) {
                    r = mid - 1;
                } else
                    l = mid + 1;
            } else { //右侧有序
                if (nums[mid] < target && target <= nums[r]) {
                    l = mid + 1;
                } else
                    r = mid - 1;
            }
        }
        return -1;

    }
}
