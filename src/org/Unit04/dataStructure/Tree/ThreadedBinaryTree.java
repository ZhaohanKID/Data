package org.Unit04.dataStructure.Tree;

/**
 *  线索化二叉树
 * @Author: Z.HAN
 * @Date: 2020/10/26 21:26
 */
public class ThreadedBinaryTree {
    public static void main(String[] args) {
        // 测试一把中序线索二叉树的功能
        UserNode root = new UserNode(1, "tom");
        UserNode node2 = new UserNode(3, "jack");
        UserNode node3 = new UserNode(6, "smith");
        UserNode node4 = new UserNode(8, "mary");
        UserNode node5 = new UserNode(10, "king");
        UserNode node6 = new UserNode(14, "dim");

        // 手动创建一个二叉树
        root.setLeft(node2);
        root.setRight(node3);
        node2.setLeft(node4);
        node2.setRight(node5);
        node3.setLeft(node6);

        UserTree userTree = new UserTree();
        userTree.setRoot(root);
        userTree.threadedNodes();

        UserNode leftNode = node5.getLeft();
        UserNode rightNode = node5.getRight();
        System.out.println("left:" + leftNode);
        System.out.println("right:" + rightNode);

        System.out.println("线索化遍历：");
        userTree.threadedList();
    }
}
// 创建一棵树，线索化的二叉树
class UserTree {
    private UserNode root;


    // 前驱结点
    private UserNode pre = null;

    public UserNode getNode() {
        return root;
    }

    public void setRoot(UserNode root) {
        this.root = root;
    }

    // 重载
    public void threadedNodes() {
        this.threadedNodes(root);
    }

    // 遍历线索化二叉树的方法
    public void threadedList() {
        // 定义一个变量，储存当前遍历的节点，从root开始
        UserNode node = root;
        while (node != null) {
            /*
                循环找到leftType == 1的节点，第一个找到的就是8节点
                后面随着遍历而变化，因为当leftType == 1时，说明该节点是按照线索化
                处理后的有效节点
             */
            while (node.getLeftType() == 0) {
                node = node.getLeft();
            }
            // 打印当前这个节点
            System.out.println(node);
            // 如果当前节点的右指针指向的是后继节点，就一直输出
            while (node.getRightType() ==  1) {
                // 获取当前节点的后继节点
                node = node.getRight();
                System.out.println(node);
            }
            // 替换这个遍历的节点
            node = node.getRight();
        }
    }

    public void threadedNodes(UserNode node) {
        if (node == null) {
            return;
        }
        // 1 先线索化左子树
        threadedNodes(node.getLeft());
        // 处理当前节点的前驱结点
        // 2 线索化该节点
        if (node.getLeft() == null) {
            // 让当前节点的左指针指向前驱结点
            node.setLeft(pre);
            // 修改当前节点的左指针类型，指向前驱结点
            node.setLeftType(1);
        }
        // 处理后继节点，好像明白啥意思了，
        /*
            你想想，如果已经给一个节点设置了前驱结点，那么这个前驱结点的后继节点一定不为空
            pre.getRight() == null一定不成立
         */
        if (pre != null && pre.getRight() == null) {
            pre.setRight(node);
            pre.setRightType(1);
        }
        // 每处理一个节点，让当前节点是下一个节点的前驱结点
        pre = node;
        // 3 线索化右子树
        threadedNodes(node.getRight());
    }

    // 前序遍历
    public void preOrderList() {
        if (this.root != null) {
            this.root.preOrderList();
        } else {
            System.out.println("空树，不能遍历");
        }
    }
    // 中序遍历
    public void infixOrderList() {
        if (this.root != null) {
            this.root.infixOrderList();
        } else {
            System.out.println("空树，无法遍历");
        }
    }
    // 后序遍历
    public void postOrderList() {
        if (this.root != null) {
            this.root.postOrder();
        } else {
            System.out.println("空树，无法遍历");
        }
    }
    // 删除一个节点
    public void deleteNode(int id) {
        if (root != null) {
            if (this.root.getId() == id) {
                this.root = null;
            } else {
                this.root.deleteNode(id);
            }
        } else {
            System.out.println("空树，不能删除");
        }
    }
    // 前序查找
    public UserNode preOrderSearch(int id) {
        if (this.root != null) {
            return this.root.preOrderSearch(id);
        } else {
            System.out.println("没有找到该节点");
            return null;
        }
    }

