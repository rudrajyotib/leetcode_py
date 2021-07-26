from typing import List


class Solution:
    def validateBinaryTreeNodes(self, n: int, leftChild: List[int], rightChild: List[int]) -> bool:

        if n == 1:
            return leftChild[0] == -1 and rightChild[0] == -1

        validator = [False] * n
        for left_index in range(0, n, 1):
            if leftChild[left_index] != -1:
                if validator[leftChild[left_index]]:
                    return False
                if leftChild[leftChild[left_index]] == left_index:
                    return False
                if rightChild[leftChild[left_index]] == left_index:
                    return False
                if leftChild[left_index] == left_index:
                    return False
                validator[leftChild[left_index]] = True

        for right_index in range(0, n, 1):
            if rightChild[right_index] != -1:
                if validator[rightChild[right_index]]:
                    return False
                if rightChild[rightChild[right_index]] == right_index:
                    return False
                if leftChild[rightChild[right_index]] == right_index:
                    return False
                if rightChild[right_index] == right_index:
                    return False
                validator[rightChild[right_index]] = True

        root_node = -1
        for validator_index in range(0, n, 1):
            if not validator[validator_index]:
                if root_node >= 0:
                    return False
                else:
                    root_node = validator_index

        if root_node == -1:
            return False

        if rightChild[root_node] == -1 and leftChild[root_node] == -1:
            return False

        return True
