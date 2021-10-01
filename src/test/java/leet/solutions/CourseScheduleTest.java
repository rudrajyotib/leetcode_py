package leet.solutions;

import org.junit.Test;

import static org.junit.Assert.*;

public class CourseScheduleTest {

    @Test
    public void shouldValidateSet1()
    {
        CourseSchedule courseSchedule = new CourseSchedule();
        assertTrue(courseSchedule.solve(10, new
                int[][]{{0, 1}, {1, 2}, {2, 3}, {3, 4}}));
    }

    @Test
    public void shouldValidateSet2()
    {
        CourseSchedule courseSchedule = new CourseSchedule();
        assertTrue(courseSchedule.solve(10, new
                int[][]{{0, 1}, {1, 2}, {2, 3}, {2, 4}, {2, 6}}));
    }

    @Test
    public void shouldNotValidateSet3()
    {
        CourseSchedule courseSchedule = new CourseSchedule();
        assertFalse(courseSchedule.solve(2, new
                int[][]{{0, 1}, {1, 0}}));
    }

    @Test
    public void shouldValidateSet4()
    {
        CourseSchedule courseSchedule = new CourseSchedule();
        assertTrue(courseSchedule.solve(6, new
                int[][]{{0, 1},
                {1, 4},
                {1, 5},
                {0, 2},
                {2, 3},
                {3, 5}}));
    }





}