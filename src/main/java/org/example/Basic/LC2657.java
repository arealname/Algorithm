package org.example.Basic;

import java.util.HashSet;
import java.util.Set;

public class LC2657 {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;

        Set<Integer> ca = new HashSet();
        Set<Integer> cb = new HashSet();

        int[] re = new int[n];
        re[0] = A[0] == B[0] ? 1 : 0;
        ca.add(A[0]);
        cb.add(B[0]);
        for (int i = 1; i < n; i++) {
            int a = A[i], b = B[i];
            if (a == b)
                re[i] = re[i - 1] + 1;
            else
                re[i] = re[i - 1] + (ca.contains(b) ? 1 : 0) + (cb.contains(a) ? 1 : 0);
            ca.add(a);
            cb.add(b);

        }
        return re;
    }
}
