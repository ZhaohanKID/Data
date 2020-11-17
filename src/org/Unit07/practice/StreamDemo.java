package org.Unit07.practice;

import org.junit.Test;

import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * @Author: Z.HAN
 * @Date: 2020/11/13 17:20
 */
public class StreamDemo {
    @Test
    public void test1() {
        // 1 创建无限流
        // 遍历前10个偶数

        Stream.generate(Math::random).limit(10).forEach(System.out::println);

/*        Stream.iterate(0, new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                boolean b = integer % 2 == 0;
                return b;
            }
        });*/
    }
}
