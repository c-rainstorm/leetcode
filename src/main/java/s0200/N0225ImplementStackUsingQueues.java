package s0200;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/implement-stack-using-queues/
 *
 * @author traceless
 */
public class N0225ImplementStackUsingQueues {
    private Queue<Integer> input;
    private Queue<Integer> output;

    public N0225ImplementStackUsingQueues() {
        input = new LinkedList<>();
        output = new LinkedList<>();
    }

    /**
     * input 在 offer 时为空
     */
    public void push(int x) {
        input.offer(x);
        while (!output.isEmpty()) {
            input.offer(output.poll());
        }
        Queue<Integer> tmp = input;
        input = output;
        output = tmp;
    }

    public int pop() {
        return output.poll();
    }

    public int top() {
        return output.peek();
    }

    public boolean empty() {
        return output.isEmpty();
    }
}
