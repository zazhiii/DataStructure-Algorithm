package org.zazhi.dataStructure.LinkedList;

import java.util.Iterator;
import java.util.function.Consumer;

/**
 * @Description 带哨兵的单向链表
 * @Date 2024/1/20
 * @Created by zazhi
 */
public class SinglyLinkedList2 implements Iterable<Integer>{


        private Node head=new Node(666,null);//头节点->哨兵节点



        private static class Node{
            int value;//节点的值
            Node next;//下一个节点

            public Node(int value, Node next) {
                this.value = value;
                this.next = next;
            }
        }

        /**
         * 插入头部元素
         * @param value 插入值
         */
        public void addFirst(int value) {
            //链表为空
//        head = new Node(value,null);
            //链表不为空
            head = new Node(value,head);
        }

        /**
         * 遍历
         * @param consumer
         */
        public void loop1(Consumer<Integer> consumer) {
            Node p=head.next;
            while(p!=null){
                consumer.accept(p.value);
                p = p.next;
            }
        }

        public void loop2(Consumer<Integer> consumer) {
            for (Node p = head.next; p!=null ; p = p.next) {
                consumer.accept(p.value);
            }
        }
        @Override
        public Iterator<Integer> iterator() {
            return new Iterator<Integer>() {
                Node p = head.next;
                @Override
                public boolean hasNext() {
                    return p != null;
                }

                @Override
                public Integer next() {
                    int v = p.value;
                    p = p.next;
                    return v;
                }
            };
        }



        /**
         * 尾部添加元素
         * @param value
         */
        public void addLast(int value) {
            Node lastNode = findLastNode();
//            if (lastNode==null){ //无需判断是否为空，若链表为空则lastNode指向哨兵节点
//                addFirst(value);
//                return;
//            }
            lastNode.next = new Node(value,null);
        }

    /**
     * 查找第一个节点
     * @return
     */
    private Node findLastNode() {
//            if (head==null)return null; 头节点不会为null了
            Node p;
            for (p = head;p.next!=null;p=p.next){}
            return p;
        }


        /**
         * 通过索引查找节点值
         * @param index
         * @return
         */
        private Node findNode(int index){
            int i =0;
            for (Node p = head; p.next!=null; p=p.next,i++) {
                if (i==index)return p;
            }
            return null;
        }
        public int get(int index){
            Node node = findNode(index);
            if (node==null){
                throw illegalIndex(index);
            }
            return node.value;
        }

        private static IllegalArgumentException illegalIndex(int index) {
            return new IllegalArgumentException("index" + index + "不合法");
        }

        /**
         * 插入节点
         * @param index
         * @param value
         */
        public void insert(int index,  int value){
            if (index==0){
                addFirst(value);
                return;
            }
            Node preNode = findNode(index - 1);//找到上一个节点
            if (preNode==null){
                throw illegalIndex(index);
            }
            preNode.next = new Node(value,preNode.next);
        }

        /**
         * 移除第一个节点
         */
        public void removeFirst(){
            if (head==null){
                throw illegalIndex(0);
            }
            Node first = head;
            head = head.next;
            first.next = null;//释放第一个元素
        }

        /**
         * 按索引删除
         * @param index
         */
        public void remove(int index){
            if (index==0){
                removeFirst();
                return;
            }
            Node preNode = findNode(index - 1);
            if (preNode==null){
                throw illegalIndex(index);
            }
            Node removeNode = preNode.next;
            if (removeNode==null){
                throw illegalIndex(index);
            }
            preNode.next = removeNode.next;
            removeNode.next = null;
        }
    }


