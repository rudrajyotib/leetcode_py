from typing import List

"""
https://leetcode.com/problems/pacific-atlantic-water-flow/
Leetcode#417
"""

def in_range(height: int, width: int, co_ordinates: List[int]) -> bool:
    return (0 <= co_ordinates[0] < height) and (0 <= co_ordinates[1] < width)


def generate_neighbors(row_index, col_index) -> List[List[int]]:
    return [[row_index, col_index - 1], [row_index, col_index + 1], [row_index - 1, col_index],
            [row_index + 1, col_index]]


def dfs(co_ordinates: List[int], topography: List[List[int]], movement: List[List[bool]], visited: List[List[bool]]):
    for neighbour in generate_neighbors(co_ordinates[0], co_ordinates[1]):
        if (in_range(len(topography), len(topography[0]), neighbour)) \
                and topography[neighbour[0]][neighbour[1]] >= topography[co_ordinates[0]][co_ordinates[1]] \
                and not visited[neighbour[0]][neighbour[1]]:
            movement[neighbour[0]][neighbour[1]] = True
            visited[neighbour[0]][neighbour[1]] = True
            dfs(neighbour, topography, movement, visited)


class Solution:

    def pacificAtlantic(self, heights: List[List[int]]) -> List[List[int]]:

        if len(heights) == 1:
            return [[0, _] for _ in range(len(heights[0]))]

        pacific = [[False for _ in range(len(heights[0]))] for _ in range(len(heights))]
        atlantic = [[False for _ in range(len(heights[0]))] for _ in range(len(heights))]
        visited = [[False for _ in range(len(heights[0]))] for _ in range(len(heights))]

        for i in range(len(heights)):
            pacific[i][0] = True
            atlantic[i][len(heights[0]) - 1] = True
        for j in range(len(heights[0])):
            pacific[0][j] = True
            atlantic[len(heights) - 1][j] = True

        for i in range(len(heights)):
            dfs([i, 0], heights, pacific, visited)
        for j in range(len(heights[0])):
            dfs([0, j], heights, pacific, visited)
        visited = [[False for _ in range(len(heights[0]))] for _ in range(len(heights))]
        for i in range(len(heights)):
            dfs([i, len(heights[0]) - 1], heights, atlantic, visited)
        for j in range(len(heights[0])):
            dfs([len(heights) - 1, j], heights, atlantic, visited)

        result = []

        for i in range(len(heights)):
            for j in range(len(heights[0])):
                if pacific[i][j] and atlantic[i][j]:
                    result.append([i, j])

        return result


class PacificAtlantic:
    def calculate_water_flow(self, heights: List[List[int]]) -> List[List[int]]:
        solution = Solution()
        return solution.pacificAtlantic(heights)
