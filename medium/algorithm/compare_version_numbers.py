"""
https://leetcode.com/problems/compare-version-numbers/
Leetcode#165
"""


class Solution:
    # noinspection PyMethodMayBeStatic
    def compareVersion(self, version1: str, version2: str) -> int:

        version1_indices = version1.split('.')
        version2_indices = version2.split('.')
        traverse_up_to = min(len(version2_indices), len(version1_indices))
        for index in range(traverse_up_to):
            index1 = int(version1_indices[index]) if version1_indices[index] != '' else 0
            index2 = int(version2_indices[index]) if version2_indices[index] != '' else 0
            if index1 < index2:
                return -1
            if index1 > index2:
                return 1
        if traverse_up_to == len(version1_indices):
            for index in range(traverse_up_to, len(version2_indices), 1):
                sub_version = int(version2_indices[index]) if version2_indices[index] != '' else 0
                if sub_version > 0:
                    return -1
        elif traverse_up_to == len(version2_indices):
            for index in range(traverse_up_to, len(version1_indices), 1):
                sub_version = int(version1_indices[index]) if version1_indices[index] != '' else 0
                if sub_version > 0:
                    return 1

        return 0
