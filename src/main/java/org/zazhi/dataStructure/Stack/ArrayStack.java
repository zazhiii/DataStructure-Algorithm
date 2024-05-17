package org.zazhi.dataStructure.Stack;

import java.util.Iterator;

/**
 * @Description    栈 数组实现 (已测)
 * @Date 2024/2/1
 * @Created by zazhi
 */
public class ArrayStack<E> implements Stack<E>,Iterable<E>{
    private E[] array;
    private int size = 0;
    private int capacity;

    public ArrayStack(int capacity) {
        this.array = (E[]) new Object[capacity+1];
        this.size = size;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public boolean push(E value) {
        if (isFull()) return false;
        array[size++] = value;
        return true;
    }

    @Override
    public E pop() {
        if (isFull()) return null;
        E value = array[size-1];
        size--;
        return value;
    }

    @Override
    public E peek() {
        if (isEmpty())return null;
        return array[size-1];
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    @Override
    public boolean isFull() {
        return size == capacity;
    }
}
