import collections
from typing import List, Deque


class Solution:
    # noinspection PyMethodMayBeStatic
    def possibleBipartition(self, n: int, dislikes: List[List[int]]) -> bool:

        adjacency_list: List[List[int]] = []
        for i in range(0, n + 1, 1):
            adjacency_list.append([])
        bfs_matrix = [-1] * (n + 1)
        for vertex in dislikes:
            adjacency_list[(vertex[0])].append((vertex[1]))
            adjacency_list[(vertex[1])].append((vertex[0]))

        def check_bipartite_graph(root_node: int) -> bool:
            bfs_queue: Deque = collections.deque()
            neighbors = adjacency_list[root_node]
            bfs_matrix[root_node] = 0
            for neighbor in neighbors:
                adjacency_list[neighbor].remove(root_node)
                bfs_queue.append((neighbor, 0))
            adjacency_list[root_node] = []
            while len(bfs_queue) > 0:
                node = bfs_queue.popleft()
                if bfs_matrix[node[0]] == -1:
                    bfs_matrix[node[0]] = node[1]
                    node_neighbors = adjacency_list[node[0]]
                    if len(node_neighbors) > 0:
                        for node_neighbor in node_neighbors:
                            if bfs_matrix[node_neighbor] == -1:
                                bfs_queue.append((node_neighbor, node[1] + 1))
                    adjacency_list[node[0]] = []
                else:
                    if bfs_matrix[node[0]] == node[1] - 1:
                        return False
                    bfs_matrix[node[0]] = node[1]
            return True

        for vertex in range(1, n + 1, 1):
            if not len(adjacency_list[vertex]) == 0:
                if len(adjacency_list[vertex]) == 0:
                    bfs_matrix[vertex] = 0
                else:
                    is_bipartite = check_bipartite_graph(root_node=vertex)
                    if not is_bipartite:
                        return False
        return True
