"""
https://leetcode.com/problems/simplify-path/
Leetcode#71
"""
import collections


class Solution:
    def simplifyPath(self, path: str) -> str:

        directory_depth = collections.deque()
        directory_names = path.split("/")
        for directory_name in directory_names:
            if directory_name != "":
                if directory_name == "..":
                    if len(directory_depth) > 0:
                        directory_depth.pop()
                elif directory_name == ".":
                    continue
                else:
                    directory_depth.append(directory_name)
        if len(directory_depth) == 0:
            return "/"
        directory_depth.appendleft("")

        return "/".join(directory_depth)
