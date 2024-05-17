package org.zazhi.dataStructure.Stack;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Description
 * @Date 2024/2/1
 * @Created by zazhi
 */
public class ArrayStackTest {

    @Test
    public void iterator() {
        LinkedListStack<Integer> stack = new LinkedListStack<>(3);
        stack.push(1);
        stack.push(1);
        stack.push(1);
        for (Integer i : stack) {
            assertEquals((long)1,(long)i);
        }
    }

    @Test
    public void push() {
        LinkedListStack<Integer> stack = new LinkedListStack<>(3);
        assertTrue(stack.push(1));
        assertTrue(stack.push(2));
        assertTrue(stack.push(3));
        assertFalse(stack.push(4));
    }

    @Test
    public void pop() {
        LinkedListStack<Integer> stack = new LinkedListStack<>(3);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.pop()+"->3");
        System.out.println(stack.pop()+"->2");
        System.out.println(stack.pop()+"->1");

    }

    @Test
    public void peek() {LinkedListStack<Integer> stack = new LinkedListStack<>(3);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.peek()+"->3");
    }

    @Test
    public void isEmpty() {
        LinkedListStack<Integer> stack = new LinkedListStack<>(3);
        assertTrue(stack.isEmpty());
        stack.push(1);
        assertFalse(stack.isEmpty());
    }

    @Test
    public void isFull() {
        LinkedListStack<Integer> stack = new LinkedListStack<>(3);
        assertFalse(stack.isFull());
        stack.push(1);
        stack.push(2);
        stack.push(3);
        assertTrue(stack.isFull());
    }
}