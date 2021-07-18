from unittest import TestCase

from medium.tree.btree_serialise_deserialise_bst import TreeNode, Codec


class TestCodec(TestCase):
    def test_should_serialise_bst(self):
        level1_child1 = TreeNode(1)
        level1_child2 = TreeNode(3)
        root = TreeNode(2)
        root.left = level1_child1
        root.right = level1_child2

        codec = Codec()

        self.assertEqual('2,1,3', codec.serialize(root=root), "Not serialised properly")

    def test_should_serialise_empty_tree(self):
        codec = Codec()
        # noinspection PyTypeChecker
        self.assertEqual("NO_TREE", codec.serialize(root=None), "Empty tree node not handled")

    def test_should_deserialise_and_form_btree(self):
        codec = Codec()
        root_node = codec.deserialize(data='2,1,3')
        self.assertIsNotNone(root_node, "tree not formed")
        self.assertEqual(2, root_node.val, "Root node not formed")
        self.assertEqual(1, root_node.left.val, "Left node not formed")
        self.assertEqual(3, root_node.right.val, "Right node not formed")

    def test_should_handle_empty_string(self):
        codec = Codec()
        self.assertIsNone(codec.deserialize(""), "Empty string not handled")

    def test_should_handle_no_tree_serialsied_string(self):
        codec = Codec()
        self.assertIsNone(codec.deserialize("NO_TREE"), "Empty tree serialised string not handled")

    def test_should_serialise_and_deserialise(self):
        serialiser = Codec()
        deserialiser = Codec()
        level1_child1 = TreeNode(1)
        level1_child2 = TreeNode(3)
        root = TreeNode(2)
        root.left = level1_child1
        root.right = level1_child2
        serialised_string = serialiser.serialize(root=root)
        deserialised_root = deserialiser.deserialize(data=serialised_string)
        self.assertEqual(deserialised_root.val, root.val, "Same root not retrieved")
        self.assertEqual(deserialised_root.left.val, root.left.val, "Same left child not retrieved")
        self.assertEqual(deserialised_root.right.val, root.right.val, "Same right child not retrieved")