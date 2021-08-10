from typing import List


class Solution:
    # noinspection PyMethodMayBeStatic
    def change(self, amount: int, coins: List[int]) -> int:

        coins_sorted = sorted(coins)
        result = [0 for _ in range(amount + 1)]
        result[0] = 1
        for coin in coins_sorted:
            for amt in range(coin, amount + 1, 1):
                result[amt] += result[amt - coin]
        return result[amount]
