"""
https://leetcode.com/problems/decode-string/
Leetcode#394
"""


import collections

"""
Mode defines what to do.
Mode - 0 : general string. directly add to result
Mode - 1 : sub-string mode. Inside a bracket. To be pushed into queue
Mode - 2 : number mode. Finding out number before bracket
"""


class Solution:
    def decodeString(self, s: str) -> str:

        result = ""
        stack = collections.deque()
        mode = 0
        if 48 <= ord(s[0]) <= 57:
            mode = 2
        else:
            mode = 0

        index = 0
        sub_string = ""
        while index < len(s):
            if mode == 0:
                if 97 <= ord(s[index]) <= 122:
                    result += s[index]
                    index += 1
                else:
                    mode=2
                    continue
            elif mode == 1:
                if 97 <= ord(s[index]) <= 122:
                    sub_string += s[index]
                    index += 1
                elif 48 <= ord(s[index]) <= 57:
                    stack.append(sub_string)
                    sub_string = ""
                    mode = 2
                    continue
                else:
                    repeat_count = stack.pop()
                    computed_string = repeat_count * sub_string
                    if len(stack) == 0:
                        result += computed_string
                        sub_string = ""
                        mode = 0
                    else:
                        awaiting_to_process = stack.pop()
                        awaiting_to_process += computed_string
                        sub_string = awaiting_to_process
                        mode = 1
                    index += 1
            elif mode == 2:
                next_bracket_index = s[index:].find('[')
                multiplier = int(s[index:index + next_bracket_index ])
                stack.append(multiplier)
                mode = 1
                index = index + next_bracket_index + 1

        return result
