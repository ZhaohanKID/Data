package org.Unit04.AVL;


/**
 * 平衡二叉树
 * @Author: Z.HAN
 * @Date: 2020/10/28 14:49
 */
public class AVLTreeDemo {
    public static void main(String[] args) {
//        int[] arr = {4, 3, 6, 5, 7, 8};
//        int[] arr = {10, 12, 8, 9, 7, 6};
        int[] arr = {10, 11, 7, 6, 8, 9};
        AVLTree tree = new AVLTree();
        for (int i = 0; i < arr.length; i++) {
            tree.add(new Node(arr[i]));
        }
        System.out.println("中序遍历：");
        tree.infixOrderList();

        System.out.println("(平衡处理)旋转之后：");
        System.out.println("树的高度=" + tree.getRoot().height());
        System.out.println("左子树的高度=" + tree.getRoot().leftHeight());
        System.out.println("右子树的高度=" + tree.getRoot().rightHeight());
        System.out.println("root=" + tree.getRoot());
        System.out.println("根节点的左子节点=" + tree.getRoot().right.right);
    }
}
class AVLTree {
    private Node root;

    public AVLTree() {
    }

    public AVLTree(Node root) {
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
        // 当添加一个节点后，右子树的高度-左子树的高度 > 1，左旋转
        /*
            旋转规则：
         */
        if (this.rightHeight() - this.leftHeight() > 1) {
            if (this.right != null && right.leftHeight() > right.rightHeight()) {
                this.right.rightRotate();
                this.leftRotate();
            } else {
                this.leftRotate();// 左旋转。。。
            }
            return; // 必须要，防止再进入到下面的判断，又打乱了树
        }
        if (this.leftHeight() - this.rightHeight() > 1) {
            if (this.left != null && left.rightHeight() > left.leftHeight()) {
                // 先对左子节点进行左旋转
                this.left.leftRotate();
                // 在对当前节点进行右旋转
                this.rightRotate();
            } else {
                this.rightRotate();// 直接进行右旋转。。。
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

    // 返回左子树的高度
    public int leftHeight() {
        if (left == null) {
            return 0;
        }
        return left.height();
    }
    // 返回右子树的高度
    public int rightHeight() {
        if (right == null) {
            return 0;
        }
        return right.height();
    }

    // 返回以该节点为根节点的树的高度
    /*
        why????自己会++吗？？？？还是递归哪里没有理解
     */
    public int height() {
        return Math.max(left == null ? 0 : left.height() , right == null ? 0 : right.height()) + 1;
    }

    // 左旋转的方法
    private void leftRotate() {
        //1. 创建一个新的节点，值等于当前根节点的值
        Node newNode = new Node(this.value);
        //2. 把新节点的左子树设置为当前根节点的左子树
        newNode.left = this.left;
        //3. 把新节点的右子树设置为当前根节点的右子树的左子树
        newNode.right = this.right.left;
        //4. 把当前节点的值换为右子节点的值
        this.value = this.right.value;
        //5. 把当前节点的右子树设置成右子树的右子树
        this.right = this.right.right;
        //6. 把当前节点的左子树设置成新节点
        this.left = newNode;
    }

    private void rightRotate() {
        Node newNode = new Node(this.value);
        newNode.right = this.right;
        newNode.left = this.left.right;
        this.value = this.left.value;
        this.left = this.left.left;
        this.right = newNode;
    }
}
