package org.Unit03.Principle;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Z.HAN
 * @Date: 2020/10/16 18:11
 */
public class extendsDemo {
    public static void main(String[] args) {
        // 符合里氏替换原则
        /* 发生了方法的重载
        父类方法被调用
        父类方法被调用
         */
        Father father = new Father();
        father.method(new HashMap());

        Son son = new Son();
        son.method(new HashMap());
    }
}
class Father {
    public void method(HashMap map) {
        System.out.println("父类方法被调用");
    }
}
class Son extends Father {
    public void method(Map map) {
        System.out.println("子类方法被调用");
    }
}
class GrandSon {

}
