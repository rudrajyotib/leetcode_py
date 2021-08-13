"""
Leet-code#49
https://leetcode.com/problems/group-anagrams/
"""


import collections
from typing import List, Dict


class Solution:
    # noinspection SpellCheckingInspection,PyMethodMayBeStatic
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:

        core_chars_map: Dict[str, List] = collections.defaultdict(list)
        for single_input in strs:

            char_list = [0] * 26
            for char in single_input:
                char_list[ord(char) - 97] += 1
            core_chars_map[
                ''.join([chr(97 + index) * count for index, count in enumerate(char_list) if count > 0])].append(
                single_input)

        result = []
        for value in core_chars_map.values():
            result.append(value)
        return result
