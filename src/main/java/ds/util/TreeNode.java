package ds.util;


public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(int x) { val = x; }
    public TreeNode(int x, TreeNode left, TreeNode right){
        this.val = x;
        this.left = left;
        this.right = right;
    }
    public String inOrder(){
        return inOrderRecursive(this);
    }

    private String inOrderRecursive(TreeNode treeNode){
        if (treeNode == null){
            return "";
        }
        return String.format("%s%s%s",inOrderRecursive(treeNode.left), treeNode.val , inOrderRecursive(treeNode.right));
    }

    public boolean isBalanced() {
        return checkIsBalancedRecursive(this) != -1;
    }

    private int checkIsBalancedRecursive(TreeNode treeNode){
        if (treeNode == null){
            return 0;
        }
        int leftHeight = checkIsBalancedRecursive(treeNode.left);
        int rightHeight = checkIsBalancedRecursive(treeNode.right);
        if (leftHeight == -1 || rightHeight == -1){
            return -1;
        }
        if (Math.abs(leftHeight-rightHeight) > 1){
            return -1;
        }
        return 1+Math.max(leftHeight, rightHeight);
    }
}
