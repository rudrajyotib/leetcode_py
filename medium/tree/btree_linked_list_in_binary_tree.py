import collections


class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    result: bool

    def isSubPath(self, head: ListNode, root: TreeNode) -> bool:

        # Solution.result = False

        def traverse_depth_first(node: TreeNode, link_node: ListNode) -> bool:
            if link_node is None:
                return True
            if node is None:
                return False
            if node.val == link_node.val:
                return traverse_depth_first(node=node.left, link_node=link_node.next) \
                       or traverse_depth_first(node=node.right, link_node=link_node.next)

        # def traverse_depth_first(node: TreeNode, link_node: ListNode):
        #     if link_node is None:
        #         Solution.result = True
        #         return
        #     if Solution.result:
        #         return
        #     if node is None:
        #         return
        #     if node.val == link_node.val:
        #         traverse_depth_first(node=node.left, link_node=link_node.next)
        #         traverse_depth_first(node=node.right, link_node=link_node.next)
        #     if node.val == head.val:
        #         traverse_depth_first(node=node.left, link_node=head.next)
        #         traverse_depth_first(node=node.right, link_node=head.next)
        #     else:
        #         traverse_depth_first(node=node.left, link_node=head)
        #         traverse_depth_first(node=node.right, link_node=head)

        queue = collections.deque()
        queue.append(root)
        while len(queue) > 0:
            node: TreeNode = queue.popleft()
            if node.val == head.val and traverse_depth_first(node=node, link_node=head):
                return True
            if node.left:
                queue.append(node.left)
            if node.right:
                queue.append(node.right)

        return False
