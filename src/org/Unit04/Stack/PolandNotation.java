package org.Unit04.Stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 *  逆波兰计算器
 * @Author: Z.HAN
 * @Date: 2020/10/23 15:46
 */
public class PolandNotation {
    public static void main(String[] args) {
        /*
            1 将4 * 5 - 8 + 60 + 8 / 2中的每一个字符取出来，放到List里面，方便后面扫描
            2 将 中缀表达式对应的List转化为后缀表达式对应的List
         */
        //String expression = "4*5-8+60+8/2";
        String expression = "1+((2+3)*4)-5";
        List<String> infixList = toInfixList(expression);
        System.out.println(infixList);
        List<String> suffixList =  toSuffixList(infixList);
        System.out.println(suffixList);

        System.out.println("计算结果=" + calculate(suffixList));

        System.out.println("-------------------------------------");

        // 4 * 5 - 8 + 60 + 8 / 2 后缀表达式： 4 5 * 8 - 60 + 8 2 / +
        String suffixExpression = "4 5 * 8 - 60 + 8 2 / +";
        //String suffixExpression = "30 4 + 5 * 6 -";
        List<String> list = getStringList(suffixExpression);
        System.out.println(list);

        int res = calculate(list);
        System.out.println("表达式：" + suffixExpression + " = " + res);
    }
    // 取出来放到 List 里面
    public static List<String> toInfixList(String s) {
        List<String> list = new ArrayList<>();
        String str = "";
        char c = 0;
        int index = 0;
        while (index < s.length()) {
            if ((c = s.charAt(index)) < 48 || (c = s.charAt(index)) > 57) {
                list.add(c + "");
                index++;
            } else {
                // 如果是数字，需要考虑多位数的问题
                while (index < s.length() && (c = s.charAt(index)) <= '9' && (c = s.charAt(index)) >= '0') {
                    str += c;
                    index++;
                }
                list.add(str);
                str = "";
            }
        }
        return list;
    }

    // 将中缀List转换成后缀List [4, *, 5, -, 8, +, 60, +, 8, /, 2]
    public static List<String> toSuffixList(List<String> ls) {
        Stack<String> stack = new Stack<>();
        List<String> list = new ArrayList<>();
        String s = "";
        for (int i = 0; i < ls.size(); i++) {
            s = ls.get(i);
            if (s.matches("\\d+")) {
                list.add(s);
            } else if (s.equals("(")) {
                stack.push(s);
            } else if (s.equals(")")) {
                while (!stack.peek().equals("(")) {
                    list.add(stack.pop());
                }
                stack.pop(); // 将 ( 弹出，消除小括号
            } else {
                while (stack.size() != 0 && Operation.getPriorityValue(s) <= Operation.getPriorityValue(stack.peek())) {
                    list.add(stack.pop());
                }
                stack.push(s);
            }
        }
        while (stack.size() != 0) {
            list.add(stack.pop());
        }
        return list;
    }

    public static List<String> getStringList(String suffixExpression) {
        String[] strings = suffixExpression.split(" ");
        List<String> list = new ArrayList<>();
        for (String string : strings) {
            list.add(string);
        }
        return list;
    }
    public static int calculate(List<String> list) {
        // 创建一个栈
        Stack<String> stack = new Stack<>();
        for (String item : list) {
            if (item.matches("\\d+")) { // 如果是数字
                stack.push(item);
            } else {
                // 如果是
                int num2 = Integer.parseInt(stack.pop());
                int num1 = Integer.parseInt(stack.pop());
                int res = 0;
                if (item.equals("+")) {
                    res = num1 + num2;
                } else if (item.equals("-")) {
                    res = num1 - num2;
                } else if (item.equals("*")) {
                    res = num1 * num2;
                } else if (item.equals("/")) {
                    res = num1 / num2;
                } else {
                    throw new RuntimeException("输入的运算符有误");
                }
                stack.push("" + res);
            }
        }
        return Integer.parseInt(stack.pop());
    }
}

// 增加一个类，获取优先级
class Operation {
    private static int ADD = 1;
    private static int SUB = 1;
    private static int MUL = 2;
    private static int DIV = 2;

    public static int getPriorityValue(String operation) {
        int res = 0;
        switch (operation) {
            case "+":
                res = ADD;
                break;
            case "-":
                res = SUB;
                break;
            case "*":
                res = MUL;
                break;
            case "/":
                res = DIV;
                break;
            default:
                System.out.println("some errors here !");
                break;
        }
        return res;
    }
}
