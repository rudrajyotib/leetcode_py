"""
https://leetcode.com/problems/design-add-and-search-words-data-structure/
Leetcode#211
"""

class TrieNode:
    def __init__(self):
        self._end_of_word = False
        self._children = [None for _ in range(26)]

    @property
    def is_end_of_word(self) -> bool:
        return self._end_of_word

    def all_set_set_nodes(self):
        return list(filter(lambda x: x is not None, self._children))

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

    def get_all_set_nodes(self):
        return list(filter(lambda x: x is not None, self._nodes))

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


class WordDictionary:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self._trie = Trie()

    def addWord(self, word: str) -> None:
        if len(word) == 0:
            return
        self._trie.insert(word)

    def search(self, word: str) -> bool:
        if len(word) == 0:
            return False

        def search_recursive(search_word: str, index: int, node: TrieNode) -> bool:
            if index >= len(search_word):
                return False
            character = search_word[index]
            if index == len(search_word) - 1:
                if character != '.':
                    node = node.character(character=character)
                    if node and node.is_end_of_word:
                        return True
                    return False
                else:
                    nodes = node.all_set_set_nodes()
                    for node in nodes:
                        if node.is_end_of_word:
                            return True
                    return False
            else:
                if character != '.':
                    node = node.character(character=character)
                    if not node:
                        return False
                    else:
                        return search_recursive(search_word=search_word,
                                                index=index + 1,
                                                node=node)
                else:
                    nodes = node.all_set_set_nodes()
                    for node in nodes:
                        if search_recursive(search_word=search_word,
                                            index=index + 1,
                                            node=node):
                            return True
                    return False

        if len(word) == 1:
            if word[0] == '.':
                return len(list(filter(lambda x: x.is_end_of_word, self._trie.get_all_set_nodes()))) > 0
            else:
                return self._trie.is_set_node(character=word[0]) and self._trie.get_node(character=word[0]).is_end_of_word

        if word[0] == '.':
            all_nodes = self._trie.get_all_set_nodes()
            for node in all_nodes:
                if search_recursive(search_word=word,
                                    index=1,
                                    node=node):
                    return True
            return False
        else:
            node = self._trie.get_node(word[0])
            if node is None:
                return False
            else:
                return search_recursive(search_word=word,
                                        index=1,
                                        node=node)
