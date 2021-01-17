package com.myl.algorithm;

import java.util.Arrays;

/**
 * 快速排序
 * 1、首先设定一个分界值，通过该分界值将数组分成左右两部分；
 * 2、将大于或等于分界值的数据放到数组右边，小于分界值的数据放到数组的左边。此时左边部分中各元素都小于或等于分界值，
 *    而右边部分中各元素都大于或等于分界值；
 * 3、然后，左边和右边的数据可以独立排序。对于左侧的数组数据，又可以取一个分界值，将该部分数据分成左右两部分，同样
 *    在左边放置较小值，右边放置较大值。右侧的数组数据也可以做类似处理。
 * 4、重复上述过程，可以看出，这是一个递归的定义。通过递归将左侧部分排好序后，再递归排好右侧部分的顺序。当左侧和右
 *    侧两个部分的数据排完序后，整个数组的排序也就完成了。
 */
public class QuickSort {

    /**
     * 对数组内的元素进行排序
     */
    public static void sort(Comparable[] a) {
        int lo = 0;
        int hi = a.length - 1;
        sort(a,lo,hi);
    }

    /**
     * 对数组a中从索引lo到索引hi之间的元素进行排序
     */
    private static void sort(Comparable[] a,int lo,int hi) {
        if (hi <= lo) {
            return;
        }
        int partition = partition(a, lo, hi);
        sort(a,lo,partition - 1);
        sort(a,partition + 1,hi);
    }

    /**
     * 判断v是否小于w
     */
    private static boolean less(Comparable v,Comparable w) {
        return v.compareTo(w) < 0;
    }

    /**
     * 数组元素i和j交换位置
     */
    private static void exch(Comparable[] a,int i,int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static int partition(Comparable[] a,int lo,int hi) {
        Comparable key = a[lo];
        int left = lo;
        int right = hi + 1;
        while (true) {
            while (less(key,a[--right])) {
                if (right == lo) {
                    break;
                }
            }
            while (less(a[++left],key)) {
                if (left == hi) {
                    break;
                }
            }
            if (left >= right) {
                break;
            } else {
                exch(a,left,right);
            }
        }
        exch(a,lo,right);
        return right;
    }

    //测试
    public static void main(String[] args) {
        Integer[] arr = {6,1,2,7,9,3,4,5,8};
        QuickSort.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
