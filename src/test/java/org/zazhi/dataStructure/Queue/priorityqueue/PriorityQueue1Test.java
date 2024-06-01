package org.zazhi.dataStructure.Queue.priorityqueue;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * @Description
 * @Date 2024/5/31
 * @Created by zazhi
 */
public class PriorityQueue1Test {
    @Test
    public void poll() {
        PriorityQueue1<Entry> queue = new PriorityQueue1<>(5);
        queue.offer(new Entry("task1", 4));
        queue.offer(new Entry("task2", 3));
        queue.offer(new Entry("task3", 2));
        queue.offer(new Entry("task4", 5));
        queue.offer(new Entry("task5", 1));
        assertFalse(queue.offer(new Entry("task6", 7)));

//        System.out.println(Arrays.toString(queue.array));
        assertEquals(5, queue.poll().priority());
//        System.out.println(Arrays.toString(queue.array));
        assertEquals(4, queue.poll().priority());
        assertEquals(3, queue.poll().priority());
        assertEquals(2, queue.poll().priority());
        assertEquals(1, queue.poll().priority());
    }
}