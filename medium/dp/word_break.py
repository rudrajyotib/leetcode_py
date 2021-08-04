from typing import List, Set


class Solution:
    impossible_index: Set

    def wordBreak(self, s: str, wordDict: List[str]) -> bool:

        Solution.impossible_index = set()

        def search_index_recursive(start: int, length: int) -> bool:
            if start == length:
                return True
            for index in range(start, length):
                if s[start:index + 1] in wordDict and index not in Solution.impossible_index:
                    break_possible = search_index_recursive(index + 1, length)
                    if break_possible:
                        return True
                    else:
                        Solution.impossible_index.add(index)
            return False

        return search_index_recursive(0, len(s))
