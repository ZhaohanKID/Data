package org.Unit04.dataStructure.Queue;

import java.util.Scanner;

/**
 *  用数组来模拟队列。
 */

public class QueueDemo01 {
    public static void main(String[] args) {
        ArrQueue arrQueue = new ArrQueue(3);
        Scanner sc = new Scanner(System.in);
        wc:while (true) {
            System.out.println("---------------------");
            System.out.println("请选择您的操作：");
            System.out.println("f:查看是否已满");
            System.out.println("e:查看是否为空");
            System.out.println("a:添加数据");
            System.out.println("g:获取数据");
            System.out.println("s:查看队列所有数据");
            System.out.println("r:查看队列的头");
            System.out.println("t:退出");
            System.out.println("----------------------");

            char c = sc.next().charAt(0);

            switch (c) {
                case 'f':
                    boolean flag1 = arrQueue.isFull();
                    if (flag1) {
                        System.out.println("队列是满的");
                    } else {
                        System.out.println("队列没有满");
                    }
                    break;
                case 'e':
                    boolean flag2 = arrQueue.isEmpty();
                    if (flag2) {
                        System.out.println("队列是空的");
                    } else {
                        System.out.println("队列没有空");
                    }
                    break;
                case 'a':
                    System.out.println("请输入您要添加的数据：");
                    int num = sc.nextInt();
                    arrQueue.addQueue(num);
                    break;
                case 'g': // 取出数据的时候可能为空，所以要异常处理
                    try {
                        int res = arrQueue.getQueue();
                        System.out.printf("取出的数据是%d", res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 's':
                    arrQueue.showQueue();
                    break;
                case 'r':
                    try {
                        int res = arrQueue.getFront();
                        System.out.printf("取出的数据是%d", res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 't':
                    System.out.println("拜拜~");
                    break wc;
                default:
                    System.out.println("输入指令错误，请重新输入");
            }
        }
    }
}

// 使用数组模拟一个队列
class ArrQueue {
    private int maxSize; // 数组最大容量
    private int front; // 队列头
    private int rear; // 队列尾
    private int[] arr; // 存放数据

    // 构造方法
    public ArrQueue(int arrMaxSize) {
        maxSize = arrMaxSize;
        arr = new int[maxSize];
        front = -1; // 头位置，在头部位置的前一个位置。
        rear = -1; // 尾部位置，就是尾部所在的位置。
    }

    // 判断数组是否已经满了
    public boolean isFull() {
        return rear == maxSize - 1;
    }

    // 判断是否是空的
    public boolean isEmpty() {
        return rear == front;
    }

    // 添加数据
    public void addQueue(int n) {
        if (isFull()) {
            System.out.println("队列满，不能加数据");
            return;
        }
        rear++;
        arr[rear] = n;
    }

    // 取出数据
    public int getQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空，不能再取出数据");
        }
        front++;
        return arr[front];
    }

    // 显示队列的所有数据
    public void showQueue() {
        if (isEmpty()) {
            System.out.println("队列为空，没有数据");
        } else {
            for (int i = 0; i < arr.length; i++) {
                System.out.printf("arrQueue[%d] = %d\n", i, arr[i]);
            }
        }
    }

    // 显示队列的头
    public int getFront() {
        if (isEmpty()) {
            // throw 本身带有终止的作用，所以这里不用再return。
            throw new RuntimeException("队列为空，没有数据~~");
        }
        return arr[front + 1];
    }
}