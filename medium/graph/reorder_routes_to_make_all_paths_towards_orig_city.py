import collections
from typing import List, Dict, Set


class Solution:
    reverse_counter: int

    # noinspection PyMethodMayBeStatic
    def minReorder(self, n: int, connections: List[List[int]]) -> int:
        Solution.reverse_counter = 0
        adjacency_matrix: Dict[int, Set[int]] = collections.defaultdict(set)
        adjacency_list: Dict[int, List[int]] = collections.defaultdict(list)
        for connection in connections:
            adjacency_matrix[connection[0]].add(connection[1])
            adjacency_list[connection[0]].append(connection[1])
            adjacency_list[connection[1]].append(connection[0])

        visited: List[bool] = [False] * n
        adjacency_matrix[0].add(0)

        def find_paths_bfs():
            dfs_queue = collections.deque()
            dfs_queue.append((0, 0))
            while dfs_queue:
                node = dfs_queue.popleft()
                visited[node[0]] = True
                if node[0] not in adjacency_matrix[node[1]]:
                    Solution.reverse_counter += 1
                for src in adjacency_list[node[1]]:
                    if not visited[src]:
                        dfs_queue.append((node[1], src))

        find_paths_bfs()

        return Solution.reverse_counter
