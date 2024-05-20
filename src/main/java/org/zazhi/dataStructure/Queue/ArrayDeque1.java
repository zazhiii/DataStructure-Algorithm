package org.zazhi.dataStructure.Queue;

import java.util.Iterator;

/**
 * @Description 数组 -->双端队列  (已测)
 * @Date 2024/5/20
 * @Created by zazhi
 */
public class ArrayDeque1<E> implements Deque<E>, Iterable<E>{
    public int inc(int i, int length){
        if(i + 1 >= length) return 0;
        return i + 1;
    }
    public int dec(int i, int length){
        if(i - 1 < 0) return length - 1;
        return i - 1;
    }
    E[] array;
    int head;
    int tail;
    @SuppressWarnings("unchecked") // 去除警告
    public ArrayDeque1(int capacity) {
        //tail位置不存元素 所以数组初始化为capacity + 1;
        array = (E[])new Object[capacity + 1];
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            int p = head;
            @Override
            public boolean hasNext() {
                return p != tail;
            }

            @Override
            public E next() {
                E e = array[p];
                p = inc(p, array.length);
                return e;
            }
        };
    }

    @Override
    public boolean offerFirst(E e) { // 先减 在赋值
        if(isFull()) return false;
        head = dec(head, array.length);
        array[head] = e;
        return true;
    }

    @Override
    public boolean offerLast(E e) {// 先赋值 再增加
        if(isFull()) return false;
        array[tail] = e;
        tail = inc(tail, array.length);
        return true;
    }
    /**
     * 数组实现的队列，删除元素时考虑内存释放
     * 若存的基本数据类型无需释放，应用类型则要释放对象
     * 因为加了泛型，所以存的都是应用类型，删除之后要把引用置为null
     */
    @Override
    public E pollFirst() {
        if(isEmpty()) return null;
        E e = array[head];
        array[head] = null; // help GC
        head = inc(head, array.length);
        return e;
    }
    @Override
    public E pollLast() {
        if(isEmpty()) return null;
        tail = dec(tail, array.length);
        E e = array[tail];
        array[tail] = null; // help GC
        return e;
    }

    @Override
    public E peekFirst() {
        return array[head];
    }
    @Override
    public E peekLast() {
        return array[dec(tail, array.length)];
    }

    @Override
    public boolean isEmpty() {
        return head == tail;
    }
    @Override
    public boolean isFull() {//分情况讨论
        /*
            h
                        t
            0   1   2   3
            a   b   c
                h
            t
            0   1   2   3
                c   b   a
         */
        if(tail > head) {
            return tail - head == array.length - 1;
        } else if (tail < head) {
            return head - tail == 1;
        }else {
            return false;
        }
    }
}
