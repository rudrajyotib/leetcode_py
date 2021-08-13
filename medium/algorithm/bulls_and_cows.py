"""
https://leetcode.com/problems/bulls-and-cows/
Leetcode#299
"""

from typing import List


class Solution:
    def getHint(self, secret: str, guess: str) -> str:

        guesses: List[int] = [0 for _ in range(10)]
        secrets: List[int] = [0 for _ in range(10)]

        hits = 0

        for character in secret:
            secrets[ord(character) - 48] += 1

        for index in range(len(guess)):
            if secret[index] == guess[index]:
                hits += 1
                secrets[ord(secret[index])-48] -= 1
            else:
                guesses[ord(guess[index])-48] += 1

        miss = 0
        for index in range(10):
            miss += min(guesses[index], secrets[index])

        return "{}A{}B".format(hits, miss)
