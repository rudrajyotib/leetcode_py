from typing import List


"""
https://leetcode.com/problems/longest-repeating-character-replacement/
Leetcode#424
"""



class LongestRepeatingCharacterReplacement:

    def solve(self, s: str, k: int) -> int:
        sol = self.Solution()
        return sol.characterReplacement(s, k)

    class Solution:
        def characterReplacement(self, s: str, k: int) -> int:

            chars: List[int] = [0 for _ in range(26)]
            max_length: int = 1
            start_frame = 0
            max_count_of_single_char = 0
            chars[ord(s[0]) - 65] = 1

            for index in range(1, len(s), 1):
                chars[ord(s[index]) - 65] += 1
                max_count_of_single_char = max(max_count_of_single_char, chars[ord(s[index]) - 65])
                changes_left = k - (((index + 1) - start_frame) - max_count_of_single_char)

                if changes_left < 0:
                    move_start_frame: bool = True
                    while move_start_frame:
                        if s[start_frame] != s[start_frame + 1]:
                            move_start_frame = False
                        chars[ord(s[start_frame]) - 65] -= 1
                        start_frame += 1
                max_length = max((index + 1 - start_frame), max_length)

            return max_length
