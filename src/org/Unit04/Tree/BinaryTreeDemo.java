package org.Unit04.Tree;

/**
 *
 *  二叉树
 * @Author: Z.HAN
 * @Date: 2020/10/25 19:26
 */
public class BinaryTreeDemo {
    public static void main(String[] args) {
        // 先创建一棵二叉树
        BinaryTree tree = new BinaryTree();
        // 创建需要的节点
        HeroNode node1 = new HeroNode(1, "宋江");
        HeroNode node2 = new HeroNode(2, "吴用");
        HeroNode node3 = new HeroNode(3, "卢俊义");
        HeroNode node4 = new HeroNode(4, "林冲");
        HeroNode node5 = new HeroNode(5, "关胜");

        // 说明：我们先手动创建该二叉树
        node1.setLeft(node2);
        node1.setRight(node3);
        node3.setRight(node4);
        node3.setLeft(node5);
        tree.setRoot(node1);
        // 前序遍历
        System.out.println("前序遍历：");
        tree.preOrder();

        // tree.delNode(5);
        tree.delNode(3);  
        System.out.println("删除后：");
        tree.preOrder();

        /*System.out.println("中序遍历：");
        tree.infixOrder();

        System.out.println("后序遍历：");
        tree.postOrder();

        // 前序查找
        HeroNode resNode = tree.preOrderSearch(5);
        if (resNode != null) {
            System.out.println("前序查找找到了，信息为：no = " + resNode.getNo() + "，name = " + resNode.getName());
        } else {
            System.out.println("没有找到id为" + resNode.getNo() + "英雄");
        }

        HeroNode resNode2 = tree.infixOrderSearch(5);
        if (resNode2 != null) {
            System.out.println("前序查找找到了，信息为：no = " + resNode2.getNo() + "，name = " + resNode2.getName());
        } else {
            System.out.println("没有找到id为" + resNode2.getNo() + "英雄");
        }

        HeroNode resNode3 = tree.postOrderSearch(5);
        if (resNode3 != null) {
            System.out.println("前序查找找到了，信息为：no = " + resNode3.getNo() + "，name = " + resNode3.getName());
        } else { // 下面这一行使用resNode3.getNo()是错的，因为如果既然else了，说明resNode3为空，你再getNo()就会报空指针异常
            System.out.println("没有找到id为" + resNode3.getNo() + "的英雄");
        }*/
    }
}

// 定义一个binaryTree
class BinaryTree {
    private HeroNode root;

    public void setRoot(HeroNode root) {
        this.root = root;
    }
    /*
        root != null
        如果当前树中的根节点不为空，就进行遍历
     */
    // 前序遍历
    public void preOrder() {
        if (this.root != null) {
            this.root.preOrder();
        } else {
            System.out.println("二叉树为空，无法遍历");
        }
    }
    // 中序遍历
    public void infixOrder() {
        if (this.root != null) {
            this.root.infixOrder();
        } else {
            System.out.println("二叉树为空，无法遍历");
        }
    }
    // 后序遍历
    public void postOrder() {
        if (this.root != null) {
            this.root.postOrder();
        } else {
            System.out.println("二叉树为空，无法遍历");
        }
    }

    // 前序查找
    public HeroNode preOrderSearch(int no) {
        if (this.root != null) {
            return this.root.preOrderSearch(no);
        } else {
            return null;
        }
    }
    // 中序查找
    public HeroNode infixOrderSearch(int no) {
        if (this.root != null) {
            return this.root.infixOrderSearch(no);
        } else {
            return null;
        }
    }
    // 后序查找
    public HeroNode postOrderSearch(int no) {
        if (this.root != null) {
            return this.root.postOrderSearch(no);
        } else {
            return null;
        }
    }

    // 删除节点
    /*
        理解：如果删除的节点是一个子节点，也是一个父节点，
        则这个节点的父节点直接将该节点的全部内容都删除掉了
        也就是 父节点.left = 该节点  或者  父节点.right = 该节点
        父节点.left = null，置空，也就是该子树空了
        也就是删除了整棵树
     */
    public void delNode(int no) {
        if (root != null) {
            // 判断root是不是要删除的节点，如果是，直接将该树置空
            if (root.getNo() == no) {
                root = null;
            } else {
                // 递归删除
                root.delNode(no);
            }
        } else {
            System.out.println("空树，不能删除");
        }
    }
}

