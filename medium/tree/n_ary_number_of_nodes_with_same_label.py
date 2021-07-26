from typing import List


def merge_array(array1: [int], array2: [int]):
    for index in range(0, len(array1)):
        array1[index] += array2[index]


class Solution:
    result: [int]

    # noinspection PyMethodMayBeStatic
    def countSubTrees(self, n: int, edges: List[List[int]], labels: str) -> List[int]:

        Solution.result = [1] * n
        tree_structure = {}
        for i in range(0, n, 1):
            tree_structure[i] = []
        for edge in edges:
            tree_structure[edge[0]].append(edge[1])
            tree_structure[edge[1]].append(edge[0])

        def update_frequencies(node: int, parent_node: int) -> [int]:
            relation: [int] = tree_structure[node]
            result_at_node = [0] * 26
            if len(relation) == 1 and relation[0] == parent_node:
                result_at_node[ord(labels[node]) - 97] += 1
                return result_at_node
            else:
                for index in range(0, len(relation), 1):
                    if relation[index] != parent_node:
                        merge_array(result_at_node, update_frequencies(node=relation[index], parent_node=node))
                Solution.result[node] += result_at_node[ord(labels[node]) - 97]
                result_at_node[ord(labels[node]) - 97] += 1
                return result_at_node

        update_frequencies(node=0, parent_node=-1)

        return Solution.result
