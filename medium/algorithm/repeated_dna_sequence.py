"""
https://leetcode.com/problems/repeated-dna-sequences/
Leetcode#187
"""

from typing import List


class Solution:
    def findRepeatedDnaSequences(self, s: str) -> List[str]:

        if len(s) < 11:
            return []
        result_set = set()
        sequence_set = set()
        dna_sequence = s[0:10]
        sequence_set.add(dna_sequence)
        for index in range(10, len(s), 1):
            dna_sequence = dna_sequence[1:]+s[index]
            if dna_sequence in sequence_set:
                result_set.add(dna_sequence)
            else:
                sequence_set.add(dna_sequence)
        return result_set


