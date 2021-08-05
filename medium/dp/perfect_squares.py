import math
from typing import Dict, Set


class Solution:
    memory: Dict[int, int] = {1: 1,
                              2: 2,
                              3: 3,
                              4: 1,
                              5: 2,
                              6: 3,
                              7: 4,
                              8: 2,
                              }

    # noinspection PyMethodMayBeStatic
    def numSquares(self, n: int) -> int:
        Solution.memory[1] = 1
        squares: Set[int] = {1}
        square_generator_index = 2
        next_square = 4
        while next_square <= n:
            squares.add(next_square)
            square_generator_index += 1
            next_square = square_generator_index ** 2

        if n in squares:
            return 1

        def find_square_addition(target: int) -> int:
            if target in Solution.memory:
                return Solution.memory[target]
            if target in squares:
                return 1
            nearest_square_root = math.floor(math.sqrt(target))
            min_step_recursive = 10001
            for square_root_index in range(nearest_square_root, 0, -1):
                min_step_recursive = min(find_square_addition(
                    target=(target - (square_root_index ** 2))),
                    min_step_recursive)
            step = 1 + min_step_recursive
            Solution.memory[target] = step
            return step

        return find_square_addition(target=n)
