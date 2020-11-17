package org.Unit07.practice;

import org.junit.Test;

import java.util.Arrays;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @Author: Z.HAN
 * @Date: 2020/11/7 16:44
 */
public class ConstructDemo {
    @Test
    public void test1() {
        // Lambda表达式
        Supplier<Student> supplier = () -> new Student();
        Student student = supplier.get();
        System.out.println(student);
        // 构造器引用
        Supplier<Student> supplier1 = Student::new;
        System.out.println(supplier1.get());
    }
    @Test
    public void test2() {
        Function<String, Student> function =s->new Student(s);

        Student student = function.apply("终南山");
        System.out.println(student);

        // 构造器引用
        Function<String, Student> function1 = Student::new;
        Student student1 = function1.apply("袁隆平");
        System.out.println(student1);
    }
    @Test
    public void test3() {
        BiFunction<String, Integer, Student> bf = (s, i) -> new Student(s, i);
        Student s1 = bf.apply("南宫且欲", 20);
        System.out.println(s1);

        BiFunction<String, Integer,Student> bf2 = Student::new;
        Student s2 = bf2.apply("宫崎骏", 15);
        System.out.println(s2);
    }
    @Test
    public void test4() {
        // Lambda 表达式
        Function<Integer, String[]> function = (Integer integer) -> new String[integer];
        String[] strings = function.apply(10);
        System.out.println(Arrays.toString(strings));

        // 数组引用
        Function<Integer, String[]> function1 = String[]::new;
        String[] strings1 = function1.apply(10);
        System.out.println(Arrays.toString(strings1));
    }
}
