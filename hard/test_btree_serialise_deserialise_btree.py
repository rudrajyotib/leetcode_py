from unittest import TestCase

from hard.btree_serialise_deserialise_btree import TreeNode, Codec, find_start_and_end_of_sub_tree


class TestCodec(TestCase):
    def test_serialize_set1(self):
        root = TreeNode("10")
        root.left = TreeNode("11")
        root.left.right = TreeNode("14")
        root.right = TreeNode("12")
        root.right.right = TreeNode("13")
        solution = Codec()
        self.assertEqual("10(11()[2](14()[3]()))[1](12()[2](13()[3]()))", solution.serialize(root))

    def test_serialize_set2(self):
        root = TreeNode("10")
        solution = Codec()
        self.assertEqual("10()[1]()", solution.serialize(root))

    def test_node_creation_set1(self):
        root_node = find_start_and_end_of_sub_tree("10(11()[2]())[1](12()[2]())", level=0)
        self.assertIsNotNone(root_node)
        self.assertEqual(10, root_node.val)
        self.assertEqual(11, root_node.left.val)
        self.assertEqual(12, root_node.right.val)
        self.assertIsNone(root_node.left.left)
        self.assertIsNone(root_node.left.right)
        self.assertIsNone(root_node.right.left)
        self.assertIsNone(root_node.right.right)

    def test_node_creation_set2(self):
        root_node = find_start_and_end_of_sub_tree("10(11()[2](14()[3]()))[1](12()[2](13()[3]()))", level=0)
        self.assertIsNotNone(root_node)
        self.assertEqual(10, root_node.val)
        self.assertEqual(11, root_node.left.val)
        self.assertEqual(14, root_node.left.right.val)
        self.assertEqual(12, root_node.right.val)
        self.assertEqual(13, root_node.right.right.val)
        self.assertIsNone(root_node.left.left)
        self.assertIsNone(root_node.left.right.left)
        self.assertIsNone(root_node.left.right.right)
        self.assertIsNone(root_node.right.left)
        self.assertIsNone(root_node.right.right.left)
        self.assertIsNone(root_node.right.right.right)

    def test_codec_set1(self):
        root = TreeNode("10")
        root.left = TreeNode("11")
        root.left.right = TreeNode("14")
        root.right = TreeNode("12")
        root.right.right = TreeNode("13")
        solution = Codec()
        serialised_data = solution.serialize(root)
        self.assertEqual("10(11()[2](14()[3]()))[1](12()[2](13()[3]()))", serialised_data)
        root_node = solution.deserialize(data=serialised_data)
        self.assertEqual(10, root_node.val)
        self.assertEqual(11, root_node.left.val)
        self.assertEqual(14, root_node.left.right.val)
        self.assertEqual(12, root_node.right.val)
        self.assertEqual(13, root_node.right.right.val)
        self.assertIsNone(root_node.left.left)
        self.assertIsNone(root_node.left.right.left)
        self.assertIsNone(root_node.left.right.right)
        self.assertIsNone(root_node.right.left)
        self.assertIsNone(root_node.right.right.left)
        self.assertIsNone(root_node.right.right.right)

    def test_codec_set2(self):
        orig_node = TreeNode(10)
        codec = Codec()
        serialised_data = codec.serialize(root=orig_node)
        root_node = codec.deserialize(data=serialised_data)
        self.assertEqual(10, root_node.val)
        self.assertIsNone(root_node.left)
        self.assertIsNone(root_node.right)

    def test_code_set3(self):
        codec = Codec()
        serialised_data = codec.serialize(root = None)
        self.assertEqual("", serialised_data)
        self.assertIsNone(codec.deserialize(data=serialised_data))


