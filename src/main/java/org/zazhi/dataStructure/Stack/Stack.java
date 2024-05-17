package org.zazhi.dataStructure.Stack;

/**
 * @Description 栈
 * @Date 2024/2/1
 * @Created by zazhi
 */
public interface Stack<E> {
    /**
     * 从栈顶压入元素
     * @param value 压入元素
     * @return 入栈成功返回true, 失败返回false
     */
    boolean push(E value);

    /**
     * 从栈顶弹出元素
     * @return 栈非空返回栈顶元素，栈为空则返回null
     */
    E pop();

    /**
     * 返回栈顶元素不弹出
     * @return 栈非空返回栈顶元素，栈为空返回null
     */
    E peek();

    /**
     * 检查栈是否为空
     * @return 满返回true，反之返回false
     */
    boolean isEmpty();

    /**
     * 判断栈是否已满
     * @return
     */
    boolean isFull();
}
