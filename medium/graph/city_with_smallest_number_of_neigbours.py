import math
from typing import List


class Solution:
    # noinspection PyMethodMayBeStatic
    def findTheCity(self, n: int, edges: List[List[int]], distanceThreshold: int) -> int:
        adjacency_matrix: List[List[int]] = []
        for row in range(n):
            adjacency_matrix.append([])
            for col in range(n):
                # noinspection PyTypeChecker
                adjacency_matrix[row].append(math.inf)
        for edge in edges:
            adjacency_matrix[edge[0]][edge[1]] = edge[2]
            adjacency_matrix[edge[1]][edge[0]] = edge[2]

        def calculate_distance_dfs():
            # noinspection PyShadowingNames
            for i in range(n):
                adjacency_matrix[i][i] = 0

            for k in range(n):
                # noinspection PyShadowingNames
                for i in range(n):
                    # noinspection PyShadowingNames
                    for j in range(n):
                        adjacency_matrix[i][j] = min(adjacency_matrix[i][j],
                                                     adjacency_matrix[i][k] + adjacency_matrix[k][j])

        calculate_distance_dfs()
        index = -1
        neighbour_count = math.inf
        for i in range(n):
            row_count = 0
            for j in range(n):
                if adjacency_matrix[i][j] <= distanceThreshold:
                    row_count += 1
            if row_count <= neighbour_count:
                neighbour_count = row_count
                index = i

        return index
