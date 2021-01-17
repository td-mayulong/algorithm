package com.myl.algorithm;

import java.util.Iterator;

/**
 * 线性表-顺序表
 * 线性表是在计算机内存中以数组的形式保存的线性表，线性表的顺序存储是指用一组地址连续的存储单元，依次存储线性表中的各个元素、
 * 使得线性表中在逻辑结构上相应的数据元素存储在相邻的物理存储单元中，即通过数据元素物理存储相邻关系来反映数据元素之间逻辑上
 * 的相邻关系。
 */
public class SequenceList<T> implements Iterable<T> {

    //存储元素的数组
    private T[] eles;

    //记录当前顺序表中元素的个数
    private int N;

    public SequenceList(int capacity) {
        this.eles = (T[])new Object[capacity];
        this.N = 0;
    }

    //将一个线性表置为空表
    public void clear() {
        this.N = 0;
    }

    //判断当前线性表是否为空表
    public boolean isEmpty() {
        return N == 0;
    }

    //获取线性表的长度
    public int length() {
        return N;
    }

    //获取指定位置的元素
    public T get(int i) {
        return eles[i];
    }

    //向线性表中添加元素
    public void insert(T t) {
        if (N == eles.length) {
            resize(2*eles.length);
        }
        eles[N++] = t;
    }

    //在i元素处插入元素t
    public void insert(int i,T t) {
        for (int index = N; index > i ; index--) {
            eles[index] = eles[index -1];
        }
        eles[i] = t;
        N++;
    }

    //删除指定位置i处的元素，并返回该元素
    public T remove(int i) {
        T current = eles[i];
        for (int index = i; index < N-1; index++) {
            eles[index] = eles[index + 1];
        }
        N--;
        if (N < eles.length/4) {
            resize(eles.length/2);
        }
        return current;
    }

    //查找t元素第一次出现的位置
    public int indexOf(T t) {
        for (int i = 0; i < N; i++) {
            if (eles[i].equals(t)) {
                return i;
            }
        }
        return -1;
    }

    //数组扩容
    public void resize(int newSize) {
        T[] temp = eles;
        eles = (T[])new Object[newSize];
        for (int i = 0; i < N; i++) {
            eles[i] = temp[i];
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new SIterator();
    }

    private class SIterator implements Iterator{

        private int cusor;

        public SIterator() {
            this.cusor = 0;
        }

        @Override
        public boolean hasNext() {
            return cusor < N;
        }

        @Override
        public Object next() {
            return eles[cusor++];
        }
    }

    //测试
    public static void main(String[] args) {
        SequenceList<String> sl = new SequenceList<>(3);
        sl.insert("姚明");
        sl.insert("科比");
        sl.insert("麦迪");
        sl.insert("詹姆斯");
        //sl.insert(1,"詹姆斯");

        for (String s : sl) {
            System.out.println(s);
        }
        System.out.println("------------------");

        String getResult = sl.get(1);
        System.out.println("获取索引1处的结果为：" + getResult);

        String removeResult = sl.remove(0);
        System.out.println("删除的元素是：" + removeResult);

        sl.clear();
        System.out.println("清空后的线性表中的元素个数为：" + sl.length());

    }

}
