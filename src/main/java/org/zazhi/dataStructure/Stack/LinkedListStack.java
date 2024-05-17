package org.zazhi.dataStructure.Stack;

import java.util.Iterator;

/**
 * @Description   单项链表实现 栈   (已测)
 * @Date 2024/2/1
 * @Created by zazhi
 */
public class LinkedListStack<E> implements Stack<E> ,Iterable<E> {
    private int capacity;
    private int size;
    private Node<E> head = new Node<E>(null,null);
    public LinkedListStack(int capacity) {
        this.capacity = capacity;
    }

    static class Node<E>{
        E value;
        Node<E> next;

        public Node(E value, Node<E> next) {
            this.value = value;
            this.next = next;
        }
    }
    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            Node<E> p = head.next;
            @Override
            public boolean hasNext() {
                return p!=null;
            }

            @Override
            public E next() {
                E value = p.value;
                p=p.next;
                return value;
            }
        };
    }

    @Override
    public boolean push(E value) {
        if (isFull())return false;
        head.next = new Node<>(value, head.next);
        size++;
        return true;
    }

    @Override
    public E pop() {
        if (isEmpty())return null;
        Node<E> first = head.next;
        head.next = first.next;
        size--;
        return first.value;
    }

    @Override
    public E peek() {
        if (isEmpty())return null;
        return head.next.value;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean isFull() {
        return size == capacity;
    }
}
