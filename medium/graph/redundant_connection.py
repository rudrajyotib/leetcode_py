import collections
from typing import List, Dict


class Solution:
    # noinspection PyMethodMayBeStatic
    def findRedundantConnection(self, edges: List[List[int]]) -> List[int]:

        adjacency_list: Dict[int, List[int]] = {}
        queue = collections.deque()
        for edge in edges:
            if edge[0] in adjacency_list:
                adjacency_list[edge[0]].append(edge[1])
            else:
                adjacency_list[edge[0]] = [edge[1]]
            if edge[1] in adjacency_list:
                adjacency_list[edge[1]].append(edge[0])
            else:
                adjacency_list[edge[1]] = [edge[0]]

        for key, value in adjacency_list.items():
            if len(value) == 1:
                queue.append(key)

        while len(queue) > 0:
            node = queue.pop()
            linked_edges = adjacency_list.pop(node)
            adjacency_list[linked_edges[0]].remove(node)
            if len(adjacency_list[linked_edges[0]]) == 1:
                queue.append(linked_edges[0])

        for i in range(len(edges)-1, -1, -1):
            if edges[i][0] in adjacency_list and edges[i][1] in adjacency_list:
                return edges[i]
