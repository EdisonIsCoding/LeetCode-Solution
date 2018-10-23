import java.util.Stack;

class QueueByTwoStacks {

    private final Stack<Integer> stack1 = new Stack<>();
    private final Stack<Integer> stack2 = new Stack<>();

    /** Initialize your data structure here. */
    public QueueByTwoStacks() {

    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        stack1.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if (!stack2.isEmpty())
        {
            return stack2.pop();
        }
        else
        {
            if (stack1.isEmpty())
            {
                // No element in the queue, return error
                return Integer.MIN_VALUE;
            }
            while (!stack1.isEmpty())
            {
                stack2.push(stack1.pop());
            }
            return stack2.pop();
        }
    }

    /** Get the front element. */
    public int peek() {
        if (!stack2.isEmpty())
        {
            return stack2.peek();
        }
        else
        {
            if (stack1.isEmpty())
            {
                // No element in the queue, return error
                return Integer.MIN_VALUE;
            }
            while (!stack1.isEmpty())
            {
                stack2.push(stack1.pop());
            }
            return stack2.peek();

        }
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }
}
