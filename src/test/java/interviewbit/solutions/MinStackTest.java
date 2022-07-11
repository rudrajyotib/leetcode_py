package interviewbit.solutions;

import org.junit.Test;

import static org.junit.Assert.*;

public class MinStackTest {

    @Test
    public void shouldOperateOnMinStack(){
        MinStack.Solution solution = new MinStack.Solution();
        assertEquals(-1, solution.top());
        assertEquals(-1, solution.getMin());
        solution.push(1);
        solution.push(10);
        assertEquals(1, solution.getMin());
        assertEquals(10, solution.top());
        solution.pop();
        assertEquals(1, solution.getMin());
        solution.push(20);
        solution.push(15);
        assertEquals(1, solution.getMin());
        assertEquals(15, solution.top());
        solution.pop();
        solution.pop();
        assertEquals(1, solution.top());
        solution.pop();
        assertEquals(-1, solution.getMin());
        solution.push(5);
        solution.push(10);
        solution.push(15);
        assertEquals(5, solution.getMin());
        solution.push(2);
        assertEquals(2, solution.getMin());

    }


}