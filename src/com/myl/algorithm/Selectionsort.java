package com.myl.algorithm;

import java.util.Arrays;

/**
 * 选择排序
 */
public class Selectionsort {

    /**
     * 对数组内的元素进行排序
     */
    public static void sort(Comparable[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < a.length; j++) {
                if (greater(a[minIndex],a[j])) {
                    minIndex = j;
                }
            }
            exch(a,i,minIndex);
        }
    }

    /**
     * 判断v是否大于w
     */
    public static boolean greater(Comparable v, Comparable w){
        return v.compareTo(w) > 0;
    }

    /**
     *  交换a数组中，索引i和索引j的位置
     */
    public static void exch(Comparable[] a, int i, int j) {
        Comparable temp;
        temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    //测试
    public static void main(String[] args) {
        Integer[] arr = {4,6,8,7,9,2,10,1};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
