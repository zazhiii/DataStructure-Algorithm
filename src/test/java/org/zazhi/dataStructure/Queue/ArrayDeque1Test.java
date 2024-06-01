package org.zazhi.dataStructure.Queue;

import org.junit.Test;
import org.zazhi.dataStructure.Queue.deque.ArrayDeque1;

import java.util.List;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;

/**
 * @Description
 * @Date 2024/5/20
 * @Created by zazhi
 */
public class ArrayDeque1Test {
    @Test
    public void offer() {
        ArrayDeque1<Integer> deque = new ArrayDeque1<>(3);
        // 2 1 3
        deque.offerFirst(1);
        deque.offerFirst(2);
        deque.offerLast(3);
        assertFalse(deque.offerLast(4));
        assertIterableEquals(List.of(2, 1, 3), deque);
    }

    @Test
    public void poll() {
        ArrayDeque1<Integer> deque = new ArrayDeque1<>(7);
        assertTrue(deque.isEmpty());

        deque.offerLast(1);
        deque.offerLast(2);
        deque.offerLast(3);
        deque.offerFirst(4);
        deque.offerFirst(5);
        deque.offerFirst(6);
        deque.offerFirst(7);
        assertIterableEquals(List.of(7, 6, 5, 4, 1, 2, 3), deque);
        assertTrue(deque.isFull());

        assertEquals(7, deque.pollFirst().longValue());
        assertEquals(6, deque.pollFirst().longValue());
        assertEquals(3, deque.pollLast().longValue());
        assertEquals(2, deque.pollLast().longValue());
        assertEquals(1, deque.pollLast().longValue());
        assertEquals(4, deque.pollLast().longValue());
        assertEquals(5, deque.pollLast().longValue());
        assertNull(deque.pollLast());
        assertTrue(deque.isEmpty());
    }

    @Test
    public void peek(){
        ArrayDeque1<Integer> deque = new ArrayDeque1<>(7);
        // 3 1 2 4
        deque.offerFirst(1);
        deque.offerLast(2);
        deque.offerFirst(3);
        deque.offerLast(4);
        assertEquals(4, deque.peekLast().longValue());
        assertEquals(3, deque.peekFirst().longValue());
    }
}