package org.example.Basic;

import java.util.ArrayList;
import java.util.List;

public class LC2553 {
    public int[] separateDigits(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int j : nums) {
            int tmp = j;
            List<Integer> l = new ArrayList();
            while (tmp > 0) {
                l.add(tmp % 10);
                tmp /= 10;
            }
            for (int i = 0; i < l.size(); i++)
                list.add(l.get(l.size() - 1 - i));
        }

        // 处理逻辑

        return list.stream().mapToInt(i -> i).toArray();
    }
}
