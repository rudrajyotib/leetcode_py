from typing import Tuple, Dict


class Solution:
    def longestPalindromeSubseq(self, s: str) -> int:

        if len(s) == 1:
            return 1
        memory: Dict[Tuple, int] = {}

        def check_sub_sequence_recursive(start: int, end: int) -> int:

            if start == end:
                return 1
            if (start, end) in memory:
                return memory[(start, end)]
            if start > end:
                return 0
            if start == end - 1:
                if s[start] == s[end]:
                    memory[(start, end)] = 2
                    return 2
                memory[(start, end)] = 1
                return 1
            max_palindrome_length = 1
            for outer_index in range(start, end+1, 1):
                for inner_index in range(outer_index + 1, end+1, 1):
                    if s[outer_index] == s[inner_index]:
                        palindrome_length = 2 + check_sub_sequence_recursive(start=outer_index+1,
                                                                         end=inner_index-1)
                        if palindrome_length > max_palindrome_length:
                            max_palindrome_length = palindrome_length

            memory[(start, end)] = max_palindrome_length
            return max_palindrome_length

        return check_sub_sequence_recursive(start=0, end=len(s)-1)
