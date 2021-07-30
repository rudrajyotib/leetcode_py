import collections
from typing import List


class Solution:
    next_color: int

    @staticmethod
    def get_next_color(seed: List[bool]):
        for i in range(4):
            if not seed[i]:
                return i

    # noinspection PyMethodMayBeStatic
    def gardenNoAdj(self, n: int, paths: List[List[int]]) -> List[int]:

        garden_color: List[int] = [-1] * (n + 1)
        adjacency_list: List[List[int]] = []
        seed_color: List[List[bool]] = []
        for index in range(n + 1):
            adjacency_list.append([])
            seed_color.append([False] * 4)
        for path in paths:
            adjacency_list[path[0]].append(path[1])
            adjacency_list[path[1]].append(path[0])

        def color_flowers_breadth_first(start: int):
            bfs_queue = collections.deque()
            bfs_queue.append(start)
            while len(bfs_queue) > 0:
                node = bfs_queue.popleft()
                if garden_color[node] == -1:
                    node_color = Solution.get_next_color(seed_color[node])
                    garden_color[node] = node_color + 1
                    for adjacent_node in adjacency_list[node]:
                        bfs_queue.append(adjacent_node)
                        seed_color[adjacent_node][node_color] = True

        for i in range(1, n + 1, 1):
            if garden_color[i] == -1:
                color_flowers_breadth_first(start=i)

        return garden_color[1:]
