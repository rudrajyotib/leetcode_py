package interviewbit.solutions;

/*
ˇhttps://www.interviewbit.com/problems/min-stack/
 */

import java.util.Stack;

public class MinStack {

    static class Solution {

        Stack<Node> stack = new Stack<>();

        public void push(int x) {
            if (stack.isEmpty()){
                stack.push(new Node(x, x));
            }else{
                stack.push(new Node(
                        x, Math.min(stack.peek().min, x)
                ));
            }
        }

        public void pop() {
            if (!stack.isEmpty()){
                stack.pop();
            }
        }

        public int top() {
            if (stack.isEmpty()){
                return -1;
            }
            return stack.peek().element;
        }

        public int getMin() {
            if (stack.isEmpty()){
                return -1;
            }
            return stack.peek().min;
        }

        static class Node {
            final int element;
            final int min;

            Node(int element, int min) {
                this.element = element;
                this.min = min;
            }
        }
    }


}
