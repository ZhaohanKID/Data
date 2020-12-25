package org.Unit06.leecode;

import org.junit.Test;

/**
 * @ Author: Z.HAN
 * @ Date: 2020/12/22 21:52
 */
public class test10 {
    @Test
    public void t1() {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(2);
        ListNode l4 = new ListNode(3);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;

        ListNode listNode = new Solution10().deleteDuplication2(l1);
        System.out.println(listNode);
    }
}
class Solution10 {
    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        if (pNode == null) {
            return null;
        }
        // 有右子树，就找右子树的最左边的节点
        if (pNode.right != null) {
            pNode = pNode.right;
            while (pNode.left != null) {
                pNode = pNode.left;
            }
            return pNode;
        }
        while(pNode.next!=null){ //没右子树，则找第一个当前节点是父节点左孩子的节点
            if(pNode.next.left==pNode) return pNode.next;
            pNode = pNode.next;
        }
        return null;
    }

    public ListNode deleteDuplication(ListNode pHead) {
        ListNode head = pHead;
        ListNode curr = head;
        ListNode temp = null;
        while (curr.next != null) {
            temp = curr;
            while (temp.next != null) {
                if (temp.next.val == curr.val) {
                    temp.next = temp.next.next;
                }
                temp = temp.next;
            }
            curr = curr.next;
        }
        return head;
    }
    public ListNode deleteDuplication2(ListNode pHead) {
        ListNode head = pHead;
        ListNode curr = head;
        ListNode temp = null;
        while (curr.next != null) {
            temp = curr.next;
            while (temp.next != null) {
                if (curr.next.val == temp.next.val) {
                    temp.next = temp.next.next;
                    curr.next = curr.next.next;
                }
                temp = temp.next;
            }
            curr = curr.next;
        }
        return pHead;
    }

    public ListNode deleteDuplication3(ListNode pHead) {
        ListNode head  = new ListNode(0);
        head.next = pHead;
        ListNode curr = pHead;
        ListNode temp = null;
        while (curr.next != null) {
            temp = curr;
            while (temp.next != null) {
//                if (temp.next.val == curr)
            }
        }
        return pHead;
    }
}
class TreeLinkNode {
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null;

    TreeLinkNode(int val) {
        this.val = val;
    }
}
