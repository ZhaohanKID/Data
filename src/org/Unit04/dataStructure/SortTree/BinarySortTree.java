package org.Unit04.dataStructure.SortTree;

/**
 * 二叉排序树，或者叫二叉查找树
 * @Author: Z.HAN
 * @Date: 2020/10/28 12:53
 */
public class BinarySortTree {
    public static void main(String[] args) {
        int[] arr = {7, 3, 10, 12, 5, 1, 9};
        SortTree tree = new SortTree();
        for (int i = 0; i < arr.length; i++) {
            tree.add(new Node(arr[i]));
        }
        tree.add(new Node(2));

        tree.delNode(2);
        tree.delNode(5);
        tree.delNode(9);
        tree.delNode(12);
        tree.delNode(7);
        tree.delNode(3);
        tree.delNode(10);
        tree.delNode(1);

        System.out.println("root " + tree.getRoot());

        System.out.println("中序遍历二叉排序树：");
        tree.infixOrderList();
    }
}

// 创建一棵树
class SortTree {
    private Node root;

    public SortTree() {
    }

    public SortTree(Node root) {
        this.root = root;
    }

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    public void add(Node node) {
        if (root == null) {
            root = node; // 直接让 root 指向该节点
        } else {
            this.root.add(node);
        }
    }

    // 中序遍历
    public void infixOrderList() {
        if (root == null) {
            System.out.println("空树，无法遍历");
        } else {
            this.root.infixOrderList();
        }
    }

    public Node search(int value) {
        if (root == null) {
            return null;
        } else {
            return this.root.search(value);
        }
    }

    public Node searchParent(int value) {
        if (root == null) {
            return null;
        } else {
            return this.root.searchParent(value);
        }
    }

    // 找到最小节点的方法
    /*
        返回以node为根节点的二叉排序树的最小节点的值
        同时要删除这个最小的节点
     */
    public int delRightTreeMin(Node node) {
        Node target = node;// 临时变量
        while (target.left != null) {
            target = target.left;
        }
        // 这时target就指向了最小节点
        delNode(target.value);
        return target.value;
    }
    public int delLeftTreeMax(Node node) {
        Node target = node;
        while (target.right != null) {
            target = target.right;
        }
        delNode(target.value);
        return target.value;
    }

    // 删除节点
    public void delNode(int value) {
        if (root == null) {
            return;
        } else {
            // 目标节点
            Node targetNode = search(value);
            // 如果没有找到要删除的节点
            if (targetNode == null) {
                return;
            }
            // 如果发现当前二叉树只有一个节点
            if (this.root.left == null && this.root.right == null) {
                root = null;
                return;
            }
            // 去找父节点
            Node parentNode = searchParent(value);
            // 如果要删除的节点是叶子节点
            if (targetNode.left == null && targetNode.right == null) {
                if (parentNode.left != null && parentNode.left.value == value) {
                    parentNode.left = null;
                } else if (parentNode.right != null && parentNode.right.value == value) {
                    parentNode.right = null;
                }
            } else if (targetNode.left != null && targetNode.right != null) { // 删除有两个子节点的节点
                /*int minVal = delRightTreeMin(targetNode.right);
                targetNode.value = minVal;*/
                targetNode.value = delLeftTreeMax(targetNode.left);
                // 这里可以找右子树中最小的，也可以找左子树中最大的
            } else { // 剩下的就是有一个子节点的节点了
                if (targetNode.left != null) {
                    if (parentNode != null) {
                        if (parentNode.left.value == value) {
                            parentNode.left = targetNode.left;
                        } else {
                            parentNode.right = targetNode.left;
                        }
                    } else {
                        root = targetNode.left;
                    }
                } else {
                    if (parentNode != null) {
                        if (parentNode.left.value == value) {
                            parentNode.left = targetNode.right;
                        } else if (parentNode.right.value == value){
                            parentNode.right = targetNode.right;
                        }
                    } else {
                        root = targetNode.right;
                    }
                }
            }
        }

    }
}
class Node {
    int value;
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }

    public void add(Node node) {
        if (node.value < this.value) {
            if (this.left == null) {
                this.left = node;
            } else {
                // 递归向左添加
                this.left.add(node);
            }
        } else {
            if (this.right == null) {
                this.right = node;
            } else {
                this.right.add(node);
            }
        }
    }

    // 中序遍历
    public void infixOrderList() {
        if (this.left != null) {
            this.left.infixOrderList();
        }
        System.out.println(this);
        if (this.right != null) {
            this.right.infixOrderList();
        }
    }

    // 查找要删除的目标节点
    public Node search(int value) {
        if (this.value == value) {
            return this;
        } else if (value < this.value) {
            if (this.left != null) {
                return this.left.search(value);
            }
        } else {
            if (this.right != null) {
                return this.right.search(value);
            }
        }
        return null;
    }

    // 查找要删除节点的父节点
    public Node searchParent(int value) {
        if ((this.left != null && this.left.value == value) || (this.right != null && this.right.value == value)) {
            return this;
        } else {
            if (this.left != null && this.value > value) {
                return this.left.searchParent(value);
            }
            if (this.right != null && this.value < value) {
                return this.right.searchParent(value);
            } else {
                return null;
            }
        }
    }
}
