import collections
from typing import List, Dict


class Solution:
    # noinspection PyMethodMayBeStatic
    def shortestAlternatingPaths(self, n: int, red_edges: List[List[int]], blue_edges: List[List[int]]) -> List[int]:
        ###########
        # First element of Answer Tuple = RED
        # Second element of Answer Tuple = BLUE
        ###########

        adjacency_list: List[Dict[int, List[int]]] = []
        visited_path: List[List[int]] = []

        for i in range(n):
            adjacency_list.append({})
            visited_path.append([-1, -1])

        for red_edge in red_edges:
            adjacency_list[red_edge[0]][red_edge[1]] = [1, -1]
        for blue_edge in blue_edges:
            if blue_edge[1] in adjacency_list[blue_edge[0]]:
                adjacency_list[blue_edge[0]][blue_edge[1]][1] = 1
            else:
                adjacency_list[blue_edge[0]][blue_edge[1]] = [-1, 1]

        bfs_queue = collections.deque()
        bfs_queue.append((0, 0, 0))
        while len(bfs_queue) > 0:
            node_path = bfs_queue.popleft()
            present_path_at_node = visited_path[node_path[0]]
            path_changed: bool = False
            if present_path_at_node[0] == -1:
                if node_path[1] != -1:
                    present_path_at_node[0] = node_path[1]
                    path_changed = True
            else:
                if present_path_at_node[0] > node_path[1] != -1:
                    present_path_at_node[0] = node_path[1]
                    path_changed = True
            if present_path_at_node[1] == -1:
                if node_path[2] != -1:
                    present_path_at_node[1] = node_path[2]
                    path_changed = True
            else:
                if present_path_at_node[1] > node_path[2] != -1:
                    present_path_at_node[1] = node_path[2]
                    path_changed = True
            if path_changed:
                for adjacent_node in adjacency_list[node_path[0]].items():
                    next_node = adjacent_node[0]
                    next_node_red = adjacent_node[1][0]
                    next_node_blue = adjacent_node[1][1]
                    if present_path_at_node[0] != -1 and next_node_blue != -1:
                        next_node_blue = present_path_at_node[0] + 1
                    else:
                        next_node_blue = -1
                    if present_path_at_node[1] != -1 and next_node_red != -1:
                        next_node_red = present_path_at_node[1] + 1
                    else:
                        next_node_red = -1
                    bfs_queue.append((next_node, next_node_red, next_node_blue))

        result = []
        for path in visited_path:
            if path[0] != -1 and path[1] != -1:
                result.append(min(path[0], path[1]))
            elif path[0] != -1:
                result.append(path[0])
            else:
                result.append(path[1])

        return result
