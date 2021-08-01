from typing import List


class Solution:
    # noinspection PyMethodMayBeStatic
    def maximalNetworkRank(self, n: int, roads: List[List[int]]) -> int:

        roads_connecting_node = [0] * n
        adjacency_matrix: List[List[bool]] = []
        for row in range(0, n, 1):
            adjacency_matrix.append([False] * n)
        for road in roads:
            roads_connecting_node[road[0]] += 1
            roads_connecting_node[road[1]] += 1
            adjacency_matrix[road[0]][road[1]] = True
            adjacency_matrix[road[1]][road[0]] = True

        max_conn = 0

        for row in range(0, n, 1):
            for column in range(row + 1, n, 1):
                connected_roads = roads_connecting_node[row] + roads_connecting_node[column] - (
                    1 if adjacency_matrix[row][column] else 0)
                if connected_roads > max_conn:
                    max_conn = connected_roads

        return max_conn
