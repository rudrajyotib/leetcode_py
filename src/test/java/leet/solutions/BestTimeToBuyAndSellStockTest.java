package leet.solutions;

import org.junit.Test;

import static org.junit.Assert.*;

public class BestTimeToBuyAndSellStockTest {

    @Test
    public void shouldFindMaxProfit()
    {
        BestTimeToBuyAndSellStock bestTimeToBuyAndSellStock = new BestTimeToBuyAndSellStock();
        assertEquals(7, bestTimeToBuyAndSellStock.solve(new int[]{7, 14, 6, 10, 12}));
        assertEquals(10, bestTimeToBuyAndSellStock.solve(new int[]{7, 14, 6, 10, 16}));
        assertEquals(0, bestTimeToBuyAndSellStock.solve(new int[]{7}));
        assertEquals(0, bestTimeToBuyAndSellStock.solve(new int[]{7, 6, 6, 5, 5}));
    }

}