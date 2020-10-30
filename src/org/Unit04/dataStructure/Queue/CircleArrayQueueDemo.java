package org.Unit04.dataStructure.Queue;

import java.util.Scanner;

/**
 * @Author: Z.HAN
 * @Date: 2020/9/23 11:49
 */
public class CircleArrayQueueDemo {
    public static void main(String[] args) {
        // 设置数组长度为4，但是实际上有效长度只有3.因为预留了一个空间
        CircleArrQueue queue = new CircleArrQueue(4);
        Scanner sc = new Scanner(System.in);
        wc:while (true) {
            System.out.println("---------------------");
            System.out.println("请选择您的操作：");
            System.out.println("f:查看是否已满");
            System.out.println("e:查看是否为空");
            System.out.println("a:添加数据");
            System.out.println("g:获取数据");
            System.out.println("s:查看队列所有数据");
            System.out.println("h:查看队列的头");
            System.out.println("t:退出");
            System.out.println("----------------------");

            char c = sc.next().charAt(0);

            switch (c) {
                case 'f':
                    boolean flag1 = queue.isFull();
                    if (flag1) {
                        System.out.println("队列是满的");
                    } else {
                        System.out.println("队列没有满");
                    }
                    break;
                case 'e':
                    boolean flag2 = queue.isEmpty();
                    if (flag2) {
                        System.out.println("队列是空的");
                    } else {
                        System.out.println("队列没有空");
                    }
                    break;
                case 'a':
                    System.out.println("请输入您要添加的数据：");
                    int num = sc.nextInt();
                    queue.addQueue(num);
                    break;
                case 'g': // 取出数据的时候可能为空，所以要异常处理
                    try {
                        int res = queue.getQueue();
                        System.out.printf("取出的数据是%d", res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 's':
                    queue.showQueue();
                    break;
                case 'h':
                    try {
                        int res = queue.headQueue();
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
class CircleArrQueue {
    private int maxSize;
    private int front;
    private int rear;
    private int[] arr;

    public CircleArrQueue(int max) {
        this.maxSize = max;
        arr = new int[maxSize];
    }

    // 判断是否已经满
    public boolean isFull() {
        return (rear + 1) % maxSize == front;
    }

    // 判断是否为空
    public boolean isEmpty() {
        return front == rear;
    }

    // 添加数据
    public void addQueue(int n) {
        if (isFull()) {
            System.out.println("队列已满，不能加数据");
        } else {
            arr[rear] = n;
            rear = (rear + 1) % maxSize;
        }

    }

    // 获取数据
    public int getQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列是空的，没有数据");
        }
        /*
            front 是指向队列的第一个元素
            1. 先把 front 对应的值保留到一个临时变量
            2. 将 front 后移，考虑取模
            3. 将临时保存的变量返回
         */
        int value = arr[front];
        front = (front + 1) % maxSize;
        return value;
    }

    // 展示所有数据
    public void showQueue() {
        if (isEmpty()) {
            System.out.println("队列是空的，没有数据");
            return;
        }
        for (int i = front; i < front + size(); i++) {
            System.out.printf("arr[%d] = %d\n", i % maxSize, arr[i % maxSize]);
        }
    }

    // 获取当前有效数据的个数
    public int size() {
        return (rear + maxSize - front) % maxSize;
    }

    // 获取数据的头
    public int headQueue() {
        if (isEmpty()) {
            // throw 本身带有终止的作用，所以这里不用再return。
            throw new RuntimeException("队列为空，没有数据~~");
        }
        return arr[front];
    }
}

