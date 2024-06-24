package leet.solutions;

import org.junit.Test;

import static org.junit.Assert.*;

public class CorporateFlightBookingsTest {

    @Test
    public void testCase1() {
        assertArrayEquals(new int[]{10, 55, 45, 25, 25},
                new CorporateFlightBookings().solve(new int[][]{new int[]{1, 2, 10},
                        new int[]{2, 3, 20}, new int[]{2, 5, 25}}, 5));

        assertArrayEquals(new int[]{10, 25},
                new CorporateFlightBookings().solve(new int[][]{new int[]{1,2,10},
                        new int[]{2,2,15}}, 2));

        assertArrayEquals(new int[]{10, 25},
                new CorporateFlightBookings().solve(new int[][]{new int[]{1,2,10},
                        new int[]{2,5,15}}, 2));
    }

}