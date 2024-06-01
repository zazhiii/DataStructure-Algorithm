package org.zazhi.dataStructure.Queue;

import org.junit.Test;
import org.zazhi.dataStructure.Queue.queue.LinkedListQueue;

import static org.junit.Assert.*;

/**
 * @Description
 * @Date 2024/1/30
 * @Created by zazhi
 */
public class LinkedListQueueTest {

    @Test
    public void offer() {
        LinkedListQueue<Integer> queue = new LinkedListQueue<>();
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        queue.offer(4);
        queue.offer(5);
        for (Integer i : queue) {
            System.out.print(i);
        }
    }
    @Test
    public void peek() {
        LinkedListQueue<Integer> queue = new LinkedListQueue<>();
        assertEquals(null, queue.peek());
        queue.offer(1);
        System.out.println(queue.peek());
        queue.offer(2);
        System.out.println(queue.peek());
    }
}