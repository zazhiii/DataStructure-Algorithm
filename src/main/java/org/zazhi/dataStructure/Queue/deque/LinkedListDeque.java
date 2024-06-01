package org.zazhi.dataStructure.Queue.deque;

import java.util.Iterator;

/**
 * @Description 环形双向链表 --> 双端队列
 * @Date 2024/5/17
 * @Created by zazhi
 */
public class LinkedListDeque<E> implements Deque<E>, Iterable<E> {


    static class Node<E>{
        Node<E> prev;
        Node<E> next;
        E value;
        public Node (Node<E> pre, Node<E> next, E value) {
            this.prev = pre;
            this.next = next;
            this.value = value;
        }
    }
    int size; // number of elements
    int capacity;//
    Node<E> sentinel = new Node<>(null, null, null);// 哨兵
    public LinkedListDeque(int capacity) {
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        this.capacity = capacity;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            Node<E> p = sentinel.next;
            @Override
            public boolean hasNext() {
                return p != sentinel;
            }

            @Override
            public E next() {
                E value = p.value;
                p = p.next;
                return value;
            }
        };
    }

    @Override
    public boolean offerFirst(E e) {
        if(isFull()) return false;
        Node<E> a = sentinel;
        Node<E> b = sentinel.next;
        Node<E> add = new Node<>(a, b, e);
        a.next = add;
        b.prev = add;
        size ++;
        return true;
    }

    @Override
    public boolean offerLast(E e) {
        if(isFull()) return false;
        Node<E> a = sentinel.prev;
        Node<E> b = sentinel;
        Node<E> add = new Node<>(a, b, e);
        a.next = add;
        b.prev = add;
        size ++;
        return true;
    }

    @Override
    public E pollFirst() {
        if(isEmpty()) return null;
        Node<E> a = sentinel;
        Node<E> removed = sentinel.next;
        Node<E> b = sentinel.next.next;
        a.next = b;
        b.prev = a;
        removed.next = null;
        removed.prev = null;
        size --;
        return removed.value;
    }

    @Override
    public E pollLast() {
        if(isEmpty()) return null;
        Node<E> a = sentinel.prev.prev;
        Node<E> removed = sentinel.prev;
        Node<E> b = sentinel;
        a.next = b;
        b.prev = a;
        removed.prev = null;
        removed.next = null;
        return removed.value;
    }

    @Override
    public E peekFirst() {
        if(isEmpty()) return null;
        return sentinel.next.value;
    }

    @Override
    public E peekLast() {
        if(isEmpty()) return null;
        return sentinel.prev.value;
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
