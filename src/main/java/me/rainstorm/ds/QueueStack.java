package me.rainstorm.ds;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * [225] 用队列实现栈
 * <p>
 * https://leetcode-cn.com/problems/implement-stack-using-queues/description/
 * <p>
 * algorithms
 * Easy (57.02%)
 * Total Accepted:    8.3K
 * Total Submissions: 14.5K
 * Testcase Example:  '["MyStack","push","push","top","pop","empty"]\n[[],[1],[2],[],[],[]]'
 * <p>
 * 使用队列实现栈的下列操作：
 * <p>
 * <p>
 * push(x) -- 元素 x 入栈
 * pop() -- 移除栈顶元素
 * top() -- 获取栈顶元素
 * empty() -- 返回栈是否为空
 * <p>
 * <p>
 * 注意:
 * <p>
 * <p>
 * 你只能使用队列的基本操作-- 也就是 push to back, peek/pop from front, size, 和 is empty
 * 这些操作是合法的。
 * 你所使用的语言也许不支持队列。 你可以使用 list 或者 deque（双端队列）来模拟一个队列 , 只要是标准的队列操作即可。
 * 你可以假设所有操作都是有效的（例如, 对一个空的栈不会调用 pop 或者 top 操作）。
 *
 * @author baochen1.zhang
 * @date 2019.04.08
 */
public class QueueStack {
    private Queue<Integer> queue;
    private Queue<Integer> queue1;
    private int size;

    public QueueStack() {
        queue = new LinkedList<>();
        queue1 = new LinkedList<>();
        size = 0;
    }

    /**
     * Push element x onto stack.
     */
    public void push(int x) {
        if ((queue.size() == 0) && (queue1.size() == 0)) {
            queue.offer(x);
        } else if (queue.size() > 0) {
            queue.offer(x);
        } else {
            queue1.offer(x);
        }
        size++;
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
        Queue<Integer> emptyQueue = queue.size() == 0 ? queue : queue1;
        Queue<Integer> notEmptyQueue = queue.size() == 0 ? queue1 : queue;
        while (notEmptyQueue.size() > 1) {
            emptyQueue.offer(notEmptyQueue.poll());
        }
        size--;
        return notEmptyQueue.poll();
    }

    /**
     * Get the top element.
     */
    public int top() {
        Queue<Integer> emptyQueue = queue.size() == 0 ? queue : queue1;
        Queue<Integer> notEmptyQueue = queue.size() == 0 ? queue1 : queue;
        Integer result = null;
        while (!notEmptyQueue.isEmpty()) {
            result = notEmptyQueue.poll();
            emptyQueue.offer(result);
        }
        return result;
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return size == 0;
    }

    @Test
    public void case1() {
        QueueStack stack = new QueueStack();
        stack.push(1);
        stack.push(2);
        assert 2 == stack.top();
        assert 2 == stack.pop();
        assert !stack.empty();
    }
}
