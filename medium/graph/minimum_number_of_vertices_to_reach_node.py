"""
All and only entry nodes.
"""

from typing import List


class Solution:
    # noinspection PyMethodMayBeStatic
    def findSmallestSetOfVertices(self, n: int, edges: List[List[int]]) -> List[int]:
        is_entry_node = [True] * n
        for edge in edges:
            if is_entry_node[edge[1]]:
                is_entry_node[edge[1]] = False

        result = []
        for index in range(0, n, 1):
            if is_entry_node[index]:
                result.append(index)

        return result
