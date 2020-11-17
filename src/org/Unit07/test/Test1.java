package org.Unit07.test;

import org.junit.Test;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Stream中间操作 演示案例
 * @Author: Z.HAN
 * @Date: 2020/11/13 17:48
 */
public class Test1 {
    @Test
    public void test1() {
        List<Employee> list = EmployeeData.getEmployees();
        // 创建流对象
        Stream<Employee> stream = list.stream();
        // 1 filter 过滤
        /*stream.filter(new Predicate<Employee>() {
            @Override
            public boolean test(Employee employee) {
                return employee.getSalary() > 7000;
            }
        });*/
        stream.filter(employee -> employee.getSalary()> 7000).forEach(System.out::println);

        // 查询员工中年龄大于20岁的员工信息
        //list.stream().filter(employee -> employee.getAge() > 20).forEach(System.out::println);

        // 跳过前5条
        System.out.println("---------------------");
        //list.stream().skip(5).forEach(System.out::println);

        // distinct：筛选
        list.add(new Employee(1002, "马云", 13, 9876.12));
        list.add(new Employee(1002, "马云", 14, 9876.12));
        list.add(new Employee(1002, "马云", 15, 9876.12));
        list.add(new Employee(1002, "马云", 12, 9876.12));
        list.add(new Employee(1002, "马云", 12, 9876.12));

        list.stream().distinct().forEach(System.out::println);
    }

    @Test
    public void test2() {
        List<String> list = Arrays.asList("aa", "bb", "cc");
        list.stream().map(s -> s.toUpperCase()).forEach(System.out::println);

        // 获取员工姓名长度大于3的员工名
        List<Employee> list2 = EmployeeData.getEmployees();
        list2.stream().map(employee -> employee.getName()).filter(s -> s.length() > 3).forEach(System.out::println);

/*        list2.stream().map(new Function<Employee, String>() {
            @Override
            public Predicate<String> apply(Employee employee) {
                return new Predicate<String>(){
                    @Override
                    public boolean test(String s) {
                        return s.length() > 3;
                    }
                };
            }
        });*/
    }

    // 将字符串转化成字符集合，并返回相应的stream流
    public static Stream<Character> fromStringToStream(String s) {
        ArrayList<Character> list = new ArrayList<>();
        for (char c : s.toCharArray()) {
            list.add(c);
        }
        return list.stream();
    }

    @Test
    public void test3() {
        List<String> list = Arrays.asList("aa", "bb", "cc");
        Stream<Stream<Character>> stream =
                list.stream().map(s -> fromStringToStream(s));
        stream.forEach(characterStream ->
                characterStream.forEach(System.out::println));


        list.stream().map(s -> fromStringToStream(s)).forEach(characterStream -> characterStream.forEach(System.out::println));

        list.stream().map(s -> fromStringToStream(s)).forEach(System.out::println);

        /*for (String s : list) {
            fromStringToStream(s);
        }*/
    }

    @Test
    public void test4() {
        // 自然排序
        List<Integer> list = Arrays.asList(1, 31, 5, 4, 23, 0);
        list.stream().sorted().forEach(System.out::println);
        // 以员工年龄进行排序，应该先去员工类中实现Comparable接口

        // 比较器排序
        // final 指向地址，地址不能变，但是这个地址堆内存中的内容可以改变
        List<Employee> list1 = EmployeeData.getEmployees();
        list1.stream().sorted((o1, o2) -> o1.getAge() - o2.getAge()).forEach(System.out::println);
    }

    // 终止操作
    @Test
    public void test5() {
        List<Employee> list = EmployeeData.getEmployees();
        // 检查员工年龄是否都已满18岁
        // 检验集合中的所有元素是否满足此规则
        boolean b = list.stream().allMatch(employee -> employee.getAge() > 18);
        System.out.println(b);

        boolean b2 = list.stream().anyMatch(e -> e.getAge() > 18);
        System.out.println(b2);

        boolean b3 = list.stream().noneMatch(e -> e.getName().startsWith("马"));
        System.out.println(b3);

        Optional<Employee> first = list.stream().findFirst();
        System.out.println(first);

        Optional<Employee> any = list.parallelStream().findAny();
        System.out.println(any);

        System.out.println(list.stream().count());


    }

    @Test
    public void test6() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        /*list.stream().reduce(new BinaryOperator<Integer>() {
            @Override
            public Integer apply(Integer integer, Integer integer2) {
                return integer + integer2;
            }
        });*/
        Optional<Integer> reduce = list.stream().reduce((integer, integer2) -> integer + integer2);
        System.out.println(reduce);

        List<Employee> list1 = EmployeeData.getEmployees();
        List<Employee> collect = list1.stream().filter(e -> e.getSalary() > 6000).collect(Collectors.toList());
        System.out.println(collect);
        collect.forEach(System.out::println);

    }
}
