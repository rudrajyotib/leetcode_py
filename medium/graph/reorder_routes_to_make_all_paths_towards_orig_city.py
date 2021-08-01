import collections
from typing import List, Dict, Set


class Solution:
    reverse_counter: int

    def minReorder(self, n: int, connections: List[List[int]]) -> int:
        Solution.reverse_counter = 0
        adjacency_matrix: Dict[int, Set[int]] = collections.defaultdict(set)
        adjacency_list: Dict[int, List[int]] = collections.defaultdict(list)
        # for row in range(n):
        #    adjacency_matrix.append([-1] * n)
        for connection in connections:
            adjacency_matrix[connection[0]].add(connection[1])
            adjacency_list[connection[0]].append(connection[1])
            adjacency_list[connection[1]].append(connection[0])

        visited: List[bool] = [False] * n
        adjacency_matrix[0].add(0)
        # bfs_queue = collections.deque()
        # bfs_queue.append(0)

        def find_paths_dfs(destination: int, source: int):
            visited[source] = True
            if destination not in adjacency_matrix[source]:
                Solution.reverse_counter += 1
            for src in adjacency_list[source]:
                if not visited[src]:
                    find_paths_dfs(destination=source, source=src)

        # while len(bfs_queue) > 0:
        #     node = bfs_queue.popleft()
        #     for column in range(0, n, 1):
        #         if adjacency_matrix[node][column] == 1:
        #             bfs_queue.append(column)
        #             adjacency_matrix[column][node] = -1
        #             adjacency_matrix[node][column] = -1
        #         elif adjacency_matrix[node][column] == 2:
        #             reverse_counter += 1
        #             bfs_queue.append(column)
        #             adjacency_matrix[column][node] = -1
        #             adjacency_matrix[node][column] = -1

        find_paths_dfs(destination=0, source=0)

        return Solution.reverse_counter
