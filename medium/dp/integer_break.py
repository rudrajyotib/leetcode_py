import math
from typing import Dict


class Solution:
    memory: Dict[int, int] = {1: 1, 2: 2, 3: 3, 4: 4}

    # noinspection PyMethodMayBeStatic
    def integerBreak(self, n: int) -> int:

        if n == 3:
            return 2
        if n == 2:
            return 1

        def integer_break_recursive(limit: int) -> n:
            if limit in Solution.memory:
                return Solution.memory[limit]
            mid = math.ceil(limit / 2)
            max_prod = 0
            for i in range(1, mid + 1, 1):
                max_prod = max(integer_break_recursive(i) * integer_break_recursive(limit - i), max_prod)
            Solution.memory[limit] = max_prod
            return max_prod

        return integer_break_recursive(limit=n)
