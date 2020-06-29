package com.leetcode.sort;

import org.junit.Test;

import java.util.Arrays;

/**
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 * 示例 2:
 * <p>
 * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 * 输出: 4
 * 说明:
 * <p>
 * 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。
 */
public class Code215_KthLargest {
    @Test
    public void test() {
        int[] a = {5, 2, 1, 4, 2};
        System.out.println(findKthLargest(a, 1));
        System.out.println(findKthLargest2(a, 1));
    }

    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    public int findKthLargest2(int[] nums, int k) {
        quickSort(nums, 0, nums.length - 1, k);
        return nums[nums.length - k];
    }

    public void quickSort(int[] nums, int left, int right, int k) {
        if (left >= right) return;
        int pivot = partition(nums, left, right);
        swap(nums, pivot, left);
        quickSort(nums, left, pivot - 1, k);
        quickSort(nums, pivot + 1, right, k);
    }

    private int partition(int[] nums, int left, int right) {
        int pivot = nums[left];
        int l = left;
        int r = right;

        while (l < r) {
            while (l < r && nums[r] > pivot) r--;
            while (l < r && nums[l] <= pivot) l++;

            if (l < r) swap(nums, l, r);
        }
        return l;
    }

    private void swap(int[] nums, int l, int r) {
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }
}