    // 中序查找
    public UserNode infixOrderSearch(int id) {
        if (this.root != null) {
            return this.root.infixOrderSearch(id);
        } else {
            return null;
        }
    }
    // 后序查找
    public UserNode postOrderSearch(int id) {
        if (this.root != null) {
            return this.root.postOrderSearch(id);
        } else {
            return null;
        }
    }
}

// 创建节点
class UserNode {
    private int id;
    private String name;
    private UserNode left;
    private UserNode right;

    /*
    规则：
        如果 leftType 是0，该节点指向左子树，如果是1，指向前驱结点
        如果 rightType 是0，该节点指向右子树，如果是1，指向后继节点
     */
    private int leftType;
    private int rightType;

    public UserNode(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UserNode getLeft() {
        return left;
    }

    public void setLeft(UserNode left) {
        this.left = left;
    }

    public UserNode getRight() {
        return right;
    }

    public void setRight(UserNode right) {
        this.right = right;
    }

    public int getLeftType() {
        return leftType;
    }

    public void setLeftType(int leftType) {
        this.leftType = leftType;
    }

    public int getRightType() {
        return rightType;
    }

    public void setRightType(int rightType) {
        this.rightType = rightType;
    }

    @Override
    public String toString() {
        return "UserNode{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    // 前序遍历
    public void preOrderList() {
        // 先遍历当前节点
        System.out.println(this);
        // 遍历左子节点
        if (this.left != null) {
            this.left.preOrderList();
        }
        if (this.right != null) {
            this.right.preOrderList();
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
    // 后序遍历
    public void postOrder() {
        if (this.left != null) {
            this.left.postOrder();
        }
        if (this.right != null) {
            this.right.postOrder();
        }
        System.out.println(this);
    }

    // 删除一个节点
    public void deleteNode(int id) {
        /*if (this.id == id) {
            想到根节点正好是要删除的节点，但是在节点处这个是无法删除的
            只能到创建树之后 才可以直接将该树置空
        }*/
        if (this.left != null && this.left.id == id) {
            this.left = null;
            return;
        }
        if (this.right != null && this.right.id == id) {
            this.right = null;
            return;
        }
        if (this.left != null) {
            this.left.deleteNode(id);
        }
        if (this.right != null) {
            this.right.deleteNode(id);
        }
    }
    // 前序查找
    public UserNode preOrderSearch(int id) {
        if (this.id == id) {
            return this;
        }
        UserNode resNode = null;
        if (this.left != null) {
            resNode =  this.left.preOrderSearch(id);
        }
        if (resNode != null) {
            return resNode;
        }
        if (this.right != null) {
            resNode = this.right.preOrderSearch(id);
        }
        return resNode;
    }

    // 中序查找
    public UserNode infixOrderSearch(int id) {
        UserNode resNode = null;
        if (this.left != null) {
            resNode = this.left.infixOrderSearch(id);
        }
        if (resNode != null) {
            return resNode;
        }
        if (this.id == id) {
            return this;
        }
        if (this.right != null) {
            resNode = this.right.infixOrderSearch(id);
        }
        return resNode;
    }
    // 后序查找
    public UserNode postOrderSearch(int id) {
        UserNode resNode = null;
        if (this.left != null) {
            resNode = this.left.infixOrderSearch(id);
        }
        if (resNode != null) {
            return resNode;
        }
        if (this.right != null) {
            resNode = this.right.infixOrderSearch(id);
        }
        if (resNode != null) {
            return resNode;
        }
        if (this.id == id) {
            return this;
        }
        return resNode;
    }
}
