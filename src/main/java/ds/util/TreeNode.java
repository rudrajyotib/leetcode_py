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
}
