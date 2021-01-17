package com.myl.algorithm;

import java.util.Arrays;

/**
 * 选择排序
 * 1、每一次遍历的过程中，都假定都一个索引处的元素是最小值，和其他索引处的值依次进行比较，
 *    如果当前索引处的值大于其他某个索引处的值，则假定其他某个索引处的值为最小值，最后可
 *    以找到最小值所在的索引。
 * 2、交换第一个索引处和最小值所在的索引处的值。
 */
public class SelectionSort {

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
        Integer[] arr = {4,6,8,7,9,2,10,1};
        SelectionSort.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
