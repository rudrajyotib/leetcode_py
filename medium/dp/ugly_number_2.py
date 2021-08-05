from typing import List


class Solution:
    # noinspection PyMethodMayBeStatic
    def nthUglyNumber(self, n: int) -> int:
        result: List[int] = [-1 for _ in range(n + 1)]

        result[0] = 0
        result[1] = 1

        multiplier2 = multiplier3 = multiplier5 = 1

        for index in range(2, n + 1, 1):
            multiplied2 = result[multiplier2] * 2
            multiplied3 = result[multiplier3] * 3
            multiplied5 = result[multiplier5] * 5

            next_num = min(multiplied2, multiplied3, multiplied5)
            result[index] = next_num

            if next_num == multiplied2:
                multiplier2 += 1
            if next_num == multiplied3:
                multiplier3 += 1
            if next_num == multiplied5:
                multiplier5 += 1

        return result[n]
