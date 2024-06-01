package org.zazhi.dataStructure.Queue;

import org.junit.Test;
import org.zazhi.dataStructure.Queue.deque.LinkedListDeque;

import static org.junit.Assert.*;

/**
 * @Description
 * @Date 2024/5/17
 * @Created by zazhi
 */
public class LinkedListDequeTest {
    // 3 2 1 4 5
    @Test
    public void offer() {
        LinkedListDeque<Integer> deque = new LinkedListDeque<>(5);
        deque.offerFirst(1);
        deque.offerFirst(2);
        deque.offerFirst(3);
        deque.offerLast(4);
        deque.offerLast(5);
        assertFalse(deque.offerLast(6));
    }

    @Test
    public void poll() {
        LinkedListDeque<Integer> deque = new LinkedListDeque<>(5);
        deque.offerLast(1);
        deque.offerLast(2);
        deque.offerLast(3);
        deque.offerLast(4);
        deque.offerLast(5);
    }
}