package newcode;

import java.util.Stack;

public class Main20 {
    private Stack<Integer> dataStack = new Stack<>();
    private Stack<Integer> minStack = new Stack<>();
    public void push(int node) {
        dataStack.push(node);
        if (minStack.isEmpty()||minStack.peek()>dataStack.peek()){
            minStack.push(dataStack.peek());
        }else {
            minStack.push(minStack.peek());
        }
    }

    public void pop() {
        if (!dataStack.isEmpty()) dataStack.pop();
        if (!minStack.isEmpty()) minStack.pop();
    }

    public int top() {
        return dataStack.peek();

    }

    public int min() {
        return minStack.peek();
    }
}
