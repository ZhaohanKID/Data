package org.Unit04.dataStructure.Stack;

import java.util.Scanner;

/**
 * @Author: Z.HAN
 * @Date: 2020/10/22 14:34
 */
public class LinkedListStackDemo {
    public static void main(String[] args) {
        LinkStack stack = new LinkStack();
        String key = "";
        Scanner sc = new Scanner(System.in);
        boolean flag = true;
        while (flag) {
            System.out.println("show：展示栈");
            System.out.println("push：入栈");
            System.out.println("pop：弹栈");
            System.out.println("exit：退出程序");
            key = sc.next();
            switch (key) {
                case "show":
                    stack.list();
                    break;
                case "push":
                    System.out.println("请输入一个数字：");
                    int value = sc.nextInt();
                    stack.push(value);
                    break;
                case "pop":
                    try {
                        System.out.println(stack.pop());
                    } catch (RuntimeException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "exit":
                    sc.close();
                    System.out.println("拜拜~");
                    flag = false;
                    break;
                default:
                    break;
            }
        }
    }
}
class Node {
    public int val;
    public Node next;

    public Node(int val) {
        this.val = val;
    }
}
class LinkStack {
    private Node head = new Node(0);
    public void push(int value) {
        Node node = new Node(value);

        Node cur = head.next;
        head.next = node;
        node.next = cur;
    }
    public int pop() {
        if (head.next == null) {
            throw new RuntimeException("栈空");
        }
        Node temp = head.next;
        head.next = head.next.next;
        return temp.val;
    }
    public void list() {
        if (head.next == null) {
            System.out.println("栈空，没有数据");
        }
        Node temp = head.next;
        while (temp != null) {
            System.out.println(temp.val);
            temp = temp.next;
        }
    }
}
