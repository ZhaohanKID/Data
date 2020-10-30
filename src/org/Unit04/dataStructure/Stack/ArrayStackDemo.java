package org.Unit04.dataStructure.Stack;

import java.util.Scanner;

/**
 *  用数组模拟栈的操作
 * @Author: Z.HAN
 * @Date: 2020/10/22 13:22
 */
public class ArrayStackDemo {
    public static void main(String[] args) {
        ArrayStack as = new ArrayStack(4);
        String key = "";
        Scanner sc = new Scanner(System.in);
        boolean flag = true;
        while (flag) {
            System.out.println("show：表示显示栈");
            System.out.println("exit：退出程序");
            System.out.println("push：添加数据");
            System.out.println("pop：弹出数据");
            System.out.println("请输入你的选择：");
            key = sc.next();
            switch (key) {
                case "show":
                    as.list();
                    break;
                case "exit":
                    sc.close();
                    flag = false;
                    break;
                case "push":
                    System.out.println("请输入一个数字：");
                    int value = sc.nextInt();
                    as.push(value);
                    break;
                case "pop":
                    try {
                        System.out.println(as.pop());
                    } catch (RuntimeException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                default:
                    break;
            }
        }
        System.out.println("程序退出");
    }
}
class ArrayStack {
    private int maxSize; //
    private int[] stack; // 数组模拟栈，数据就存放在该数组
    private int top = -1; // 栈顶

    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[this.maxSize]; // 数组要初始化才能往里面存数据
    }

    // 栈满
    public boolean isFull() {
        return top == maxSize - 1;
    }
    // 栈空
    public boolean isEmpty() {
        return top == -1;
    }
    // 入栈
    public void push(int value) {
        // 先判断栈是否满
        if (isFull()) {
            System.out.println("栈满");
            return;
        }
        top++;
        stack[top] = value;
    }
    // 出栈
    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("栈空");
        }
        int temp = stack[top];
        top--;
        return temp;
    }
    // 遍历栈
    public void list() {
        if (isEmpty()) {
            System.out.println("栈空，没有数据");
        }
        // 从栈顶开始取数据
        for (int i = top; i >= 0; i--) {
            System.out.printf("stack[%d] = %d\n", i, stack[i]);
        }
    }
}
