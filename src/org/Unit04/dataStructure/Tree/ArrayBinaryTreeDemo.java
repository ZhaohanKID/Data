package org.Unit04.dataStructure.Tree;

/**
 *  数组存储二叉树，也就是将数据存储在数组里面，但是要求还能按照前序中序后序的方式遍历
 * @Author: Z.HAN
 * @Date: 2020/10/26 20:26
 */
public class ArrayBinaryTreeDemo {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        // 创建一棵树
        ArrayBinaryTree binaryTree = new ArrayBinaryTree(arr);
        // binaryTree.preOrder(0);
        binaryTree.preOrder();

        System.out.println();
        binaryTree.infixOrder();
        System.out.println();
        binaryTree.postOrder();
    }
}
class ArrayBinaryTree {
    private int[] arr;

    public ArrayBinaryTree(int[] arr) {
        this.arr = arr;
    }

    // 因为在主方法中调用时要传入一个参数0，我们可以通过方法重载的方式
    public void preOrder() {
        this.preOrder(0);
    }

    public void infixOrder() {
        this.infixOrder(0);
    }

    public void postOrder() {
        this.postOrder(0);
    }

    public void preOrder(int index) {
        if (arr == null || arr.length == 0) {
            System.out.println("数组为空，不能以前序遍历的方式输出数组");
        }
        // 前序遍历，输出当前节点
        System.out.print(arr[index] + " ");
        // 如果不越界，就以递归的方式向左遍历
        if (index * 2 + 1 < arr.length) {
            preOrder(index * 2 + 1);
        }
        // 向右递归遍历
        if (index * 2 + 2 < arr.length) {
            preOrder(index * 2 + 2);
        }
    }

    // 中序遍历
    public void infixOrder(int index) {
        if (arr == null || arr.length == 0) {
            System.out.println("空数组，不能通过中序遍历的方式输出该数组");
        }
        if (index * 2 + 1 < arr.length) {
            infixOrder(index * 2 + 1);
        }
        System.out.print(arr[index] + " ");
        if (index * 2 + 2 < arr.length) {
            infixOrder(index * 2 + 2);
        }
    }

    public void postOrder(int index) {
        if (arr == null || arr.length == 0) {
            System.out.println("空数组，不能通过后序遍历的方式输出该数组");
        }
        if (index * 2 + 1 < arr.length) {
            postOrder(index * 2 + 1);
        }
        if (index * 2 + 2 < arr.length) {
            postOrder(index * 2 + 2);
        }
        System.out.print(arr[index] + " ");
    }
}
