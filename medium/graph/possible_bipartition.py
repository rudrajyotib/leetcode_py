import collections
from typing import List, Dict, Deque


class Solution:
    # noinspection PyMethodMayBeStatic
    def possibleBipartition(self, n: int, dislikes: List[List[int]]) -> bool:

        adjacency_list: Dict[int, List[int]] = {}
        bfs_matrix = [-1] * (n + 1)
        # visited_nodes: List[bool] = [False] * n
        for vertex in dislikes:
            if (vertex[0]) in adjacency_list:
                adjacency_list[(vertex[0])].append((vertex[1]))
            else:
                adjacency_list[(vertex[0])] = [(vertex[1])]
            if (vertex[1]) in adjacency_list:
                adjacency_list[(vertex[1])].append((vertex[0]))
            else:
                adjacency_list[(vertex[1])] = [(vertex[0])]
        if len(adjacency_list) < 1:
            return True

        def check_bipartite_graph(root_node: int) -> bool:
            bfs_queue: Deque = collections.deque()
            neighbors = adjacency_list[root_node]
            bfs_matrix[root_node] = 0
            # visited_nodes[root_node] = True
            for neighbor in neighbors:
                adjacency_list[neighbor].remove(root_node)
                bfs_queue.append((neighbor, 0))
            adjacency_list[root_node] = []
            while len(bfs_queue) > 0:
                node = bfs_queue.popleft()
                if bfs_matrix[node[0]] == -1:
                    # visited_nodes[node[0]] = True
                    bfs_matrix[node[0]] = node[1]
                    node_neighbors = adjacency_list[node[0]]
                    if len(node_neighbors) > 0:
                        for node_neighbor in node_neighbors:
                            #adjacency_list[node_neighbor].remove(node[0])
                            if bfs_matrix[node_neighbor] == -1:
                                bfs_queue.append((node_neighbor, node[1] + 1))
                    adjacency_list[node[0]] = []
                else:
                    if bfs_matrix[node[0]] == node[1] - 1:
                        return False
                    bfs_matrix[node[0]] = node[1]
            return True

        for vertex in range(1, n+1, 1):
            if bfs_matrix[vertex] == -1:
                if vertex not in adjacency_list:
                    bfs_matrix[vertex] = 0
                else:
                    is_bipartite = check_bipartite_graph(root_node=vertex)
                    if not is_bipartite:
                        return False
        return True
