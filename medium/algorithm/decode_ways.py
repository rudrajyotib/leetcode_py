"""
https://leetcode.com/problems/decode-ways/
Leetcode#91
"""


class Solution:
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
                if s[index - 1] == '1' or s[index - 1] == '2':
                    result[index + 1] = result[index - 1]
                else:
                    return 0
            elif 49 <= ord(s[index]) <= 54:
                if s[index - 1] == '1' or s[index - 1] == '2':
                    result[index + 1] = result[index] + result[index - 1]
                else:
                    result[index + 1] = result[index]
            elif 55 <= ord(s[index]) <= 57 and s[index - 1] == '1':
                result[index + 1] = result[index] + result[index - 1]
            else:
                result[index + 1] = result[index]

        return result[len(s)]
