package s0200;

import java.util.Stack;

/**
 * @author traceless
 */
public class N0232ImplementQueueUsingStacks {

    private Stack<Integer> input;
    private Stack<Integer> output;

    public N0232ImplementQueueUsingStacks() {
        input = new Stack<>();
        output = new Stack<>();
    }

    public void push(int x) {
        input.push(x);
    }

    public int pop() {
        ensureOutPutStackNotEmpty();
        return output.pop();
    }

    public int peek() {
        ensureOutPutStackNotEmpty();
        return output.peek();
    }

    private void ensureOutPutStackNotEmpty() {
        if (output.empty()) {
            while (!input.empty()) {
                output.push(input.pop());
            }
        }
    }

    public boolean empty() {
        return input.empty() && output.empty();
    }
}
