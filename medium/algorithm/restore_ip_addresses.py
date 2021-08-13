"""
https://leetcode.com/problems/restore-ip-addresses/
Leetcode#93
"""
from typing import List


class Solution:
    # noinspection PyMethodMayBeStatic
    def restoreIpAddresses(self, s: str) -> List[str]:

        result: List[str] = []

        def resolve(start_index: int, parts_count: int, sub_part: str):
            if parts_count == 3:
                if start_index > len(s) - 1:
                    return
                if len(s) - start_index > 3:
                    return
                if start_index == len(s) - 1:
                    result.append("{}{}".format(sub_part, s[start_index]))
                elif s[start_index] == '0':
                    return
                elif int(s[start_index:]) < 256:
                    result.append("{}{}".format(sub_part, s[start_index:]))
            else:
                if start_index >= len(s):
                    return
                if start_index + (3-parts_count) >= len(s):
                    return
                if ord(s[start_index]) == 48:
                    resolve(start_index=start_index + 1,
                            parts_count=parts_count + 1,
                            sub_part="{}{}.".format(sub_part, 0))
                else:
                    resolve(start_index=start_index + 1,
                            parts_count=parts_count + 1,
                            sub_part="{}{}.".format(sub_part, s[start_index]))
                    if start_index + 1 < len(s) - 1:
                        resolve(start_index=start_index + 2,
                                parts_count=parts_count + 1,
                                sub_part="{}{}.".format(sub_part, s[start_index:start_index + 2]))
                    if start_index + 2 < len(s) - 1:
                        if int(s[start_index:start_index + 3]) < 256:
                            resolve(start_index=start_index + 3,
                                    parts_count=parts_count + 1,
                                    sub_part="{}{}.".format(sub_part, s[start_index:start_index + 3]))

        resolve(start_index=0, parts_count=0, sub_part="")

        return result
