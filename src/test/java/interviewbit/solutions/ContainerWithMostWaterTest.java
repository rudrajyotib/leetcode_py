package interviewbit.solutions;

import org.junit.Test;

import static org.junit.Assert.*;

public class ContainerWithMostWaterTest {

    @Test
    public void shouldFindMostContainerSet1(){
        assertEquals(12, new ContainerWithMostWater().solve(
                new int[]{3,2,3,3,3}
        ));
    }

    @Test
    public void shouldFindMostContainerSet2(){
        assertEquals(6, new ContainerWithMostWater().solve(
                new int[]{1, 5, 4, 3}
        ));
    }

    @Test
    public void shouldFindMostContainerSet3(){
        assertEquals(100, new ContainerWithMostWater().solve(
                new int[]{10, 25, 40, 100,100}
        ));
    }


}