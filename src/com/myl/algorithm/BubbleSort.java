package com.myl.algorithm;

import java.util.Arrays;

/**
 * 冒泡排序
 */
public class BubbleSort {

    /**
     * 对数组内的元素进行排序
     */
    public static void sort(Comparable[] a) {
        for (int i = a.length -1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (greater(a[j], a[j+1])) {
                    exch(a,j,j+1);
                }
            }
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
        Integer[] arr = {4,5,6,3,2,1};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

}
