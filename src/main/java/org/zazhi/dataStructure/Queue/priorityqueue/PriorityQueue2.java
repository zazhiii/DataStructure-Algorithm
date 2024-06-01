package org.zazhi.dataStructure.Queue.priorityqueue;

import org.zazhi.dataStructure.Queue.queue.Queue;

/**
 * @Description     基于有序数组实现优先队列(Tested)
 * @Date 2024/5/31
 * @Created by zazhi
 */
public class PriorityQueue2<E extends Priority> implements Queue<E> {
    Priority[] arr;
    int size;
    public PriorityQueue2(int capacity) {
        arr = new Priority[capacity];
    }

    //插入元素
    private void insert(E e){
        int i = size - 1;
        while(i >= 0 && arr[i].priority() > e.priority()){
            arr[i + 1] = arr[i];
            i --;
        }
        arr[i + 1] = e;
    }
    @Override // O(n)
    public boolean offer(E value) {
        if(isFull()) return false;
        insert(value);
        size ++;
        return true;
    }

    @Override // O(1)
    public E poll() {
        if(isEmpty()) return null;
        E e = (E) arr[size - 1];
        arr[-- size] = null; //help GC
        return e;
    }

    @Override // O(1)
    public E peek() {
        if(isEmpty()) return null;
        return (E) arr[size - 1];
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean isFull() {
        return size == arr.length;
    }
}
