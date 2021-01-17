package com.myl.algorithm;

import java.util.Arrays;

/**
 * 插入排序
 * 1、把所有的元素分为两组，已经排序的和未排序的。
 * 2、找到未排序的组中的第一个元素，向已排序的组中进行插入。
 * 3、倒序遍历已经排序的元素，依次和待插入的元素进行比较，直到找到一个元素小于等于待插入元素，
 *    那么就把待插入元素放到这个位置，其他的元素向后移动一位。
 */
public class InsertionSort {

    /**
     * 对数组内的元素进行排序
     */
    public static void sort(Comparable[] a) {
        for (int i = 1; i < a.length; i++) {
            for (int j = i; j > 0; j--) {
                if (greater(a[j-1],a[j])) {
                    exch(a,j-1,j);
                } else {
                    break;
                }
            }
        }
    }

    /**
     * 判断v是否大于w
     */
    private static boolean greater(Comparable v, Comparable w){
        return v.compareTo(w) > 0;
    }

    /**
     *  交换a数组中，索引i和索引j的位置
     */
    private static void exch(Comparable[] a, int i, int j) {
        Comparable temp;
        temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    //测试
    public static void main(String[] args) {
        Integer[] arr = {4,3,2,10,12,1,5,6};
        InsertionSort.sort(arr);
        System.out.println(Arrays.toString(arr));
    }

}
