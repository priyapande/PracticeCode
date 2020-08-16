package main.algo;

public class TreePrint {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2); root.right = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(5);
        System.out.print(printTree(root).val);
    }

    public static TreeNode printTree(TreeNode root) {
        if(root==null) return null;
        if(root.left==null && root.right==null) return root;
        TreeNode l = printTree(root.left);
        TreeNode r = printTree(root.right);
        if(l!=null) System.out.print(l.val+" ");
        if(r!=null) System.out.print(r.val+" ");
        return root;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val) {
        this.val = val;
    }
}