package org.zazhi.dataStructure.Queue.queue;

import java.util.Iterator;

/**
 * @Description 环形数组实现队列, head tail不是直接的索引而是不断自增的整数, 需要索引再用head tail计算出索引
 *               (有bug, head tail可能会超过int范围)
 * @Date 2024/1/31
 * @Created by zazhi
 */
public class ArrayQueue3<E> implements Queue<E>,Iterable<E> {
    E[] array;
    int head = 0;
    int tail = 0;


    public ArrayQueue3(int capacity) {
        array = (E[]) new Object[capacity+1];//数组长度比容量大1
    }

    @Override
    public boolean offer(E value) {
        if (isFull())return false;
        array[tail% array.length] = value;
        tail++;

        return true;
    }

    @Override
    public E poll() {
        if (isEmpty())return null;
        E value = array[head % array.length];
        head++;
        return value;
    }

    @Override
    public E peek() {
        if (isEmpty())return null;
        return array[head % array.length];
    }

    @Override
    public boolean isEmpty() {
        return head==tail;
    }

    @Override
    public boolean isFull() {
        return tail-head==array.length; //tail处没有存元素，故tail-head == 元素个数
    }

    @Override
    public Iterator iterator() {
        return new Iterator() {
            int p = head;
            @Override
            public boolean hasNext() {
                return p != tail;
            }

            @Override
            public Object next() {
                E value = array[p%array.length];
                p++;
                return value;
            }
        };
    }
}
