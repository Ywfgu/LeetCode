package com.sort;

import org.junit.Test;

public class QuickSort3 {

    @Test
    public void testSort() {
        boolean result = true;

        int[] num = new int[10];
        for (int i = 0; i < num.length; i++) {
            num[i] = (int) (Math.random() * 10);
        }

        quickSort(num, 0, num.length - 1);
        print(num);

    }

    public static void quickSort(int[] arr, int leftBound, int rightBound) {
        if (leftBound >= rightBound) {
            return;
        }
        int mid = partition(arr, leftBound, rightBound);
        quickSort(arr, leftBound, mid - 1);
        quickSort(arr, mid + 1, rightBound);
    }

    public static int partition(int[] arr, int leftBound, int rightBound) {
        int pivot = arr[rightBound];
        int left = leftBound;
        int right = rightBound - 1;
        while (left < right) {
            while (arr[left] <= pivot && left <= right) left++;

            while (arr[right] > pivot && left < right) right--;

            if (left < right) {
                swap(arr, left, right);
            }
        }
        if (arr[left] > pivot)
            swap(arr, left, rightBound);
        return left;

    }

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

    }
}
