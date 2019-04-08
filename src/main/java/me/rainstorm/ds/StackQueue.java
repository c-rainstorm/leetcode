package me.rainstorm.ds;

import org.junit.Test;

import java.util.Stack;

/**
 * [232] 用栈实现队列
 * <p>
 * https://leetcode-cn.com/problems/implement-queue-using-stacks/description/
 * <p>
 * algorithms
 * Easy (58.51%)
 * Total Accepted:    9.1K
 * Total Submissions: 15.5K
 * Testcase Example:  '["MyQueue","push","push","peek","pop","empty"]\n[[],[1],[2],[],[],[]]'
 * <p>
 * 使用栈实现队列的下列操作：
 * <p>
 * <p>
 * push(x) -- 将一个元素放入队列的尾部。
 * pop() -- 从队列首部移除元素。
 * peek() -- 返回队列首部的元素。
 * empty() -- 返回队列是否为空。
 * <p>
 * <p>
 * 示例:
 * <p>
 * MyQueue queue = new MyQueue();
 * <p>
 * queue.push(1);
 * queue.push(2);
 * queue.peek();  // 返回 1
 * queue.pop();   // 返回 1
 * queue.empty(); // 返回 false
 * <p>
 * 说明:
 * <p>
 * <p>
 * 你只能使用标准的栈操作 -- 也就是只有 push to top, peek/pop from top, size, 和 is empty
 * 操作是合法的。
 * 你所使用的语言也许不支持栈。你可以使用 list 或者 deque（双端队列）来模拟一个栈，只要是标准的栈操作即可。
 * 假设所有操作都是有效的 （例如，一个空的队列不会调用 pop 或者 peek 操作）。
 *
 * @author baochen1.zhang
 * @date 2019.04.08
 */
public class StackQueue {
    private Stack<Integer> stack;
    private Stack<Integer> stack1;

    public StackQueue() {
        stack = new Stack<>();
        stack1 = new Stack<>();
    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        stack.push(x);
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        while (!stack.empty()) {
            stack1.push(stack.pop());
        }
        int result = stack1.pop();
        while (!stack1.empty()) {
            stack.push(stack1.pop());
        }
        return result;
    }

    /**
     * Get the front element.
     */
    public int peek() {
        while (!stack.empty()) {
            stack1.push(stack.pop());
        }
        int result = stack1.peek();
        while (!stack1.empty()) {
            stack.push(stack1.pop());
        }
        return result;
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return stack.empty();
    }

    @Test
    public void case1() {
        StackQueue queue = new StackQueue();
        queue.push(1);
        queue.push(2);
        assert 1 == queue.peek();
        assert 1 == queue.pop();
        assert !queue.empty();
    }
}
