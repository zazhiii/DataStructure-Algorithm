package org.zazhi.dataStructure.LinkedList;

import java.util.Iterator;

/**
 * @Description
 * @Date 2024/1/21
 * @Created by zazhi
 */
public class DoublyLinkedListSentinel implements Iterable<Integer>{
    Node head;
    Node tail;
    //节点类
    static class Node{
        Node prev;
        int value;
        Node next;
        public Node(Node prev, int value, Node next) {
            this.prev = prev;
            this.value = value;
            this.next = next;
        }
    }
    //constructor
    public DoublyLinkedListSentinel() {
        this.head = new Node(null,666,null);
        this.tail = new Node(head,666,null);
        head.next=tail;
    }
    //根据索引查找节点
    private Node findNode(int index){
        int i = -1;
        for (Node p = head; p!=tail; p=p.next,i++) {
            if (i==index)return p;
        }
        return null;
    }

    /**
     * 头部添加元素
     * @param value
     */
    public void addFirst(int value){
        insert(0,value);
    }

    /**
     * 移除第一个元素
     */
    public void removeFirst(){
        Node first = head.next;
        if (first == tail)illegalIndex(0);
        Node nextNode = first.next;
        head.next = nextNode;
        nextNode.prev = head;
        first.prev = null;
        first.next = null;
    }

    /**
     * 尾部添加元素
     * @param value
     */
    public void addLast(int value){
        Node last = tail.prev;
        Node added = new Node(last, value, tail);
        last.next=added;
        tail.prev = added;
    }

    /**
     * 移除最后一个元素
     */
    public void removeLast(){
        Node last = tail.prev;
        if (last == head)illegalIndex(0);
        Node prevNode = last.prev;
        prevNode.next = tail;
        tail.prev = prevNode;
        last.next = null;
        last.prev = null;
    }

    /**
     * 根据索引插入节点
     * @param index
     * @param value
     */
    public void insert(int index,int value){
        Node prev = findNode(index-1);
        if (prev==null)illegalIndex(index);//指针异常
        Node next = prev.next;
        Node inserted = new Node(prev,value,next);
        prev.next = inserted;
        next.prev = inserted;
    }

    /**
     * 根据索引移除节点
     * @param index
     */
    public void remove(int index){
        Node prevNode = findNode(index-1);
        if (prevNode==null)illegalIndex(index);
        Node removedNode = prevNode.next;
        if (removedNode==tail)illegalIndex(index);
        Node nextNode = removedNode.next;
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
        removedNode.prev=null;
        removedNode.next=null;
    }



    private static IllegalArgumentException illegalIndex(int index) {
        return new IllegalArgumentException("index" + index + "不合法");
    }





    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            Node p = head.next;
            @Override
            public boolean hasNext() {
                return p!=tail;
            }

            @Override
            public Integer next() {
                int value = p.value;
                p=p.next;
                return value;
            }
        };
    }
}
