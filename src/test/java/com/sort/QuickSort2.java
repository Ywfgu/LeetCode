package com.sort;

import org.junit.Test;

/**
 * 快速排序
 * 时间复杂度 nlogN
 */
public class QuickSort2 {

    @Test
    public void testSort() {

        int[] num = new int[6];
        for (int i = 0; i < num.length; i++) {
            num[i] = (int) (Math.random() * 10);
        }

        quickSort(num);

    }

    public int[] quickSort(int[] arr) {
        partition(arr, 0, arr.length - 1);
        return arr;
    }

    public void partition(int[] arr, int left, int right) {
        if (left >= right) return;

        int pivot = arr[left];
        int l = left;
        int r = right;

        while (l < r) {
            while (l < r && arr[r] > pivot) r--;
            while (l < r && arr[l] <= pivot) l++;

            if (l < r) swap(arr, l, r);
        }

        swap(arr, l, left);
        partition(arr, left, l - 1);
        partition(arr, l + 1, right);

    }

    public void swap(int[] A, int x, int y) {
        int temp = A[x];
        A[x] = A[y];
        A[y] = temp;
    }


}
