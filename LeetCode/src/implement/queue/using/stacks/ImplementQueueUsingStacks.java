package implement.queue.using.stacks;

import java.util.Stack;

public class ImplementQueueUsingStacks {
    public static void main(String[] args) {

        int parameter = 1;

        MyQueue obj = new MyQueue();
        obj.push(parameter);
        int param_2 = obj.pop();
        int param_3 = obj.peek();
        boolean param_4 = obj.empty();

    }


    static class MyQueue {

        Stack<Integer> stack;

        public MyQueue() {
            stack = new Stack<>();
        }

        public void push(int x) {
            stack.push(x);
        }

        public int pop() {
            if (stack.isEmpty()) {
                throw new IllegalStateException("Queue is empty");
            }
            int top = stack.pop();
            if (stack.isEmpty()) {
                return top;
            }
            else {
                int item = pop();
                stack.push(item);
                return item;
            }
        }

        public int peek() {
            if (stack.isEmpty()) {
                throw new IllegalStateException("Queue is empty");
            }
            int top = stack.pop();
            if (stack.isEmpty()) {
                stack.push(top);
                return top;
            }
            else {
                int item = peek();
                stack.push(item);
                return item;
            }
        }

        public boolean empty() {
            return stack.isEmpty();
        }
    }
}
