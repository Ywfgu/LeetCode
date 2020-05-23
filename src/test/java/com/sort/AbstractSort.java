package com.sort;

import java.util.Arrays;

public abstract class AbstractSort {

    public void testSort(){
        int[] A = {3, 2, 1, 4, 5};
        System.out.println(Arrays.toString(A) +" --> "+  Arrays.toString(sort(A)));
        int[] B = {1, 1, 2, 1, 1};
        System.out.println(Arrays.toString(B) +" --> "+  Arrays.toString(sort(B)));
        int[] C = {1,5,7,45,54,4,7,9,3,54,8234,8,4,35,6,7,5334,89};
        System.out.println(Arrays.toString(C) +" --> "+  Arrays.toString(sort(C)));
    }
    public abstract int[] sort(int[] A);

    /**
     * 交换数组A中下标为x和y的元素
     * @param A 数组A
     * @param x 下标x
     * @param y 下标y
     */
    public void swap(int[] A, int x, int y){
        int temp = A[x];
        A[x] = A[y];
        A[y] = temp;
    }
}
