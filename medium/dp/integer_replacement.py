from typing import Dict


class Solution:
    memory: Dict[int, int] = {}

    def integerReplacement(self, n: int) -> int:
        Solution.memory = {1: 0, 2: 1, 3: 2, 4: 2, 5: 3}

        def solve_recursive(target: int) -> int:
            if target in Solution.memory:
                return Solution.memory[target]
            if target % 2 == 0:
                Solution.memory[target] = 1 + solve_recursive(target=target / 2)
            else:
                Solution.memory[target] = 1 + min(solve_recursive(target=target - 1),
                                              solve_recursive(target=target + 1))
            return Solution.memory[target]

        return solve_recursive(target=n)
