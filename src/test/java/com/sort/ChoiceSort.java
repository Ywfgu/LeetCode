package com.sort;

import org.junit.Test;

/**
 * 选择排序 时间O(n^2) 空间O(n)
 */
public class ChoiceSort extends AbstractSort{


    @Test
    @Override
    public void testSort() {
        super.testSort();
    }

    @Override
    public int[] sort(int[] A) {
        int index;
        for (int i = 0; i < A.length; i++) {
            index = getMinIndex(A, i, A.length -1);
            if ( index != i){
                swap(A, i, index);
            }
        }
        return A;
    }

    /**
     * 获取数据中最小的元素下标
     * @param A 数组A
     * @param s 开始下标
     * @param e 结束下标
     * @return s-e区间内最小元素的下标
     */
    public int getMinIndex(int[] A, int s, int e){
        int min = s;
        for (int i = s; i <= e; i++) {
            if (A[min] > A[i]){
                min = i;
            }
        }
        return min;
    }

}
