package com.sort;

import org.junit.Test;

/**
 * 插入排序 时间O(n^2) 空间O(n)
 */
public class InsertSort extends AbstractSort{

    @Test
    @Override
    public void testSort() {
        super.testSort();
    }

    @Override
    public int[] sort(int[] A) {

        for (int i = 1; i < A.length; i++) {
            int n =i;
            if(A[i] > A[i-1]) continue;
            for (int j = n-1; j >= 0 ; j--) {
                if(A[n] < A[j] ){
                    swap(A, n, j);
                    n--;
                }
            }
        }
        return A;
    }



}
