from typing import List, Dict


class Solution:
    # noinspection PyMethodMayBeStatic
    def removeStones(self, stones: List[List[int]]) -> int:

        node_group_count = -1
        node_groups: List[int] = []
        row_group: Dict[int, int] = {}
        col_group: Dict[int, int] = {}

        for stone in stones:
            if stone[0] in row_group and stone[1] in col_group:
                if row_group[stone[0]] == col_group[stone[1]]:
                    node_groups[row_group[stone[0]]] += 1
                else:
                    if node_groups[row_group[stone[0]]] < node_groups[col_group[stone[1]]]:
                        group_to_merge = row_group[stone[0]]
                        group_to_merge_with = col_group[stone[1]]
                    else:
                        group_to_merge = col_group[stone[1]]
                        group_to_merge_with = row_group[stone[0]]
                    for key in row_group.keys():
                        if row_group[key] == group_to_merge:
                            row_group[key] = group_to_merge_with
                    for key in col_group.keys():
                        if col_group[key] == group_to_merge:
                            col_group[key] = group_to_merge_with
                    node_groups[group_to_merge_with] += node_groups[group_to_merge]
                    node_groups[group_to_merge_with] += 1
                    node_groups[group_to_merge] = 0
            elif stone[0] in row_group and stone[1] not in col_group:
                col_group[stone[1]] = row_group[stone[0]]
                node_groups[row_group[stone[0]]] += 1
            elif stone[0] not in row_group and stone[1] in col_group:
                row_group[stone[0]] = col_group[stone[1]]
                node_groups[col_group[stone[1]]] += 1
            else:
                node_group_count += 1
                node_groups.append(1)
                row_group[stone[0]] = node_group_count
                col_group[stone[1]] = node_group_count

        result = 0
        for node in node_groups:
            if node > 1:
                result += (node-1)

        return result
