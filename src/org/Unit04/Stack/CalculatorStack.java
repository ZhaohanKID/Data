package org.Unit04.Stack;

/**
 * @Author: Z.HAN
 * @Date: 2020/10/23 13:36
 */
public class CalculatorStack {
    public static void main(String[] args) {
        String expression = "20+3*3-3";
        ArrayToStack numStack = new ArrayToStack(10);
        ArrayToStack operStack = new ArrayToStack(10);
        int index = 0;
        int num1 = 0;
        int num2 = 0;
        int oper = 0;
        int res = 0;
        char ch = ' ';
        String keepNum = "";
        // 开始扫描 expression
        while (true) {
            // 依次得到每一个字符
            ch = expression.substring(index, index + 1).charAt(0);
            if (operStack.isOper(ch)) {
                // 如果符号栈有操作符，就进行比较，如果当前的操作符的优先级小于或等于栈中的操作符，
                // 就需要从栈中 pop 出两个数，再从符号栈中pop出一个符号，进行运算，并将得到的结果，
                // 入数栈，然后将当前的操作符入符号栈
                if (!operStack.isEmpty()) {
                    if (operStack.priority(ch) <= operStack.priority(operStack.peek())) {
                        num1 = numStack.pop();
                        num2 = numStack.pop();
                        oper = operStack.pop();
                        res = numStack.cal(num1, num2, oper);
                        numStack.push(res);
                        // 将当前操作符入符号栈
                        operStack.push(ch);
                    } else {
                        operStack.push(ch);
                    }
                } else {
                    // 如果为空 直接入栈
                    operStack.push(ch);
                }
            } else {
                keepNum += ch;
                if (index == expression.length() - 1) {
                    numStack.push(Integer.parseInt(keepNum));
                } else {
                    if (operStack.isOper(expression.substring(index + 1, index + 2).charAt(0))) {
                        numStack.push(Integer.parseInt(keepNum));
                        keepNum = "";
                    }
                }

            }
            index++;
            if (index >= expression.length()) {
                break;
            }
        }
        // 当扫描结束，就顺序的从栈中弹出数据进行计算
        while (true) {
            // 如果符号栈为空，说明取数字到底了
            if (operStack.isEmpty()) {
                break;
            }
            num1 = numStack.pop();
            num2 = numStack.pop();
            oper = operStack.pop();
            res = numStack.cal(num1, num2, oper);
            numStack.push(res);
        }
        System.out.println("表达式：" + expression + " = " + numStack.pop());
    }
}
class ArrayToStack {
    private int maxSize; //
    private int[] stack; // 数组模拟栈，数据就存放在该数组
    private int top = -1; // 栈顶

    public ArrayToStack(int maxSize) {
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
    // 返回运算符的优先级
    public int priority(int oper) {
        if (oper == '*' || oper == '/') {
            return 1;
        } else if (oper == '+' || oper == '-') {
            return 0;
        } else {
            return -1;
        }
    }
    // 判断是不是一个运算符
    public boolean isOper(char ch) {
        return ch == '+' || ch == '-' || ch == '*' || ch == '/';
    }
    // 计算的方法
    public int cal(int num1, int num2, int oper) {
        int res = 0; // res 用于存放计算的结果
        switch (oper) {
            case '+':
                res = num1 + num2;
                break;
            case '-':
                res = num2 - num1;
                break;
            case '*':
                res = num1 * num2;
                break;
            case '/':
                res = num2 / num1;
                break;
            default:
                break;
        }
        return res;
    }
    // 查看最 top 的符号
    public int peek() {
        return stack[top];
    }
}
