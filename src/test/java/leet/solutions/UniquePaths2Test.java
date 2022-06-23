package leet.solutions;

import org.junit.Test;

import static org.junit.Assert.*;

public class UniquePaths2Test {

    @Test
    public void shouldIdentifyPathsToEndWhenPossible(){
        assertEquals(2, new UniquePaths2().solve(
                new int[][]{
                        new int[]{0,0,0},
                        new int[]{0,1,0},
                        new int[]{0,0,0}
                }
        ));
    }

    @Test
    public void shouldIdentifyNoPathsToEndWhenStartIsBlocked(){
        assertEquals(0, new UniquePaths2().solve(
                new int[][]{
                        new int[]{1,0,0},
                        new int[]{0,1,0},
                        new int[]{0,0,0}
                }
        ));
    }

    @Test
    public void shouldIdentifyNoPathsToEndWhenEndIsBlocked(){
        assertEquals(0, new UniquePaths2().solve(
                new int[][]{
                        new int[]{0,0,0},
                        new int[]{0,1,0},
                        new int[]{0,0,1}
                }
        ));
    }

    @Test
    public void shouldIdentifyNoPathsToEndWhenItIsNotPossibleToReach(){
        assertEquals(0, new UniquePaths2().solve(
                new int[][]{
                        new int[]{0,0,0},
                        new int[]{0,0,1},
                        new int[]{0,1,0}
                }
        ));
    }

    @Test
    public void shouldIdentifyNoPathsToEndForSingleRowGridWithAtLeastOneObstacle(){
        assertEquals(0, new UniquePaths2().solve(
                new int[][]{
                        new int[]{0,1,0}
                }
        ));
    }

    @Test
    public void shouldIdentifyNoPathsToEndForSingleColumnGridWithAtLeastOneObstacle(){
        assertEquals(0, new UniquePaths2().solve(
                new int[][]{
                        new int[]{0},
                        new int[]{1},
                        new int[]{0}
                }
        ));
    }

    @Test
    public void shouldIdentifyPathsToEndForSingleRowGridWithNoObstacle(){
        assertEquals(1, new UniquePaths2().solve(
                new int[][]{
                        new int[]{0,0,0}
                }
        ));
    }

    @Test
    public void shouldIdentifyPathsToEndForSingleColumnGridWithNoObstacle(){
        assertEquals(1, new UniquePaths2().solve(
                new int[][]{
                        new int[]{0},
                        new int[]{0},
                        new int[]{0}
                }
        ));
    }



}