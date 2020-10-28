package org.Unit04.Tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author: Z.HAN
 * @Date: 2020/10/27 13:28
 */
public class HuffmanTree {
    public static void main(String[] args) {
        int[] arr = {13, 7, 8, 29, 6, 1, 3};
        Node root = createHuffmanTree(arr);

        prefixOrderList(root);
        System.out.println("------------");
        root.prefixOrderList();
        // 这两个一样，相当于底下的那个没有判断是否是空树
    }

    // 前序遍历的方法
    public static void prefixOrderList(Node root) {
        if (root != null) {
            root.prefixOrderList();
        } else {
            System.out.println("空树，无法遍历");
        }
    }

    // 创建赫夫曼树的方法
    public static Node createHuffmanTree(int[] arr) {
        // 1 为了操作方便，
        /*
            1 遍历arr数组，将arr的每个元素构成一个Node
            2 将Node放入ArrayList中
         */
        List<Node> nodes = new ArrayList<>();
        for (int value : arr) {
            nodes.add(new Node(value));
        }
        // 排序，从小到大，跟底下重写的compareTo方法有关
        while (nodes.size() > 1) {
            Collections.sort(nodes);

            System.out.println("nodes=" + nodes);


        /*
            取出权值最小的两棵二叉树
            也就是 取出权值最小和第二小的两个节点
         */
            Node leftNode = nodes.get(0);
            Node rightNode = nodes.get(1);

            // 构建一棵新的二叉树
            Node parent = new Node(leftNode.value + rightNode.value);
            parent.left = leftNode;
            parent.right = rightNode;

            // 从ArrayList中删除已经处理过的节点
            nodes.remove(leftNode);
            nodes.remove(rightNode);
            // 将新创建的二叉树加入到ArrayList中
            nodes.add(parent);

            System.out.println("第一次处理后的结果：" + nodes);
        }
        return nodes.get(0);
    }
}
class Node implements Comparable<Node> {
    int value;
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
    }

    // 前序遍历的方法
    public void prefixOrderList() {
        System.out.println(this);
        if (this.left != null) {
            this.left.prefixOrderList();
        }
        if (this.right != null) {
            this.right.prefixOrderList();
        }
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }

    @Override
    public int compareTo(Node o) {
        // 从小到大
        return this.value - o.value;
    }
}
