package org.zazhi.dataStructure.Queue;

import java.util.Iterator;

/**
 * @Description 环形数组实现队列, 通过size实现判断队列空满
 * @Date 2024/1/31
 * @Created by zazhi
 */
public class ArrayQueue2<E> implements Queue<E>,Iterable<E> {
    E[] array;
    int head = 0;
    int tail = 0;
    int size = 0;

    public ArrayQueue2(int capacity) {
        array = (E[]) new Object[capacity+1];//数组长度比容量大1
    }

    @Override
    public boolean offer(E value) {
        if (isFull())return false;
        array[tail] = value;
        tail = (tail+1)%array.length;
        size++;
        return true;
    }

    @Override
    public E poll() {
        if (isEmpty())return null;
        E value = array[head];
        head = (head+1)%array.length;
        size--;
        return value;
    }

    @Override
    public E peek() {
        if (isEmpty())return null;
        return array[head];
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    @Override
    public boolean isFull() {
        return size==array.length;
    }

    @Override
    public Iterator iterator() {
        return new Iterator() {
            int p = head;
            int count = 1;//计数迭代到第几个元素
            @Override
            public boolean hasNext() {
                return count<=size;
            }

            @Override
            public Object next() {
                E value = array[p];
                p=(p+1)% array.length;
                count++;
                return value;
            }
        };
    }
}
