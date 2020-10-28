package org.Unit04.HashTable;

import java.util.Scanner;

/**
 * @Author: Z.HAN
 * @Date: 2020/10/25 13:10
 */
public class HashTableDemo {
    public static void main(String[] args) {
        // 创建哈希表
        HashTab hashTab = new HashTab(7);
        // 写一个简单的菜单
        String key = "";
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("add：添加雇员");
            System.out.println("list：显示雇员");
            System.out.println("find：查找雇员");
            System.out.println("exit：退出系统");

            key = sc.next();
            switch (key) {
                case "add":
                    System.out.println("输入id：");
                    int id = sc.nextInt();
                    System.out.println("输入姓名：");
                    String name = sc.next();
                    // 往哈希表中添加
                    hashTab.add(new Employee(id, name));
                    break;
                case "list":
                    hashTab.list();
                    break;
                case "find":
                    System.out.println("Please input the id that you want to find：");
                    id = sc.nextInt();
                    hashTab.findEmployeeById(id);
                    break; // 如果这里不写break，就会发生case穿透，执行exit，直接退出程序
                case "exit":
                    sc.close();
                    System.exit(0);
                default:
                    break;
            }
        }
    }
}
// 创建 HashTable ，管理多条链表
class HashTab {
    private int size;
    private EmpLinkedList[] empLinkedListArray;

    public HashTab(int size) {
        this.size = size;
        // 初始化 empLinkedListArray
        empLinkedListArray = new EmpLinkedList[size];
        // 这多条链表的外壳数组创建出来了，但是里面的链表并没有被初始化，会报空指针
        for (int i = 0; i < size; i++) {
            empLinkedListArray[i] = new EmpLinkedList();
        }
    }
    // 添加雇员
    public void add(Employee employee) {
        // 根据id，决定加到哪一条链表
        int empLinkedListNo = hashFun(employee.id);
        // 将 employee 添加到对应的链表
        empLinkedListArray[empLinkedListNo].add(employee);
    }
    // 遍历所有的链表，遍历哈希表
    public void list() {
        for (int i = 0; i < size; i++) {
            empLinkedListArray[i].list(i);
        }
    }

    // 根据输入的id，查找雇员
    public void findEmployeeById(int id) {
        // 用散列函数确定到哪条链表查找
        int empLinkedListNo = hashFun(id);
        Employee employee = empLinkedListArray[empLinkedListNo].findEmployeeById(id);
        if (employee != null) {
            System.out.println("在第" + empLinkedListNo + "条链表中找到了该雇员，其id是" + id);
        } else {
            System.out.println("Sorry, we do not find this employee in the HashTab !");
        }
    }

    // 编写散列函数，使用一个简单的取模法
    public int hashFun(int id) {
        return id % size;
    }
}


// 表示一个雇员
class Employee {
    public int id;
    public String name;
    public Employee next; // 指向下一个节点，默认为空

    public Employee(int id, String name) {
        // super(); // ???
        this.id = id;
        this.name = name;
    }
}

// 创建EmpLinkedList，表示链表
class EmpLinkedList {
    // 头指针，指向第一个Emp，因此我们这个链表的head是直接指向第一个雇员的
    private Employee head; // 默认为null

    // 添加雇员到链表
    public void add(Employee employee) {
        // 如果是添加第一个雇员
        if (head == null) {
            head = employee;
            return;
        }
        // 如果不是第一个雇员，则使用一个辅助的指针，帮助定位到最后
        Employee curEmp = head;
        while (true) {
            if (curEmp.next == null) {
                break;
            }
            curEmp = curEmp.next;
        }
        // 退出时curEmp就是链表的最后一个元素，直接将employee加入即可
        curEmp.next = employee;
    }

    // 遍历链表的雇员信息
    public void list(int no) {
        if (head == null) { // 说明当前链表为空
            System.out.println("第 " + no + " 条链表为空");
            return;
        }
        System.out.print("第 " + no + " 条链表的信息是：");
        Employee curEmp = head; // 辅助指针
        while (true) {
            System.out.printf("-> id=%d name=%s\t", curEmp.id, curEmp.name);
            if (curEmp.next == null) { // curEmp为最后一个节点
                break;
            }
            curEmp.next = curEmp; // 后移
        }
        System.out.println();
    }

    // 根据 id 查找雇员
    public Employee findEmployeeById(int id) {
        if (head == null) {
            System.out.println("链表为空");
            return null;
        }
        Employee curEmp = head;
        while (true) {
            if (curEmp.id == id) {
                break;
            }
            if (curEmp.next == null) { // 还没有结束，说明遍历完了该链表，但是没有找到
                curEmp = null;
                break;
            }
            curEmp = curEmp.next;
        }
        return curEmp;
    }

    // 删除功能
    public void deleteById(int id) {
        Employee curEmp = head;
        while (true) {
            if (curEmp.id == id) {

            }
        }
    }
}
