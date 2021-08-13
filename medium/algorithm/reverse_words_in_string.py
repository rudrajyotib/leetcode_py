"""
https://leetcode.com/problems/reverse-words-in-a-string/
Leetcode#151
"""


class Solution:
    def reverseWords(self, s: str) -> str:

        in_word = False
        in_space = True

        sentence_length = len(s)
        temp_word = ""
        words = []

        for index in range(sentence_length):
            if ord(s[index]) == 32:
                if in_word:
                    in_word = False
                    words.append(temp_word)
                    temp_word = ""
                    in_space = True
            else:
                if in_space:
                    in_space = False
                    in_word = True
                    temp_word += s[index]
                else:
                    temp_word +=s[index]

        if len(temp_word) > 0:
            words.append(temp_word)

        words.reverse()
        return " ".join(words)
