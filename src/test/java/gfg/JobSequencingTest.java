package gfg;

import org.junit.Test;

import static org.junit.Assert.*;

public class JobSequencingTest {

    @Test
    public void testCase1(){
        assertArrayEquals(new int[]{2, 60},
                new JobSequencing().JobScheduling(
                        new JobSequencing.Job[]{
                                new JobSequencing.Job(1,4,20),
                                new JobSequencing.Job(2,1,1),
                                new JobSequencing.Job(3,1,40),
                                new JobSequencing.Job(4,1,30),
                        }, 4
                ));
    }

    @Test
    public void testCase2(){
        assertArrayEquals(new int[]{3, 140},
                new JobSequencing().JobScheduling(
                        new JobSequencing.Job[]{
                                new JobSequencing.Job(1,4,20),
                                new JobSequencing.Job(2,4,30),
                                new JobSequencing.Job(3,1,50),
                                new JobSequencing.Job(4,1,60),
                                new JobSequencing.Job(4,1,90),
                        }, 5
                ));
    }

}