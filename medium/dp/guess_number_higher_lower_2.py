import math
from typing import Dict, Tuple


def cost_non_leaf_nodes_in_sub_tree_recursive(start: int, end: int) -> int:
    if start >= end:
        return 0
    if (start, end) in Solution.memory:
        return Solution.memory[(start, end)]
    min_val = math.inf
    for index in range(start, end + 1, 1):
        cost = max(cost_non_leaf_nodes_in_sub_tree_recursive(start=start, end=index - 1),
                   cost_non_leaf_nodes_in_sub_tree_recursive(start=index + 1, end=end)) + index
        if cost < min_val:
            min_val = cost
    Solution.memory[(start, end)] = min_val
    return min_val


class Solution:
    memory: Dict[Tuple, int] = {}

    def getMoneyAmount(self, n: int) -> int:

        if n == 1:
            return 0
        if n == 2:
            return 1
        if n == 3:
            return 2

        Solution.memory = {(1, 3): 2, (1, 2): 1, (2, 3): 2}
        return cost_non_leaf_nodes_in_sub_tree_recursive(start=1, end=n)
