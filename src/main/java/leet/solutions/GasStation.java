package leet.solutions;

/*
https://leetcode.com/problems/gas-station/
Leetcode#134
 */

public class GasStation {

    public int solve(int[] gas, int[] cost)
    {
        Solution solution = new Solution();
        return solution.canCompleteCircuit(gas, cost);
    }

    class Solution {
        public int canCompleteCircuit(int[] gas, int[] cost) {

            int startIndex = -1;
            int fuelInTank = 0;
            int fuelDeficit = 0;

            for (int i=0;i<gas.length;i++)
            {
                fuelInTank = fuelInTank + gas[i];

                if (fuelInTank >= cost[i])
                {
                    fuelInTank -= cost[i];
                    if (startIndex == -1)
                    {
                        startIndex = i;
                    }
                }else
                {
                    fuelDeficit += (cost[i] - fuelInTank);
                    fuelInTank = 0;
                    startIndex = -1;
                }
            }
            if (fuelInTank >= fuelDeficit)
            {
                return startIndex;
            }
            return -1;
        }
    }
}
