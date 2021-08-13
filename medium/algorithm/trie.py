"""
https://leetcode.com/problems/implement-trie-prefix-tree/
Leetcode#208
"""


class TrieNode:
    def __init__(self):
        self._end_of_word = False
        self._children = [None for _ in range(26)]

    @property
    def is_end_of_word(self) -> bool:
        return self._end_of_word

    @property
    def children(self):
        return self._children

    def character(self, character: str):
        return self._children[ord(character) - 97]

    def is_set_character(self, character: str):
        return self._children[ord(character) - 97] is not None

    def mark_end_of_word(self):
        self._end_of_word = True

    def create_node(self, character: str):
        if not self.is_set_character(character=character):
            node = TrieNode()
            # noinspection PyTypeChecker
            self._children[ord(character) - 97] = node
        return self.character(character=character)


class Trie:

    def __init__(self):
        self._nodes = [None for _ in range(26)]
        """
        Initialize your data structure here.
        """

    def is_set_node(self, character: str) -> bool:
        return self._nodes[ord(character) - 97] is not None

    def get_node(self, character: str):
        return self._nodes[ord(character) - 97]

    def create_node(self, character: str) -> None:
        if not self.is_set_node(character):
            node = TrieNode()
            # noinspection PyTypeChecker
            self._nodes[ord(character) - 97] = node
        return self.get_node(character)

    def insert(self, word: str) -> None:
        """
        Inserts a word into the trie.
        """
        if len(word) == 0:
            return None
        word_len = len(word)
        # noinspection PyNoneFunctionAssignment
        node = self.create_node(character=word[0])
        for index in range(1, word_len, 1):
            node = node.create_node(character=word[index])
        node.mark_end_of_word()

    def search(self, word: str) -> bool:
        """
        Returns if the word is in the trie.
        """
        if len(word) == 0:
            return False
        if not self.is_set_node(character=word[0]):
            return False
        # noinspection PyNoneFunctionAssignment
        node = self.get_node(character=word[0])
        for index in range(1, len(word), 1):
            node = node.character(character=word[index])
            if not node:
                return False
        return node.is_end_of_word

    def startsWith(self, prefix: str) -> bool:
        """
        Returns if there is any word in the trie that starts with the given prefix.
        """
        if len(prefix) == 0:
            return False
        if not self.is_set_node(character=prefix[0]):
            return False
        # noinspection PyNoneFunctionAssignment
        node = self.get_node(character=prefix[0])
        for index in range(1, len(prefix), 1):
            node = node.character(character=prefix[index])
            if not node:
                return False
        return True
