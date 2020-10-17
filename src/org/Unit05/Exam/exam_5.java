package org.Unit05.Exam;


/**
 * @Author: Z.HAN
 * @Date: 2020/10/12 12:42
 */
public class exam_5 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6};
        Node head = new Node(arr);
        head = Solution.delete (head, 2);
        System.out.println(head.toString());

    }
}
class Solution {
    public static Node delete(Node head, int n) {
        if (head == null) {
            return head;
        }
        Node p = head;
        Node q = head;
        int count = 0;
        while (q.next != null) {
            count++;
            if (count <= n) {
                q = q.next;
            } else {
                q = q.next;
                p = p.next;
            }
        }
        if (head.next == null) {
            head = head.next;
        } else {
            p.next = p.next.next;
        }
        return head;
    }
}
class Node {
    int value;
    Node next;

    public Node(int value) {
        this.value = value;
    }
    public Node(int[] arr) {
        if (arr == null || arr.length == 0)
            throw new IllegalArgumentException("arr can to be empty");
        this.value = arr[0];
        Node cur = this;
        for (int i = 1; i < arr.length; i++) {
            cur.next = new Node(arr[i]);
            cur = cur.next;
        }
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        Node cur = this;
        while (cur != null) {
            res.append(cur.value + "->");
            cur = cur.next;
        }
        res.append("NULL");
        return res.toString();
    }
}