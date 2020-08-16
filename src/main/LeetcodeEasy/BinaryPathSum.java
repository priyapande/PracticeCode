package main.LeetcodeEasy;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class BinaryPathSum {

    List<String> paths = new ArrayList<>();

    public int sumRootToLeaf(TreeNode root) {
        formPathString(root, new StringBuilder());
        int sum = 0;
        for (String str : paths) {
            char[] arr = str.toCharArray();
            int num = 0;
            int j = 0;
            for (int i = arr.length - 1; i >= 0; i--) {
                int val = arr[i] == '1' ? 1 : 0;
                num = num + ((int) Math.pow(2, j) * val);
                j++;
            }
            sum = sum + num;
        }
        return sum;
    }

    private void formPathString(TreeNode root, StringBuilder sb) {
        if (root == null) {
            paths.add(sb.toString());
            return;
        }
        sb.append(root.val);
        formPathString(root.left, new StringBuilder(sb.toString()));
        formPathString(root.right, new StringBuilder(sb.toString()));
    }

    @Test
    public void shouldSumRootToLeafPaths() {
        TreeNode t = new TreeNode(1, null, null);
        TreeNode t1 = new TreeNode(0, null, null);
        TreeNode t2 = new TreeNode(1, null, null);
        t.left = t1; t.right = t2;
        TreeNode t3 = new TreeNode(0, null, null);
        TreeNode t4 = new TreeNode(1, null, null);
        t1.left = t3; t1.right = t4;
        t2.left = t3; t2.right = t4;
        System.out.println(sumRootToLeaf(t));
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}