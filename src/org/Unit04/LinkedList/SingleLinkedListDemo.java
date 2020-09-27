package org.Unit04.LinkedList;

import java.util.Stack;

/**
 * @Author: Z.HAN
 * @Date: 2020/9/23 13:42
 */
public class SingleLinkedListDemo {
    public static void main(String[] args) {
        // 创建节点
        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
        HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");
        // 创建链表
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        /*singleLinkedList.add(hero1);
        singleLinkedList.add(hero2);
        singleLinkedList.add(hero3);
        singleLinkedList.add(hero4);*/

        singleLinkedList.addByOrder(hero1);
        singleLinkedList.addByOrder(hero4);
        singleLinkedList.addByOrder(hero2);
        singleLinkedList.addByOrder(hero3);

        singleLinkedList.show();

        // 获取节点个数
        //System.out.println(SingleLinkedList.getLength(singleLinkedList.getHead()));
        System.out.println("-----------------------------");

        // 逆序打印链表
        SingleLinkedList.reversePrint(singleLinkedList.getHead());
        System.out.println("-----------------------------");

        //
        SingleLinkedList.reverseList(singleLinkedList.getHead());
        singleLinkedList.show();

        // 反转链表
        /*SingleLinkedList.reverseList(singleLinkedList.getHead());
        singleLinkedList.show();
        System.out.println("==============================");*/

        // 获取倒数第K个节点
/*
        HeroNode result = SingleLinkedList.getNode(singleLinkedList.getHead(), 2);
        System.out.println(result);
        System.out.println("-----------------");

        // 测试修改节点的代码
        HeroNode newHeroNode = new HeroNode(2 ,"小卢俊义", "玉麒麟");
        singleLinkedList.update(newHeroNode);

        singleLinkedList.show();
        System.out.println("-------------------");

        // 删除一个节点
        singleLinkedList.delete(1);
        singleLinkedList.show();
        System.out.println("-------------------");
        singleLinkedList.delete(3);
        singleLinkedList.show();
*/
    }
}

// 定义这个类，管理我们的英雄。
class SingleLinkedList {
    // 先初始化一个头结点，头结点不要动，不存放具体的数据
    private HeroNode head = new HeroNode(0, "", "");

    // head是私有的，所以要提供一个公共的访问方式。
    public HeroNode getHead() {
        return head;
    }

    // 不考虑编号 ❥(^_-)
    // 找到当前链表的最后一个节点，将这个节点的next指向新的节点
    public void add(HeroNode heroNode) {
        // 中间变量，用来移动。
        HeroNode temp = head;
        while (true) {
            if (temp.next == null) {
                break;
            }
            // 如果没有找到最后，将temp后移。
            temp = temp.next;
        }
        // 当退出 while 循环的时候，temp指向的是链表的最后
        temp.next = heroNode;
    }

    // 第二种添加的方法，按照序号来添加。如果序号重复，则添加失败
    public void addByOrder(HeroNode heroNode) {
        // 因为头结点不能动，还是需要借助一个temp的辅助变量。
        // 因为是单链表，一定要找到比temp小的那一个编号，将该编号的next指向temp，将temp的next指向下一个，
        // 如果是双向链表，不存在该问题。
        HeroNode temp = head;
        boolean flag = false; // 标识要插入的编号是否已经存在，默认为false
        while (true) {
            // 说明temp已经在链表的最后。
            if (temp.next == null) {
                break;
            } else if (temp.next.no > heroNode.no) {// 找到添加位置，就在temp的后面
                break;
            } else if (temp.next.no == heroNode.no) { // 说明编号已经存在
                flag = true;
            }
            temp = temp.next; // 后移，遍历链表
        }
        if (flag) {
            System.out.println("希望加入的编号" + heroNode.no + "已经存在了！");
        } else {
            // 将要插入元素指向temp的下一个
            heroNode.next = temp.next;
            // 将temp指向要插入元素。
            temp.next = heroNode;
        }
    }

    // 修改数据
    /*
        根据节点的编号no来修改，也就是no不能修改。
     */
    public void update(HeroNode heroNode) {
        if (head.next == null) {
            System.out.println("链表为空~~");
            return;
        }
        HeroNode temp = head.next;
        boolean flag = false;
        while (true) {
            if (temp == null) {
                break;// 已经遍历结束了
            }
            if (temp.no == heroNode.no) {
                // 找到
                flag = true;
                break;
            }
            temp = temp.next;
        }
        // 退出循环的条件有两个，一个是找到后退出，另一个是遍历结束仍然没有找到也退出了。
        if (flag) {
            temp.name = heroNode.name;
            temp.nickName = heroNode.nickName;
        } else { // 没有找到
            System.out.println("没有找到编号为 " + heroNode.no + " 的节点，不能修改");
        }
    }

    // 删除节点
    public void delete(int no) {
        if (head.next == null) {
            System.out.println("链表为空，不能删除！");
        }
        HeroNode temp = head;
        boolean flag = false;
        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.next.no == no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.next = temp.next.next;
        } else {
            System.out.println("没有找到该节点~");
        }
    }

    // 为了测试，我们将链表显示出来，遍历
    public void show() {
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        // 上面判断head.next不为空，说明至少有一个节点。
        HeroNode temp = head.next;
        while (true) {
            if (temp == null) {
                break;
            }
            System.out.println(temp);
            // 这里要记得temp后移
            temp = temp.next;
        }
    }

    // 逆序打印单链表
    public static void reversePrint(HeroNode head) {
        if (head.next == null) {
            return;// 链表为空，不能打印
        }
        Stack<HeroNode> stack = new Stack<>();
        HeroNode cur = head.next;
        while (cur != null) {
            // 压栈
            stack.push(cur);
            cur = cur.next;
        }
        //弹栈
        while (stack.size() > 0) {
            System.out.println(stack.pop()); // pop就是用来出栈的。
        }
    }

    // 单链表的反转？？？？？？？非常不理解。
    public static void reverseList(HeroNode head) {
        // 若当前链表为空，或者只有一个节点，无需反转，直接返回
        if (head.next == null || head.next.next == null) {
            return;
        }
        HeroNode current = head.next;
        HeroNode next = null;
        HeroNode reverseHead = new HeroNode(0, "", "");
        // 遍历原来的链表，没遍历一个，就将其取出
        if (current != null) {// 等于null就是遍历到结尾了
            next = current.next;
            current.next = reverseHead.next;// 将current的下一个节点指向新的节点的最前端。????????此话怎讲？？？？？
            reverseHead.next = current;
            current = next;// current后移。
        }
        head.next = reverseHead.next;
    }

    // 获取倒数第index个节点
    public static HeroNode getNode(HeroNode heroNode, int index) {
        if (heroNode.next == null) {
            return null; // 没有找到
        }
        HeroNode temp = heroNode.next;
        int size = getLength(heroNode);
        if (index <= 0 || index > size) {
            return null;
        }
        for (int i = 0; i < size - index; i++) {
            temp = temp.next;
        }
        return temp;
    }


    // 获取链表节点个数，如果是带有头结点的链表，头结点要去掉
    /**
     *
     * @param head:头结点
     * @return 有效节点的个数
     */
    public static int getLength(HeroNode head) {
        if (head.next == null) { // 只有一个头结点
            return 0;
        }
        int length = 0;
        HeroNode current = head.next; // 这里我们没有算进去头结点。
        while (current != null) {
            length++;
            current = current.next; // 遍历。
        }
        return length;
    }
}

// 创建 HeroNode，每个HeroNode就是一个节点。
class HeroNode {
    public int no;
    public String name;
    public String nickName;
    public HeroNode next;

    public HeroNode(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}
