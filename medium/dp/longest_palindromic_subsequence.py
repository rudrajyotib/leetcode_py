from typing import Tuple, Dict


class Solution:
    # noinspection PyMethodMayBeStatic
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
            if s[start] == s[end]:
                max_palindrome_length = 2 + check_sub_sequence_recursive(start=start + 1, end=end - 1)
            else:
                max_palindrome_length = max(check_sub_sequence_recursive(start=start + 1, end=end),
                                            check_sub_sequence_recursive(start=start, end=end - 1))

            memory[(start, end)] = max_palindrome_length
            return max_palindrome_length

        return check_sub_sequence_recursive(start=0, end=len(s) - 1)