// 创建 HeroNode 节点
class HeroNode {
    private int no;
    private String name;
    private HeroNode left; // 默认null
    private HeroNode right; // 默认null

    public HeroNode(int no, String name) {
        this.no = no;
        this.name = name;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HeroNode getLeft() {
        return left;
    }

    public void setLeft(HeroNode left) {
        this.left = left;
    }

    public HeroNode getRight() {
        return right;
    }

    public void setRight(HeroNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }

    // 递归删除节点
    /*
        1. 如果删除的节点是叶子节点，则删除该节点
        2. 如果删除的节点是非叶子节点，则删除该子树
     */
    public void delNode(int no) {
        if (this.left != null && this.left.no == no) {
            this.left = null;
            return;
        }
        if (this.right != null && this.right.no == no) {
            this.right = null;
            return;
        }
        // 上面得左右子树都没有删除成功，应该继续递归调用子树的子树
        if (this.left != null) {
            this.left.delNode(no);
        }
        /*
            理解：当删除到吴用时，前面两个if都没有进去，
            进入第三个if，
            开始递归，再次到前两个判断，还是不进去，
            这时后两个也不进去了，等于这个方法执行完毕，
            跳到该段代码的结尾
            跳回到执行递归前面的位置，也就是第三个if之后，
            开始判断第四个if，还是递归，重复以上过程
         */
        if (this.right != null) {
            this.right.delNode(no);
        }
    }

    /*
        需求：
        1 如果要删除的节点是非叶子节点，现在我们不希望将该非叶子节点为根节点的子树删除，
        规则：如果该非叶子节点只有一个子节点，则子节点替代该节点
        如果该节点A有子节点B和C，则让左子节点B替代A，
     */
    public void delSomeNode(int no) {
        if (!((this.left != null) && (this.right != null))) {
            
        }
    }



    // 前序遍历
    public void preOrder() {
        System.out.println(this); // 先输出父节点
        // 递归向左子树遍历
        if (this.left != null) {
            this.left.preOrder();
        }
        // 递归向右子树遍历
        if (this.right != null) {
            this.right.preOrder();
        }
    }
    // 中序遍历
    public void infixOrder() {
        // 先递归向左子树进行中序遍历
        if (this.left != null) {
            this.left.infixOrder();
        }
        // 输出父节点
        System.out.println(this);
        // 递归向右子树遍历
        if (this.right != null) {
            this.right.infixOrder();
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

    // 前序查找
    public HeroNode preOrderSearch(int no) {
        System.out.println("进入前序查找");
        if (this.no == no) {
            return this;
        }
        HeroNode resNode = null;
        if (this.left != null) {
            resNode = this.left.preOrderSearch(no);
        }
        if (resNode != null) {
            return resNode;
        }
        if (this.right != null) {
            resNode = this.right.preOrderSearch(no);
        }
        return resNode;
    }

    // 中序遍历
    public HeroNode infixOrderSearch(int no) {
        HeroNode resNode = null;
        if (this.left != null) {
            resNode = this.left.infixOrderSearch(no);
        }
        if (resNode != null) {
            return resNode;
        }
        System.out.println("进入中序查找");
        if (this.no == no) {
            return this;
        }
        if (this.right != null) {
            resNode = this.right.infixOrderSearch(no);
        }
        return resNode;
    }

    // 后序遍历
    public HeroNode postOrderSearch(int no) {
        HeroNode resNode = null;
        if (this.left != null) {
            resNode = this.left.postOrderSearch(no);
        }
        if (resNode != null) {
            return resNode; // 因为还要进行后续的查找，所以只有它不为空的时候才要返回这个节点(结束)
        }
        if (this.right != null) {
            resNode = this.right.postOrderSearch(no);
        }
        if (resNode != null) {
            return resNode; // 因为还要进行后续的查找，所以只有它不为空的时候才要返回这个节点(结束)
        }

        System.out.println("进入后序查找");
        if (this.no == no) {
            return this;
        }
        return resNode; // 如果在上面this.no == no这个判断中没有return(结束)，说明没有找到，返回resNode为空
    }
}
