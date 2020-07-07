package com.sort;

import org.junit.Test;

/**
 * 快速排序
 */
public class QuickSort extends AbstractSort {

    @Test
    @Override
    public void testSort() {
        super.testSort();
    }

    @Override
    public int[] sort(int[] A) {
//        return quickSort(A,0, A.length-1);
        quickSort2(A, 0, A.length - 1);
        return A;
    }

    public void quickSort(int[] arr, int left, int right) {
        if (left > right) return;

        int l = left;
        int r = right;
        int pivot = arr[right];

        while (l < r) {
            while (l < r && arr[l] < pivot) l++;
            while (l < r && arr[r] >= pivot) r--;
            if (l < r) swap(arr, l, r);
        }
        swap(arr, l, right);
        quickSort(arr, left, l - 1);
        quickSort(arr, l + 1, right);

    }


    /**
     * 递归版快速排序
     *
     * @param arr
     * @param left
     * @param right
     */
    public void quickSort2(int[] arr, int left, int right) {
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
        quickSort2(arr, left, l - 1);
        quickSort2(arr, l + 1, right);
    }

}
