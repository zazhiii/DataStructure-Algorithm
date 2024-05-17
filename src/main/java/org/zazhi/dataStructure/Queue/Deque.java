package org.zazhi.dataStructure.Queue;

/**
 * @Description 双端队列 ：头部和尾部都可以添加删除元素
 * @Date 2024/5/17
 * @Created by zazhi
 */
public interface Deque<E> {
    boolean offerFirst(E e);
    boolean offerLast(E e);
    E pollFirst();
    E pollLast();
    E peekFirst();
    E peekLast();
    boolean isEmpty();
    boolean isFull();
}
