package org.Unit06.leecode;

/**
 * @ Author: Z.HAN
 * @ Date: 2020/12/22 19:52
 */
public class test8 {
    public static void main(String[] args) {
        StringBuffer str = new StringBuffer("We Are Happy");
        String s = new Solution8().replaceSpace(str);
        String s1 = new Solution8().replace(str);
        System.out.println(s);
        System.out.println(s1);
    }
}
class Solution8 {
    public boolean Find(int target, int [][] array) {
        if (array.length == 0 || array[0].length == 0) {
            return false;
        }
        int m = 0;
        int n = array[0].length - 1;
        int temp = array[m][n];
        while (temp != target) {
            if (m < array[0].length && n > 0) {
                if (temp < target) {
                    m += 1;
                } else {
                    n -= 1;
                }
                temp = array[m][n];
            } else {
                return false;
            }
        }
        return true;
    }

    public String replaceSpace(StringBuffer str) {
        // 开辟一个新的字符串
        StringBuffer stb = new StringBuffer();
        char[] chars = str.toString().toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ' ') {
                stb.append("%20");
            } else {
                stb.append(chars[i]);
            }
        }
        return stb.toString();
    }

    public String replace(StringBuffer str) {
        // 不开辟一个新的字符串。
        // 从前往后计数，给字符串扩容；从后往前填充%20
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                count++;
            }
        }
        int oldIndex = str.length() - 1;
        int newLength = str.length() + 2 * count;
        int newIndex = newLength - 1;
        str.setLength(newLength);
        while (oldIndex >= 0 && oldIndex < newIndex) {
            if (str.charAt(oldIndex) == ' ') {
                str.setCharAt(newIndex--, '0');
                str.setCharAt(newIndex--, '2');
                str.setCharAt(newIndex--, '%');
            } else {
                str.setCharAt(newIndex--, str.charAt(oldIndex));
            }
            oldIndex--;
        }
        return str.toString();
    }
}
