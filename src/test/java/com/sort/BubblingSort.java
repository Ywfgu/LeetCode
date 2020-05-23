package com.sort;


import org.junit.Test;

/**
 * 冒泡排序  时间O(n^2) 空间O(n)
 */
public class BubblingSort extends AbstractSort{

    @Test
    @Override
    public void testSort() {
        super.testSort();
    }

    @Override
    public int[] sort(int[] A) {

        // 设立标志位， 默认是不需要交换， 即有序的
        boolean flag = false;
        do {
            for (int i = 0; i < A.length -1; i++) {
                if (A[i] > A[i+1]) {
                    swap(A, i, i+1);
                    flag = true;
                }
            }
            if(!flag) {
                break;
            }
            flag = false;

        }while (true);

        return A;
    }

}
