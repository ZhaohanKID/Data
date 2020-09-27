package org.Unit01.Regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 正则表达式的获取功能：
 *      Pattern 和 Matcher 类的使用：
 *
 *          wo shi gang tie xia hahaha wo zhen de shi gang tie xia
 *          找出这个字符串中是三个字母组成的。
 */

public class regexDemo3 {
    public static void main(String[] args) {
        // 定义规则
        String regex = "\\b\\w{3}\\b";
        // 将正则表达式编译成模式对象
        Pattern pattern = Pattern.compile(regex);
        // 通过模式对象获得匹配器对象，参数是所要匹配的字符串
        Matcher matcher = pattern.matcher("wo shi gang tie xia hahaha wo zhen de shi gang tie xia");
        // 调用匹配器方法
        while (matcher.find()) {
            String s = matcher.group();
            System.out.println(s);
        }
    }
}
