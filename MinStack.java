import java.util.Stack;

public class MinStack<Type extends Comparable<Type>>
{
    private Stack<Type> stack = new Stack<>();
    private Stack<Type> minStack = new Stack<>();

    public void push(Type x)
    {
        stack.push(x);
        if (minStack.isEmpty())
        {
            minStack.push(x);
        }
        else
        {
            Type min = minStack.peek();
            if (min.compareTo(x) > 0)
            {
                minStack.push(x);
            }
            else
            {
                minStack.push(min);
            }
        }
    }

    public void pop()
    {
        if (stack.isEmpty())
        {
            return;
        }

        stack.pop();
        minStack.pop();
    }

    public Type top()
    {
        return stack.peek();
    }

    public Type getMin()
    {
        return minStack.peek();
    }

    public static void main(String[] args) {
        // some simple unit test
        MinStack<Integer> s = new MinStack<>();
        s.push(2);
        s.push(-3);
        s.push(0);
        System.out.println("min = " + s.getMin());
        System.out.println("top = " + s.top());
        s.pop();
        System.out.println("min = " + s.getMin());
        System.out.println("top = " + s.top());
        s.pop();
        System.out.println("min = " + s.getMin());
        System.out.println("top = " + s.top());
    }
}
