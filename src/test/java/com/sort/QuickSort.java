package com.sort;

import org.junit.Test;

/**
 * 快速排序
 */
public class QuickSort extends AbstractSort{

    @Test
    @Override
    public void testSort() {
        super.testSort();
    }

    @Override
    public int[] sort(int[] A) {
//        return quickSort(A,0, A.length-1);
        quickSort2(A,0, A.length-1);
        return A;
    }


//    public int[] quickSort(int[] A, int left, int right){
//        if(left < right){
//            int p = sortPartition(A, left, right);
//            quickSort(A, left, p-1);
//            quickSort(A, p+1, right);
//        }
//        return A;
//    }

    /**
     * 寻找一个基准数，并将基准数放到数组中最终的位置上，并返回下标
     * @param A 数组
     * @param left 左边界
     * @param right 右边界
     * @return 基准数应该所在的下标
     */
    private int sortPartition(int[] A, int left, int right) {
        int p = left;
        int index = p+1;
        for (int i = index; i <= right; i++) {
            if(A[i] < A[p]){
                swap(A, index, i);
                index ++;
            }
        }
        swap(A, p, index-1);
        return index-1;
    }

    private int sortPartition2(int[] A, int left, int right) {
        //TODO 寻求一个基数
        //TODO 从left往后找一个比基数大的下标i 从right往前找一个比基数小的下标j 交换这两个下标 直到两个指针不满足i<j

        return 0;
    }


    public void quickSort2(int[] arr, int left, int right)
     {
         if(left>=right) return ;
         int par = arr[left];
         int l=left;
         int r=right;
         while(l<r)
         {
             while(l<r && arr[r]>par)
             {
                 r--;
             }

             while(l<r && arr[l]<=par)
             {
                 l++;
             }
             if(l<r)
                 swap(arr, l, r);
         }
         swap(arr,left,l);
         quickSort2(arr, left, l-1);
         quickSort2(arr, l+1, right);
     }

}
