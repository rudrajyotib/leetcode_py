import collections
from typing import List


class Solution:
    # noinspection PyMethodMayBeStatic
    def findMinHeightTrees(self, n: int, edges: List[List[int]]) -> List[int]:

        if n == 1:
            return [0]
        depth_of_nodes: List[int] = [0] * n
        adjacency_list: List[List[int]] = []
        for i in range(0, n, 1):
            adjacency_list.append([])
        for edge in edges:
            adjacency_list[edge[0]].append(edge[1])
            adjacency_list[edge[1]].append(edge[0])
            depth_of_nodes[edge[0]] += 1
            depth_of_nodes[edge[1]] += 1

        leaves = collections.deque()
        for i in range(0, n, 1):
            if depth_of_nodes[i] == 1:
                leaves.append(i)

        size = n
        while size > 2:
            leaves_size = len(leaves)
            size -= leaves_size
            while leaves_size > 0:
                leaf = leaves.popleft()
                for adjacent_node in adjacency_list[leaf]:
                    depth_of_nodes[adjacent_node] -= 1
                    if depth_of_nodes[adjacent_node] == 1:
                        leaves.append(adjacent_node)
                leaves_size -= 1

        return list(leaves)
