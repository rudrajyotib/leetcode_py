class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    last_known_node = None
    anomalies: [TreeNode] = []
    first_detection_of_anomaly = None

    def recoverTree(self, root: TreeNode) -> None:

        Solution.last_known_node = None
        Solution.anomalies = []
        Solution.first_detection_of_anomaly = None

        def identify_anomaly(node: TreeNode):
            if node is None:
                return
            if node.left:
                identify_anomaly(node.left)
            if Solution.last_known_node is None:
                Solution.last_known_node = node
            elif Solution.last_known_node.val > node.val:
                if len(Solution.anomalies) == 0:
                    Solution.anomalies.append(Solution.last_known_node)
                    Solution.first_detection_of_anomaly = node
                else:
                    Solution.anomalies.append(node)
                    Solution.first_detection_of_anomaly = None
                Solution.last_known_node = node
            else:
                Solution.last_known_node = node
            if node.right:
                identify_anomaly(node.right)

        identify_anomaly(root)

        if len(Solution.anomalies) == 2:
            tmp = Solution.anomalies[0].val
            Solution.anomalies[0].val = Solution.anomalies[1].val
            Solution.anomalies[1].val = tmp
        elif len(Solution.anomalies) == 1:
            tmp = Solution.anomalies[0].val
            # noinspection PyUnresolvedReferences
            Solution.anomalies[0].val = Solution.first_detection_of_anomaly.val
            Solution.first_detection_of_anomaly.val = tmp
