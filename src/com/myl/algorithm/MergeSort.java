package com.myl.algorithm;

import java.util.Arrays;

/**
 * 归并排序
 * 1、尽可能的一组数据拆分成两个元素相等的子组，并对每一个子组继续拆分，直到拆分后的每个子组的元素个数是1为止。
 * 2、将相邻的两个子组进行合并成一个有序的大组；
 * 3、不断的重复步骤二，直到最终只有一个组为止。
 */
public class MergeSort {

    private static Comparable[] assist;

    /**
     * 对数组内的元素进行排序
     */
    public static void sort(Comparable[] a) {
        assist = new Comparable[a.length];
        int left = 0;
        int right = a.length - 1;
        sort(a,left,right);
    }

    /**
     * 对数组a中从索引left到索引right之间的元素进行排序
     */
    private static void sort(Comparable[] a,int left,int right) {
        if (right <= left) {
            return;
        }
        int mid = left + (right - left)/2;
        sort(a,left,mid);
        sort(a,mid + 1,right);
        merge(a,left,mid,right);
    }

    /**
     * 从索引left到索引mid为一个子组，从索引mid+1到索引right为另一个子组，
     * 把数组a中的这两个子组的数据合并成一个有序的大组（从索引left到索引right）
     */
    private static void merge(Comparable[] a,int left,int mid,int right) {
        int tIndex = left;
        int cIndex = left;
        int r1 = mid + 1;
        while (left <= mid && r1 <= right) {
            if (less(a[left],a[r1])) {
                assist[tIndex++] = a[left++];
            } else {
                assist[tIndex++] = a[r1++];
            }
        }
        while (left <= mid) {
            assist[tIndex++] = a[left++];
        }

        while (r1 <= right) {
            assist[tIndex++] = a[r1++];
        }
        for (int index = cIndex; index <= right; index++) {
            a[index] = assist[index];
        }
    }

    /**
     * 判断v是否小于w
     */
    private static boolean less(Comparable v,Comparable w) {
        return v.compareTo(w) < 0;
    }

    //测试
    public static void main(String[] args) {
        Integer[] arr = {8,4,5,7,1,3,6,2};
        MergeSort.sort(arr);
        System.out.println(Arrays.toString(arr));
    }

}
