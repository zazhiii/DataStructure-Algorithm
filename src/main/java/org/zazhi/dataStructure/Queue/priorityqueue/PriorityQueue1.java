package org.zazhi.dataStructure.Queue.priorityqueue;

import org.zazhi.dataStructure.Queue.queue.Queue;

/**
 * @Description 基于无序数组实现优先队列(Tested)
 * @Date 2024/5/31
 * @Created by zazhi
 */
public class PriorityQueue1<E extends Priority> implements Queue<E> {
    Priority[] arr;
    int size;
    public PriorityQueue1(int capacity) {
        arr = new Priority[capacity];
    }

    @Override // O(1)
    public boolean offer(E value) {
        if(isFull()) return false;
        arr[size++] = value;
        return true;
    }
    //返回优先级最高的索引
    private int selectMax(){
        int max = 0;
        for (int i = 1; i < arr.length; i++) {
            if(arr[i].priority() > arr[max].priority()){
                max = i;
            }
        }
        return max;
    }
    //删除元素
    private void remove(int index){
        for(int i = index; i < size - 1; i ++){
            arr[i] = arr[i + 1];
        }
        size --;
        arr[size] = null; //help GC
    }
    @Override // O(n)
    public E poll() {
        if(isEmpty()) return null;
        int max = selectMax();
        E e = (E) arr[max];
        remove(max);
        return e;
    }

    @Override
    public E peek() {
        if(isEmpty()) return null;
        int max = selectMax();
        return (E) arr[max];
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
