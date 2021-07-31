"""
Same solution as City with smallest number of neighbours.
Base algorithm is at : https://www.geeksforgeeks.org/floyd-warshall-algorithm-dp-16/
Instead of comparing smallest, compare if the path exists.
"""
from typing import List


class Solution:
    # noinspection PyMethodMayBeStatic
    def checkIfPrerequisite(self, numCourses: int, prerequisites: List[List[int]],
                            queries: List[List[int]]) -> List[bool]:

        adjacency_matrix: List[List[bool]] = []
        for row in range(numCourses):
            adjacency_matrix.append([])
            for col in range(numCourses):
                adjacency_matrix[row].append(False)

        for row in range(numCourses):
            adjacency_matrix[row][row] = True

        for prerequisite in prerequisites:
            adjacency_matrix[prerequisite[0]][prerequisite[1]] = True

        for k in range(numCourses):
            for i in range(numCourses):
                for j in range(numCourses):
                    adjacency_matrix[i][j] = adjacency_matrix[i][j] or (
                            adjacency_matrix[i][k] and adjacency_matrix[k][j])

        return list(map(lambda x: adjacency_matrix[x[0]][x[1]], queries))
