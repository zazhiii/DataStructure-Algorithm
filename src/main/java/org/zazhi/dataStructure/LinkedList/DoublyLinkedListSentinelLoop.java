package org.zazhi.dataStructure.LinkedList;

import java.util.Iterator;

/**
 * @Description
 * @Date 2024/1/21
 * @Created by zazhi
 */
public class DoublyLinkedListSentinelLoop implements Iterable<Integer> {
    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            Node p = sentinel.next;
            @Override
            public boolean hasNext() {
                return p!=sentinel;
            }

            @Override
            public Integer next() {
                int value = p.value;
                p=p.next;
                return value;
            }
        };
    }

    private static class Node{
        Node prev;
        int value;
        Node next;
        public Node(Node prev, int value, Node next) {
            this.prev = prev;
            this.value = value;
            this.next = next;
        }
    }
    Node sentinel = new Node(null,666,null);
    //constructor
    public DoublyLinkedListSentinelLoop() {
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
    }
    //头部添加元素
    public void addFirst(int value) {
        Node prevNode = sentinel;
        Node nextNode = sentinel.next;
        Node added = new Node(prevNode, value, nextNode);
        prevNode.next=added;
        nextNode.prev = added;
    }
    //尾部添加元素
    public void addLast(int value){
        Node prevNode = sentinel.prev;
        Node nextNode = sentinel;
        Node added = new Node(prevNode, value, nextNode);
        prevNode.next=added;
        nextNode.prev = added;
    }

    //删除第一个节点
    public void removeFirst(){
        Node prevNode = sentinel;
        Node removed = sentinel.next;
        if (removed == sentinel)
            throw new IllegalStateException("操作非法");
        Node nextNode = removed.next;
        prevNode.next=nextNode;
        nextNode.prev = prevNode;
        removed.prev = null;
        removed.next = null;
    }
    //删除尾节点
    public void removeLast(){
        Node nextNode = sentinel;
        Node removed = sentinel.prev;
        if (removed == sentinel)
            throw new IllegalStateException("操作非法");
        Node prevNode = removed. prev;
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
        removed.prev = null;
        removed.next = null;
    }
    //根据值删除
    public void removeByValue(int value){
        Node removed = findByValue(value);
        if (removed == null)return;
        Node prevNode = removed.prev;
        Node nextNode = removed.next;
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
        removed.next = null;
        removed.prev = null;
    }
    private Node findByValue(int value){
        Node p = sentinel.next;
        while(p!=sentinel){
            if (p.value==value)return p;
            p=p.next;
        }
        return null;
    }
}
