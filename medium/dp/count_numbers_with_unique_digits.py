from typing import List


class Solution:
    def countNumbersWithUniqueDigits(self, n: int) -> int:
        if n == 0:
            return 1
        if n == 1:
            return 10
        result: List[int] = [1, 9]
        multiplier = 9
        for i in range(2, n + 1, 1):
            result.append(result[i - 1] * multiplier)
            multiplier -= 1

        return sum(result)
