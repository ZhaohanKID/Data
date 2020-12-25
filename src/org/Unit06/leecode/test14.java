package org.Unit06.leecode;

import java.util.Stack;

/**
 * @ Author: Z.HAN
 * @ Date: 2020/12/24 13:04
 */
public class test14 {
    public static void main(String[] args) {

    }
}

class Solution {

    TreeNode KthNode(TreeNode pRoot, int k) {
        // 注意，这里的二叉搜索树进行中序遍历得到的恰好就是排好序的
        int count = 0;
        if (pRoot == null || k == 0) {
            return null;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = pRoot;
        while (node != null || !stack.isEmpty()) {
            if (node != null) {
                stack.push(node);
                node = node.left;
            }
            stack.pop();
        }
    }

    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        if (pNode == null) {
            return null;
        }

        // 如果有右子树。就找右子树的最左节点
        if (pNode.right != null) {
            pNode = pNode.right;
            while (pNode.left != null) {
                pNode = pNode.left;
            }
            return pNode;
        }

        // 找第一个当前节点是父亲左孩子的节点。
        while (pNode.next != null) {
            if (pNode.next.left == pNode) {
                return pNode.next;
            }
            pNode = pNode.next;
        }

        return null;
        /* // 叶子节点
        if (pNode.left.next == null) {
            return pNode;
        }*/
    }
}