class Solution:
    def countSubstrings(self, s: str) -> int:

        count = len(s)

        for index in range(1, len(s), 1):
            if s[index] == s[index - 1]:
                count += 1
                left = index - 2
                right = index + 1
                while left > -1 and right < len(s) and s[left] == s[right]:
                    count += 1
                    left -= 1
                    right += 1
            if index < len(s) - 1 and s[index - 1] == s[index + 1]:
                count += 1
                left = index - 2
                right = index + 2
                while left > -1 and right < len(s) and s[left] == s[right]:
                    count += 1
                    left -= 1
                    right += 1
        return count
