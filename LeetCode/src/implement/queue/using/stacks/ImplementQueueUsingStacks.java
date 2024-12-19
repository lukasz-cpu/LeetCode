package implement.queue.using.stacks;

import java.util.Stack;

public class ImplementQueueUsingStacks {
    public static void main(String[] args) {

        int parameter = 1;
        int parameter2 = 2;
        int parameter3 = 3;
        int parameter4 = 4;
        int parameter5 = 5;

        MyQueue obj = new MyQueue();
        obj.push(parameter);
        obj.push(parameter2);
        obj.push(parameter3);
        obj.push(parameter4);
        obj.push(parameter5);
        int popResult = obj.pop();

        System.out.println(popResult);

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

//O(1)ForPush,O(N)ForPopAndPeek,O(1)ForEmpty
