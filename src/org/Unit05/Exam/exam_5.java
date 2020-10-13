package org.Unit05.Exam;


/**
 * @Author: Z.HAN
 * @Date: 2020/10/12 12:42
 */
public class exam_5 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int n = 2;
        Node node = new Node(arr);

    }
}
class Node {
    public int no;
    public Node next;

    private Node headNode = new Node(0);

    public Node(int no) {
        this.no = no;
    }
    public Node(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        this.no = arr[0];
        Node curr = this;
        for (int i = 0; i < arr.length; i++) {
            curr.next = new Node(arr[i]);
            curr.next = curr;
        }
    }
    public void delete(int index) {

        reverse(this.headNode);
        Node temp = headNode;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        temp.next = temp.next.next;
    }
    public static void reverse(Node head) {
        if (head.next == null || head.next.next == null) {
            return;
        }
        Node curr = head.next;
        Node next = null;
        Node reHead = new Node(0);
        while (curr != null) {
            next = curr.next;
            curr.next = reHead.next;
            reHead.next = next;
            curr = next;
        }
        head.next = reHead.next;
    }

    @Override
    public String toString() {
        return "Node{" +
                "no=" + no +
                ", next=" + next +
                '}';
    }
}
