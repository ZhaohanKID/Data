package org.Unit04.dataStructure.LinkedList;

/**
 * 双向链表
 * @Author: Z.HAN
 * @Date: 2020/9/24 21:12
 */
public class DoubleLinkedListDemo {
    public static void main(String[] args) {
        HeroNode2 heroNode1 = new HeroNode2(1, "任嘉伦", "Allen");
        HeroNode2 heroNode2 = new HeroNode2(2, "刘德华", "Andy");
        HeroNode2 heroNode3 = new HeroNode2(3, "陈伟霆", "William");
        HeroNode2 heroNode4 = new HeroNode2(4, "黄子韬", "Z.TAO");

        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();

        doubleLinkedList.add(heroNode1);
        doubleLinkedList.add(heroNode2);
        doubleLinkedList.add(heroNode3);
        doubleLinkedList.add(heroNode4);

        doubleLinkedList.list();

        doubleLinkedList.delete(1);
        doubleLinkedList.list();
    }
}

class DoubleLinkedList {
    HeroNode2 head = new HeroNode2(0, "", "");

    public HeroNode2 getHead() {
        return head;
    }

    // 遍历双向链表
    public void list() {
        if (head.next == null) {
            System.out.println("链表为空！");
            return;
        }
        HeroNode2 temp = head.next;
        while (true) {
            if (temp == null) {
                break;
            }
            System.out.println(temp);
            temp = temp.next;
        }
    }

    // 添加
    public void add(HeroNode2 heroNode2) {
        HeroNode2 temp = head;
        while (true) {
            if (temp.next == null) {
                break; // 找到最后了
            }
            temp = temp.next;
        }
        // 形成一个双向链表。
        temp.next = heroNode2;
        heroNode2.pre = temp;
    }

    // 删除
    public void delete(int no) {
        if (head.next == null) {
            System.out.println("链表为空，无法删除！");
            return;
        }
        HeroNode2 temp = head.next;
        boolean flag = false;
        while (true) {
            if (temp == null) {
                break; // 找到链表末尾了
            }
            if (temp.no == no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.pre.next = temp.next;
            if (temp.next != null) {
                temp.next.pre = temp.pre;
            } else {
                System.out.println("要删除的链表不在");
            }
        }
    }
}

class HeroNode2 {
    public int no;
    public String name;
    public String nickName;
    public HeroNode2 next;
    public HeroNode2 pre;

    public HeroNode2 (int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "HeroNode2{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}
