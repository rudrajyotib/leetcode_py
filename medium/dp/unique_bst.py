from typing import Dict


class Solution:
    memory: Dict[int, int] = {
        0: 1,
        1: 1,
        2: 2,
        3: 5,
        4: 14,
        5: 42
    }

    # noinspection PyMethodMayBeStatic
    def numTrees(self, n: int) -> int:

        def count_unique_bst_recursive(node: int) -> int:
            if node in Solution.memory:
                return Solution.memory[node]
            result = 0
            for i in range(0, node, 1):
                result += count_unique_bst_recursive(i) * count_unique_bst_recursive(node - 1 - i)
            Solution.memory[node] = result
            return result

        return count_unique_bst_recursive(node=n)
