package org.example.binary;

public class LC154 {
    public int findMin(int[] nums) {
        int n = nums.length;

        int l = 0, r = n - 1;

        while (l < r) {

            //开始判断,在哪侧

            int mid = (l + r) >> 1;
            if (nums[mid] < nums[r])   //必然在左边
                r = mid;
            else if (nums[mid] == nums[r]) //不确定，但肯定不是最后一个
                r = r - 1;
            else
                l = mid + 1;         //必然在右边
        }

        return nums[r];
    }
}
