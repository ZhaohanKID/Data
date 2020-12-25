package org.Unit06.leecode;

import java.util.Arrays;

/**
 * @ Author: Z.HAN
 * @ Date: 2020/12/24 11:23
 */
public class test13 {
    public static void main(String[] args) {
        int[] pre = {1,2,3,4,5,6,7};
        int[] in = {3,2,4,1,6,5,7};
        TreeNode treeNode = new Solution13().reConstructBinaryTree(pre, in);
        //System.out.println(treeNode.val);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution13 {

    public int TreeDepth(TreeNode root) {
        int leftCount = 0;
        int rightCount = 0;
        if (root == null) {
            return 0;
        } else if (root.left == null && root.right == null) {
            return 1;
        } else {
            if (root.left != null) {
                leftCount = TreeDepth(root.left);
            }
            if (root.right != null) {
                rightCount = TreeDepth(root.right);
            }
        }
        return leftCount > rightCount ? leftCount : rightCount;
    }

    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        if (pre.length == 0) {
            return null;
        }
        if (pre.length == 1) {
            System.out.println(pre[0]);
            return new TreeNode(pre[0]);
        }
        TreeNode root = new TreeNode(pre[0]); // 根节点
        int rootIndex = 0;
        for (int i = 0; i < in.length; i++) {
            if (in[i] == pre[0]) {
                rootIndex = i;
                break;
            }
        }
        root.left = reConstructBinaryTree(Arrays.copyOfRange(pre, 1, rootIndex + 1), Arrays.copyOfRange(in, 0, rootIndex));
        root.right = reConstructBinaryTree(Arrays.copyOfRange(pre, rootIndex + 1, pre.length), Arrays.copyOfRange(in, rootIndex + 1, in.length));
        return root;
    }
}
