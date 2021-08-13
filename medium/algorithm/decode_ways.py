"""
https://leetcode.com/problems/decode-ways/
Leetcode#91
"""


class Solution:
    # noinspection PyMethodMayBeStatic
    def numDecodings(self, s: str) -> int:

        if s[0] == '0':
            return 0
        if len(s) == 1:
            return 1
        result = [0] * (len(s) + 1)
        result[0] = 1
        result[1] = 1

        for index in range(1, len(s), 1):
            if result[index - 1] == 0:
                return 0
            if s[index] == '0':
                if 49 <= ord(s[index - 1]) <= 50:
                    result[index + 1] = result[index - 1]
                    continue
                else:
                    return 0
            code = int(s[index - 1:index + 1])
            if 11 <= code <= 26:
                result[index + 1] = result[index] + result[index - 1]
            else:
                result[index + 1] = result[index]

        return result[len(s)]
