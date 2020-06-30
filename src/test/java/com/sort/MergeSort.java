package com.sort;

import org.junit.Test;

/**
 * 归并排序
 */
public class MergeSort {

    @Test
    public void test(){
        int[] a = {5,3,4,1};
        mergeSort(a, 0, a.length-1);
        System.out.println();
    }
    public void mergeSort(int[] arr, int left, int right){
        if(left >= right) return;
        int mid = left + (right - left)/2;
        mergeSort(arr, left, mid);
        mergeSort(arr, mid+1, right);
        merge(arr, left, right, mid);
    }

    public void merge(int[] arr, int left, int right, int mid){
        int[] temp = new int[right - left + 1];
        int p1 = left;
        int p2 = mid+1;
        int i = 0;
        while (p1 <= mid && p2 <= right){
            temp[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= mid){
            temp[i++] = arr[p1++];
        }
        while (p2 <= right){
            temp[i++] = arr[p2++];
        }
        for (int j = 0; j < temp.length; j++) {
            arr[left + j] = temp[j];
        }
    }
}
