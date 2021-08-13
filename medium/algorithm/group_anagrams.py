"""
Leet-code#49
https://leetcode.com/problems/group-anagrams/
"""


import collections
from typing import List, Dict


class Solution:
    # noinspection SpellCheckingInspection,PyMethodMayBeStatic
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:

        if len(strs) == 1:
            return [strs]

        core_chars_map: Dict[str, List[str]] = collections.defaultdict(list)
        for single_input in strs:

            char_list = collections.defaultdict(int)
            sorted_single_input = sorted(single_input)
            for char in sorted_single_input:
                char_list[char] += 1
            core_chars_map[
                ''.join([element * char_list[element] for element in (char_list.keys()) if char_list[element] > 0])].append(
                single_input)

        # noinspection PyTypeChecker
        return core_chars_map.values()
