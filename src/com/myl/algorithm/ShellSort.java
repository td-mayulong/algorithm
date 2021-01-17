package com.myl.algorithm;

import java.util.Arrays;

/**
 * 希尔排序
 * 1、选定一个增长量h，按照增长量h作为数据分组的依据，对数据进行分组。
 * 2、对分好组的每一组数据完成插入排序。
 * 3、减小增长量，最小减为1，重复第二步操作。
 */
public class ShellSort {

    /**
     * 对数组内的元素进行排序
     */
    public static void sort(Comparable[] a) {
       int h = 1;
       while (h < a.length/2) {
           h = 2*h + 1;
       }
       while (h >= 1) {
           for (int i = h; i < a.length; i++) {
               for (int j = i; j >= h; j -= h) {
                   if (greater(a[j-h],a[j])) {
                       exch(a,j-h,j);
                   } else {
                       break;
                   }
               }
           }
           h = h/2;
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
        Integer[] arr = {9,1,2,5,7,4,8,6,3,5};
        ShellSort.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
