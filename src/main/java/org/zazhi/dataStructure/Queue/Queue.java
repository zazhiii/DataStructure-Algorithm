package org.zazhi.dataStructure.Queue;

/**
 * @Description 队列接口
 * @Date 2024/1/30
 * @Created by zazhi
 */
public interface Queue<E> {
    /**
     * 列尾插入元素
     * @param value 插入值
     * @return 是否插入成功
     */
    boolean offer(E value);

    /**
     * 删除列头元素
     * @return
     */
    E poll();
    /**
     * 获取列头元素
     */
    E peek();

    /**
     * 检查队列是否为空
     * @return
     */
    boolean isEmpty();

    /**
     * 判断队列是否已满
     * @return
     */
    boolean isFull();
}
