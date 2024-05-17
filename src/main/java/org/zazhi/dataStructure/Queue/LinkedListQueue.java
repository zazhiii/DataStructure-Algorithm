package org.zazhi.dataStructure.Queue;

import java.util.Iterator;

/**
 * @Description 环形单链表实现队列
 * @Date 2024/1/30
 * @Created by zazhi
 */
public class LinkedListQueue<E> implements Queue<E>,Iterable<E> {
    //节点
    private static class Node<E>{
        E value;
        Node<E> next;

        public Node(E value, Node<E> next) {
            this.value = value;
            this.next = next;
        }
    }
    //链表属性
    Node<E> head = new Node<>(null, null);
    Node<E> tail = head;
    int size ;
    int capacity = Integer.MAX_VALUE;//容量

    public LinkedListQueue(int capacity) {
        this.capacity = capacity;
        tail.next = head;
    }

    public LinkedListQueue() {
        tail.next = head;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            Node<E> p = head.next;
            @Override
            public boolean hasNext() {
                return p!=head;
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
    public boolean offer(E value) {
        if (isFull())return false;//队列已满
        Node<E> added = new Node<>(value, head);
        tail.next = added;
        tail = added;
        size++;
        return true;
    }

    @Override
    public E poll() {
        if (isEmpty())return null;
        Node<E> first = head.next;
        head.next = first.next;
        first.next = null;
        //只有一个元素
        if (first == tail) tail = head;
        size--;
        return first.value;
    }

    @Override
    public boolean isFull() {
        return size==capacity;
    }

    @Override
    public E peek() {
        //队列为空
        if (isEmpty()) return null;
        //队列非空
        return head.next.value;
    }

    @Override
    public boolean isEmpty() {
        return head == tail;
    }
}
