import math
from typing import List, Dict


class Solution:
    memory: Dict[int, int] = {}

    def coinChange(self, coins: List[int], amount: int) -> int:

        coins_sorted = sorted(coins, reverse=True)
        result = [math.inf for _ in range(amount+2)]
        result[0] = 0
        for amt in range(1, amount+1, 1):
            for coin in coins_sorted:
                if amt >= coin:
                    result[amt] = min(result[amt], 1 + result[amt-coin])

        return -1 if result[amount] is math.inf else result[amount]
