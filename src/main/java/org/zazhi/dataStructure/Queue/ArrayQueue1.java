package org.zazhi.dataStructure.Queue;

import java.util.Iterator;

/**
 * @Description 环形数组实现队列, 通过head tail指针实现判断队列空/满的方法
 * @Date 2024/1/31
 * @Created by zazhi
 */
public class ArrayQueue1<E> implements Queue<E>,Iterable<E> {
    E[] array;
    int head = 0;
    int tail = 0;

    public ArrayQueue1(int capacity) {
        array = (E[]) new Object[capacity+1];//数组长度比容量大1
    }

    @Override
    public boolean offer(E value) {
        if (isFull())return false;
        array[tail] = value;
        tail = (tail+1)%array.length;
        return true;
    }

    @Override
    public E poll() {
        if (isEmpty())return null;
        E value = array[head];
        head = (head+1)%array.length;
        return value;
    }

    @Override
    public E peek() {
        if (isEmpty())return null;
        return array[head];
    }

    @Override
    public boolean isEmpty() {
        return head==tail;
    }

    @Override
    public boolean isFull() {
        return (tail+1)% array.length==head;
    }

    @Override
    public Iterator iterator() {
        return new Iterator() {
            int p = head;
            @Override
            public boolean hasNext() {
                return p!=tail;
            }

            @Override
            public Object next() {
                E value = array[p];
                p=(p+1)% array.length;
                return value;
            }
        };
    }
}
