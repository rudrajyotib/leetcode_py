from unittest import TestCase

from medium.graph.clone_graph import Node, Solution


class TestSolution(TestCase):
    def test_should_clone_graph_set1(self):
        node1 = Node(val=1)
        node2 = Node(val=2)
        node3 = Node(val=3)
        node4 = Node(val=4)

        node1.neighbors.append(node2)
        node2.neighbors.append(node1)
        node2.neighbors.append(node3)
        node3.neighbors.append(node2)
        node3.neighbors.append(node4)
        node4.neighbors.append(node3)
        node4.neighbors.append(node1)
        node1.neighbors.append(node4)

        solution = Solution()
        cloned_node1 = solution.cloneGraph(node=node1)
        self.assertEqual(1, cloned_node1.val)
        self.assertEqual(2, len(cloned_node1.neighbors))
        self.assertEqual([2, 4], sorted(list(map(lambda x: x.val, cloned_node1.neighbors))))
        cloned_node2 = list(filter(lambda x: x.val == 2, cloned_node1.neighbors))[0]
        self.assertIsNotNone(cloned_node2)
        self.assertEqual(2, cloned_node2.val)
        self.assertEqual(2, len(cloned_node2.neighbors))
        self.assertEqual([1, 3], sorted(list(map(lambda x: x.val, cloned_node2.neighbors))))
        cloned_node3 = list(filter(lambda x: x.val == 3, cloned_node2.neighbors))[0]
        self.assertIsNotNone(cloned_node3)
        self.assertEqual(3, cloned_node3.val)
        self.assertEqual(2, len(cloned_node3.neighbors))
        self.assertEqual([2, 4], sorted(list(map(lambda x: x.val, cloned_node3.neighbors))))
        cloned_node4 = list(filter(lambda x: x.val == 4, cloned_node3.neighbors))[0]
        self.assertIsNotNone(cloned_node4)
        self.assertEqual(4, cloned_node4.val)
        self.assertEqual(2, len(cloned_node4.neighbors))
        self.assertEqual([1, 3], sorted(list(map(lambda x: x.val, cloned_node4.neighbors))))

    def test_should_clone_graph_set2(self):
        node1 = Node(val=1)
        node2 = Node(val=2)
        node3 = Node(val=3)
        node4 = Node(val=4)
        node5 = Node(val=5)

        node1.neighbors.append(node2)
        node2.neighbors.append(node1)
        node2.neighbors.append(node3)
        node3.neighbors.append(node2)
        node3.neighbors.append(node4)
        node4.neighbors.append(node3)
        node4.neighbors.append(node1)
        node1.neighbors.append(node4)
        node4.neighbors.append(node5)
        node5.neighbors.append(node4)

        solution = Solution()
        cloned_node1 = solution.cloneGraph(node=node1)
        self.assertEqual(1, cloned_node1.val)
        self.assertEqual(2, len(cloned_node1.neighbors))
        self.assertEqual([2, 4], sorted(list(map(lambda x: x.val, cloned_node1.neighbors))))
        cloned_node2 = list(filter(lambda x: x.val == 2, cloned_node1.neighbors))[0]
        self.assertIsNotNone(cloned_node2)
        self.assertEqual(2, cloned_node2.val)
        self.assertEqual(2, len(cloned_node2.neighbors))
        self.assertEqual([1, 3], sorted(list(map(lambda x: x.val, cloned_node2.neighbors))))
        cloned_node3 = list(filter(lambda x: x.val == 3, cloned_node2.neighbors))[0]
        self.assertIsNotNone(cloned_node3)
        self.assertEqual(3, cloned_node3.val)
        self.assertEqual(2, len(cloned_node3.neighbors))
        self.assertEqual([2, 4], sorted(list(map(lambda x: x.val, cloned_node3.neighbors))))
        cloned_node4 = list(filter(lambda x: x.val == 4, cloned_node3.neighbors))[0]
        self.assertIsNotNone(cloned_node4)
        self.assertEqual(4, cloned_node4.val)
        self.assertEqual(3, len(cloned_node4.neighbors))
        self.assertEqual([1, 3, 5], sorted(list(map(lambda x: x.val, cloned_node4.neighbors))))
        cloned_node5 = list(filter(lambda x: x.val == 5, cloned_node4.neighbors))[0]
        self.assertIsNotNone(cloned_node5)
        self.assertEqual(5, cloned_node5.val)
        self.assertEqual(1, len(cloned_node5.neighbors))
        self.assertEqual([4], sorted(list(map(lambda x: x.val, cloned_node5.neighbors))))
